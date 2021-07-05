package in.santhosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.santhosh.dao.EnquiryRepository;
import in.santhosh.dto.EnquiryPackageDTO;
import in.santhosh.exception.ServiceException;

@Service
public class PackageEnquiry {

	@Autowired
	EnquiryRepository enquiryRepository;

	/**
	 * This method is used to get all enquiry details from database
	 * 
	 * @return
	 */

	public Iterable<EnquiryPackageDTO> getAllEnquiry() {
		return enquiryRepository.getAllEnquiry();
	}

	/**
	 * This method is used to update the enquiry status of specific user
	 * 
	 * @param enquiryId
	 */

	public void updateEnquiryStatus(int enquiryId) {
		try {
			enquiryRepository.updateEnquiry(enquiryId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
