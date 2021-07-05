package in.santhosh.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.santhosh.exception.RegistrationValidationException;
import in.santhosh.model.UserDetail;

@Component
public class RegistrationValidation {

	private RegistrationValidation() {

	}

	@Autowired
	Validation validation;

	@Autowired
	UserValidation userValidation;

	/**
	 * This method is used to validate the user details
	 * 
	 * @param userDetail
	 * @return
	 */
	public boolean validRegistration(UserDetail userDetail) {
		boolean isValidRegistration = true;
		if (!validation.stringValidation(userDetail.getName())) {
			throw new RegistrationValidationException("Enter the name correctly");
		}
		if (!userValidation.validateMobileNumber(userDetail.getMobileNumber())) {
			throw new RegistrationValidationException("Enter the mobile number correctly");
		}
		if (!userValidation.isValidatePassword(userDetail.getPassword())
				&& !userValidation.isValidatePassword(userDetail.getReTypePassword())) {
			throw new RegistrationValidationException(
					"The first letter must be captial and should contain 8 character");
		}
		return isValidRegistration;
	}

	/**
	 * 
	 * @param userList
	 * @param mobileNumber
	 * @return
	 */
	public boolean existsUser(List<UserDetail> userList, long mobileNumber) {
		boolean existsUser = false;
		for (UserDetail user : userList) {
			if (user.getMobileNumber() == mobileNumber) {
				throw new RegistrationValidationException("Already Registered");
			}
		}
		return existsUser;

	}

}
