package in.santhosh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "admin_detail")
public class AdminDetail {

	@Column("mobile_number")
	private long mobileNumber;
	@Column("user_password")
	private String password;
	@Id
	@Column("admin_id")
	private int id;

}
