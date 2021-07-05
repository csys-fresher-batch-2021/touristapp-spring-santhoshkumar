package in.santhosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.dto.Message;
import in.santhosh.model.TourPackageDetail;
import in.santhosh.service.Packages;
import in.santhosh.validator.PackageValidator;
import in.santhosh.validator.Validation;

@RestController
public class PackageController {

	@Autowired
	Packages packages;

	@Autowired
	PackageValidator packageValidator;

	@Autowired
	Validation validation;

	@GetMapping("ListofPackagesAction")
	public Iterable<TourPackageDetail> packageList() {
		return packages.getAllPackages();
	}

	@GetMapping("RemovePackageAction")
	public ResponseEntity<Message> removePackage(@RequestParam("id") int id) {
		packages.removePackage(id);
		Message message = new Message();
		message.setInfoMessage("Removed Successfully");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("AddPackagesAction")
	public ResponseEntity<Message> addPackage(@RequestBody TourPackageDetail packageDetail) {
		Message message = new Message();
		List<TourPackageDetail> packageList = (List<TourPackageDetail>) packages.getAllPackages();
		if (validation.differenceBetweenDate(packageDetail.getStartDate(), packageDetail.getEndDate()) == packageDetail
				.getNumberOfDays()) {
			if (!packageValidator.existsingPackage(packageDetail, packageList)) {
				packages.addPackage(packageDetail);
				message.setInfoMessage("Added Successfully");
			}
		} else {
			message.setInfoMessage("Enter the Start date and End date correctly");

		}
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping("CustomSearchAction")
	public Iterable<TourPackageDetail> customSearch(@RequestParam("packagePrice") String packagePrice,
			@Param("countryName") String countryName, @RequestParam("days") String days) {
		return packages.customSearch(packagePrice, days, countryName);
	}

}
