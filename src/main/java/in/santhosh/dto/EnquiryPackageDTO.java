package in.santhosh.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EnquiryPackageDTO {
	private String name;
	private long mobileNumber;
	private String packageName;
	private int numberOfDays;
	private LocalDate startDate;
	private LocalDate endDate;
	private String hotelName;
	private int packagePrice;
	private int enquiryId;
	private String status;

}
