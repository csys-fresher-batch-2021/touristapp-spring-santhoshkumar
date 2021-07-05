package in.santhosh.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import org.springframework.stereotype.Component;

import in.santhosh.exception.ValidationException;

@Component
public class Validation {
	private Validation() {

	}

	/**
	 * This method validates string
	 * 
	 * @param validateString
	 * @return
	 */

	public boolean stringValidation(String validateString) {
		boolean isValidString = true;
		if (validateString.trim().equals("")) {
			isValidString = false;
		}
		for (int index = 0; index < validateString.length(); index++) {
			if (validateString.charAt(index) >= '0' && validateString.charAt(index) <= '9') {
				isValidString = false;
			}
		}

		return isValidString;
	}

	/**
	 * This method validates the journey start date
	 * 
	 * @param validateDate
	 * @return
	 */
	public boolean dateValidation(LocalDate validateDate) {
		LocalDate date = LocalDate.now();
		boolean isValidStartDate = true;
		if (validateDate.isBefore(date)) {
			isValidStartDate = false;
		}
		return isValidStartDate;

	}

	/**
	 * This method validates the journey end date
	 * 
	 * @param startDate
	 * @param validateDate
	 * @return
	 */
	public boolean dateValidationEnd(LocalDate startDate, LocalDate validateDate) {
		boolean isValidateEndDate = true;
		if (validateDate.isBefore(startDate)) {
			isValidateEndDate = false;
		}
		return isValidateEndDate;

	}

	/**
	 * This method validates the flight time
	 * 
	 * @param flightTime
	 * @return
	 */
	public boolean timeValidation(LocalTime flightTime) {
		LocalTime time = LocalTime.now();
		boolean isValidTime = true;
		if (flightTime.isBefore(time)) {
			throw new ValidationException("Entered time is before the current time");
		}
		return isValidTime;
	}

	/**
	 * This method is used to validate no of passengers
	 */
	public boolean dayValidation(int days) {
		boolean isValidNumberOfDays = true;
		if (days <= 0) {
			throw new ValidationException("Entered number of days is less than or equal to zero");
		}
		return isValidNumberOfDays;

	}

	/**
	 * This method calculate the difference between two days
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int differenceBetweenDate(LocalDate startDate, LocalDate endDate) {
		Period difference = Period.between(startDate, endDate);
		return difference.getDays();

	}

	/**
	 * This method checks whether the package price is greater than 10000
	 * 
	 * @param price
	 * @return
	 */
	public boolean packagePrice(int price) {
		boolean validPackagePrice = true;
		if (price <= 10000) {
			validPackagePrice = false;
		}
		return validPackagePrice;

	}

}
