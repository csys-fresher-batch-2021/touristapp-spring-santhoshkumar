package in.santhosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.dto.EnquiryPackageDTO;
import in.santhosh.dto.Message;
import in.santhosh.service.PackageEnquiry;

@RestController
public class EnquiryController {

	@Autowired
	PackageEnquiry packageEnquiry;

	@GetMapping("ListOfEnquiry")
	public Iterable<EnquiryPackageDTO> getAllEnquiry() {
		return packageEnquiry.getAllEnquiry();
	}

	@GetMapping("UpdateEnquiryStatus")
	public ResponseEntity<Message> updateEnquiryStatus(@RequestParam("id") int id) {
		Message message = new Message();
		HttpStatus httpStatus = null;

		packageEnquiry.updateEnquiryStatus(id);
		message.setInfoMessage("Updated Successfully");
		httpStatus = HttpStatus.OK;
		return new ResponseEntity<>(message, httpStatus);

	}

}
