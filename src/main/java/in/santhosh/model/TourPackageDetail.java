package in.santhosh.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "package_detail")
public class TourPackageDetail {
	/**
	 * This class has package details
	 */
	@Column("package_name")
	private String packageName;
	@Column("package_price")
	private int packagePrice;
	@Column("number_of_days")
	private int numberOfDays;
	@Column("start_date")
	private LocalDate startDate;
	@Column("end_date")
	private LocalDate endDate;
	@Column("hotel_name")
	private String hotelName;
	@Id
	@Column("package_id")
	private int packageId;

}
