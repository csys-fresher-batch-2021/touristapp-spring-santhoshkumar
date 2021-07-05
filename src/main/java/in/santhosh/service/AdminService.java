package in.santhosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.santhosh.dao.AdminRepository;
import in.santhosh.exception.ServiceException;
import in.santhosh.validator.UserValidation;

@Service
public class AdminService {

	private AdminService() {

	}

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	UserValidation userValidation;

	/**
	 * This method is used to verify that the entered login credentials are correct
	 * 
	 * @param mobileNumber
	 * @param password
	 * @return
	 */

	public Integer adminLogin(long mobileNumber, String password) {
		Integer adminId = null;
		try {
			if (userValidation.validateMobileNumber(mobileNumber) && userValidation.isValidatePassword(password)) {
				adminId = adminRepository.findByUserNameAndPassword(mobileNumber, password);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());

		}
		return adminId;
	}
}
