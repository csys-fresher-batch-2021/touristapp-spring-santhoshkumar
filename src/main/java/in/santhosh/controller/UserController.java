package in.santhosh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.dto.Message;
import in.santhosh.model.UserDetail;
import in.santhosh.service.UserService;
import in.santhosh.validator.RegistrationValidation;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RegistrationValidation registrationValidation;

	@PostMapping("/RegistrationAction")
	public ResponseEntity<Message> addUser(@RequestBody UserDetail userDetail) {
		HttpStatus httpStatus = null;
		Message message = new Message();
		List<UserDetail> userList = (List<UserDetail>) userService.getAllUsers();
		if (userDetail.getPassword().equals(userDetail.getReTypePassword())) {
			if (!registrationValidation.existsUser(userList, userDetail.getMobileNumber())) {
				userService.addUser(userDetail);
				message.setInfoMessage("Successfully Registered");
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} else {
			message.setErrorMessage("Password and Retype password mismatch");
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(message, httpStatus);
	}

	@GetMapping("/GetAllUsers")
	public Iterable<UserDetail> findAll() {
		return userService.getAllUsers();

	}

	@PostMapping("/UserLoginAction")
	public ResponseEntity<Message> userLogin(@RequestBody UserDetail user, HttpServletRequest request) {
		HttpStatus httpStatus = null;
		Message message = new Message();

		try {
			Integer id = userService.validLogin(user.getMobileNumber(), user.getPassword());
			if (id == null) {
				message.setErrorMessage("Invalid Login Credentials");
				httpStatus = HttpStatus.BAD_REQUEST;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("LOGINUSER", "USER");
				session.setAttribute("LOGINUSER_ID", id);
				message.setInfoMessage("Login Sucessfull");
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(message, httpStatus);
	}
}
