package in.santhosh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(value = "user_detail")
public class UserDetail {

	@Id
	@Column("user_id")
	private int id;
	private String name;
	private int age;
	private String gender;
	@Column("mobile_number")
	private long mobileNumber;
	@Column("user_password")
	private String password;
	@Column("retype_password")
	private String reTypePassword;

}
