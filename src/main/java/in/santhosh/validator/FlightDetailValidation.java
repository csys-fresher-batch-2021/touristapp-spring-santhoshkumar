package in.santhosh.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.santhosh.exception.AlreadyExistException;
import in.santhosh.exception.FlightValidationException;
import in.santhosh.model.FlightDetail;

@Component
public class FlightDetailValidation {
	private FlightDetailValidation() {

	}

	@Autowired
	Validation validation;

	/**
	 * This method is used to validate all flight details
	 * 
	 * @param flightDetail
	 * @return
	 */
	public boolean validFlightDetail(FlightDetail flightDetail) {
		boolean validDetail = true;
		if (!validation.dateValidation(flightDetail.getJourneyDate())) {
			throw new FlightValidationException("Enter the journey date correctly");
		}
		return validDetail;
	}

	/**
	 * This method is used to check whether admin added flight is already exists
	 * 
	 * @param flightDetail
	 * @return
	 */
	public boolean existingFlightDetail(FlightDetail flightDetail, List<FlightDetail> flightList) {
		boolean isExists = false;
		for (FlightDetail flights : flightList) {
			if (flights.getCountryName().equals(flightDetail.getCountryName())
					&& flights.getStatus().equals(flightDetail.getStatus())
					&& flights.getJourneyDate().equals(flightDetail.getJourneyDate())) {
				throw new AlreadyExistException("Flight Already Exists");
			}

		}
		return isExists;

	}
}
