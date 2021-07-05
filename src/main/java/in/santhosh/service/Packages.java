package in.santhosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.santhosh.dao.CustomSearchRepository;
import in.santhosh.dao.PackageRepository;
import in.santhosh.exception.ServiceException;
import in.santhosh.model.TourPackageDetail;
import in.santhosh.validator.PackageValidator;

@Service
public class Packages {
	private Packages() {

	}

	@Autowired
	PackageRepository packageRepository;

	@Autowired
	PackageValidator packageValidator;

	@Autowired
	CustomSearchRepository customSearch;

	/**
	 * This method is used to get all package detail
	 * 
	 * @return
	 */
	public Iterable<TourPackageDetail> getAllPackages() {
		return packageRepository.findAll();
	}

	/**
	 * This method is used to remove package from database
	 * 
	 * @param id
	 */

	public void removePackage(int id) {
		try {
			packageRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to add package into database
	 * 
	 * @param packageDetail
	 */

	public void addPackage(TourPackageDetail packageDetail) {
		try {
			if (packageValidator.validatePackage(packageDetail)) {
				packageRepository.save(packageDetail);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to filter the package based on customer choice
	 * 
	 * @param packagePrice
	 * @param days
	 * @param countryName
	 * @return
	 */
	public Iterable<TourPackageDetail> customSearch(String packagePrice, String days, String countryName) {
		int price = 0;
		int totalDays = 0;
		if (packagePrice.length() >= 1) {
			price = Integer.parseInt(packagePrice);
		}
		if (days.length() >= 1) {
			totalDays = Integer.parseInt(days);
		}
		if (countryName.length() <= 0) {
			countryName = null;
		}
		return customSearch.customSearch(price, totalDays, countryName);
	}

}
