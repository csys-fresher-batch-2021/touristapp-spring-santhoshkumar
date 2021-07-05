package in.santhosh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.santhosh.model.TourPackageDetail;

@Repository
public class CustomSearchRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<TourPackageDetail> customSearch(int packagePrice, int days, String countryName) {
		String sql;
		List<TourPackageDetail> tourDetail = null;
		if (countryName != null && packagePrice == 0 && days == 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE package_name=?";
			Object[] param = { countryName };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName == null && packagePrice != 0 && days == 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE package_price=?";
			Object[] param = { packagePrice };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName == null && packagePrice == 0 && days != 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE number_of_days=?";
			Object[] param = { days };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName != null && packagePrice > 0 && days == 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE package_name=? AND package_price=?";
			Object[] param = { countryName, packagePrice };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName != null && packagePrice == 0 && days != 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE package_name=? AND number_of_days=?";
			Object[] param = { countryName, days };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName == null && packagePrice != 0 && days != 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail WHERE package_price=? AND number_of_days=?";
			Object[] param = { packagePrice, days };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);
		} else if (countryName != null && packagePrice != 0 && days != 0) {
			sql = "SELECT package_name,package_price,number_of_days,"
					+ "start_date,end_date,hotel_name FROM package_detail "
					+ "WHERE package_name=? AND package_price=? AND number_of_days=?";
			Object[] param = { countryName, packagePrice, days };
			tourDetail = jdbcTemplate.query(sql, (rs, rowNum) -> {
				return toRow(rs);
			}, param);

		}
		return tourDetail;
	}

	private TourPackageDetail toRow(ResultSet result) throws SQLException {
		TourPackageDetail tourPackageDetail = new TourPackageDetail();
		String countryName = result.getString("package_name");
		int packagePrice = result.getInt("package_price");
		int numberOfDays = result.getInt("number_of_days");
		LocalDate startDate = result.getDate("start_date").toLocalDate();
		LocalDate endDate = result.getDate("end_date").toLocalDate();
		String hotelName = result.getString("hotel_name");
		tourPackageDetail.setPackageName(countryName);
		tourPackageDetail.setPackagePrice(packagePrice);
		tourPackageDetail.setNumberOfDays(numberOfDays);
		tourPackageDetail.setStartDate(startDate);
		tourPackageDetail.setEndDate(endDate);
		tourPackageDetail.setHotelName(hotelName);
		return tourPackageDetail;
	}

}
