package in.santhosh.service;

import in.santhosh.validator.RegistrationValidation;
import in.santhosh.validator.UserValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.santhosh.dao.UserRepository;
import in.santhosh.exception.ServiceException;
import in.santhosh.model.UserDetail;

@Service
public class UserService {
	private UserService() {

	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	RegistrationValidation registrationValidation;

	@Autowired
	UserValidation userValidation;

	/**
	 * This method is used to save the user detail into database
	 * 
	 * @param userDetail
	 */

	public void addUser(UserDetail userDetail) {
		try {
			if (registrationValidation.validRegistration(userDetail)) {
				userRepository.save(userDetail);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to get all user detail
	 * 
	 * @return
	 */

	public Iterable<UserDetail> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * This method verify that the user entered correct login credentials
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 */

	public Integer validLogin(long mobileNumber, String password) {
		Integer userId = 0;
		try {
			if (userValidation.validateMobileNumber(mobileNumber) && userValidation.isValidatePassword(password)) {
				userId = userRepository.findByUserNameAndPassword(mobileNumber, password);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return userId;

	}
}
