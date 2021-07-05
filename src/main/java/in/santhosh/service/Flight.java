package in.santhosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.santhosh.dao.FlightRepository;
import in.santhosh.exception.ServiceException;
import in.santhosh.model.FlightDetail;
import in.santhosh.validator.FlightDetailValidation;

@Service
public class Flight {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	FlightDetailValidation flightDetailValidation;

	/**
	 * This method is used to add flight details into database
	 * 
	 * @param flightDetail
	 */

	public void addFlight(FlightDetail flightDetail) {
		try {
			if (flightDetailValidation.validFlightDetail(flightDetail)) {
				flightRepository.save(flightDetail);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This method is used to get all flights from database
	 * 
	 * @return
	 */

	public Iterable<FlightDetail> getAllFlight() {
		return flightRepository.findAll();
	}

	/**
	 * This method is used to remove flight from database
	 * 
	 * @param flightId
	 */

	public void removeFlight(int flightId) {
		flightRepository.deleteById(flightId);
	}

}
