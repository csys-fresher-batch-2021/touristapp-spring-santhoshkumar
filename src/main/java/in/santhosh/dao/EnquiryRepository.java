package in.santhosh.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.santhosh.dto.EnquiryPackageDTO;

@Repository
public class EnquiryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Iterable<EnquiryPackageDTO> getAllEnquiry() {
		String sql = "select enquiry_detail.enquiry_id, enquiry_detail.user_name, enquiry_detail.mobile_number,enquiry_detail.status,package_detail.package_name, package_detail.package_price, package_detail.number_of_days, package_detail.start_date, package_detail.end_date, package_detail.hotel_name from enquiry_detail inner join package_detail on enquiry_detail.enquiry_package_id=package_detail.package_id";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			EnquiryPackageDTO enquiryPackage = new EnquiryPackageDTO();
			int id = rs.getInt("enquiry_id");
			String name = rs.getString("user_name");
			long mobileNumber = rs.getLong("mobile_number");
			String status = rs.getString("status");
			String packageName = rs.getString("package_name");
			int packagePrice = rs.getInt("package_price");
			int numberOfDays = rs.getInt("number_of_days");
			LocalDate startDate = rs.getDate("start_date").toLocalDate();
			LocalDate endDate = rs.getDate("end_date").toLocalDate();
			String hotelName = rs.getString("hotel_name");
			enquiryPackage.setEnquiryId(id);
			enquiryPackage.setName(name);
			enquiryPackage.setMobileNumber(mobileNumber);
			enquiryPackage.setStatus(status);
			enquiryPackage.setPackageName(packageName);
			enquiryPackage.setPackagePrice(packagePrice);
			enquiryPackage.setNumberOfDays(numberOfDays);
			enquiryPackage.setStartDate(startDate);
			enquiryPackage.setEndDate(endDate);
			enquiryPackage.setHotelName(hotelName);
			return enquiryPackage;
		});

	}

	public void updateEnquiry(int enquiryId) {
		String sql = "UPDATE enquiry_detail SET status=? WHERE enquiry_id=?";
		Object[] params = { "Completed", enquiryId };
		jdbcTemplate.update(sql, params);
	}

}
