package in.santhosh.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.santhosh.exception.AlreadyExistException;
import in.santhosh.exception.PackageValidationException;
import in.santhosh.model.TourPackageDetail;

@Component
public class PackageValidator {
	private PackageValidator() {

	}

	@Autowired
	Validation validation;

	/**
	 * This method checks whether it is a valid package
	 * 
	 * @param packages
	 * @return
	 */
	public boolean validatePackage(TourPackageDetail packages) {
		boolean isValidPackage = true;
		if (!validation.dateValidation(packages.getStartDate())) {
			throw new PackageValidationException("Enter the start date correctly");
		}
		if (!validation.dateValidationEnd(packages.getStartDate(), packages.getEndDate())) {
			throw new PackageValidationException("Enter the end date correctly");
		}
		return isValidPackage;
	}

	/**
	 * This method is used to check whether the package is already exists
	 * 
	 * @param packages
	 * @return
	 */

	public boolean existsingPackage(TourPackageDetail packages, List<TourPackageDetail> packageList) {
		boolean isExistPackage = false;
		for (TourPackageDetail tourPackage : packageList) {
			if (tourPackage.getPackageName().equalsIgnoreCase(packages.getPackageName())
					&& tourPackage.getPackagePrice() == packages.getPackagePrice()
					&& tourPackage.getNumberOfDays() == packages.getNumberOfDays()
					&& tourPackage.getStartDate().equals(packages.getStartDate())
					&& tourPackage.getEndDate().equals(packages.getEndDate())) {
				throw new AlreadyExistException("Package already exists");
			}
		}
		return isExistPackage;
	}

}