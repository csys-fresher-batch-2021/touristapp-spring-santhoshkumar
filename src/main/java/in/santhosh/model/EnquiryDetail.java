package in.santhosh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class EnquiryDetail {

	@Id
	@Column("enquiry_id")
	private int enquiryId;
	@Column("user_name")
	private String name;
	@Column("mobile_number")
	private long mobileNumber;
	@Column("status")
	private String status;
	@Column("enquiry_package_id")
	private int packageId;

}
