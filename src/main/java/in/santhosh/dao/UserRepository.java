package in.santhosh.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.santhosh.model.UserDetail;

@Repository
public interface UserRepository extends CrudRepository<UserDetail, Integer> {

	@Query("SELECT user_id FROM user_detail WHERE mobile_number=:mobileNumber AND user_password=:password")
	Integer findByUserNameAndPassword(@Param("mobileNumber") long mobileNumber, @Param("password") String password);

}
