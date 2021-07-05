package in.santhosh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.dto.Message;
import in.santhosh.model.AdminDetail;
import in.santhosh.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("AdminLoginAction")
	public ResponseEntity<Message> adminLogin(@RequestBody AdminDetail adminDetail, HttpServletRequest request) {
		HttpStatus httpStatus = null;
		Message message = new Message();

		try {
			Integer id = adminService.adminLogin(adminDetail.getMobileNumber(), adminDetail.getPassword());
			if (id == null) {
				message.setErrorMessage("Invalid Login Credentials");
				httpStatus = HttpStatus.BAD_REQUEST;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("ROLE", "ADMIN");
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
