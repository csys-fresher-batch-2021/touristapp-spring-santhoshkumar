package in.santhosh.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.santhosh.dto.Message;
import in.santhosh.exception.AlreadyExistException;
import in.santhosh.exception.FlightValidationException;
import in.santhosh.exception.PackageValidationException;
import in.santhosh.exception.RegistrationValidationException;
import in.santhosh.exception.ServiceException;
import in.santhosh.exception.ValidationException;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = AlreadyExistException.class)
	public ResponseEntity<Message> alreadyExistException(AlreadyExistException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<Message> validationException(ValidationException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<Message> serviceException(ServiceException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = FlightValidationException.class)
	public ResponseEntity<Message> flightValidationException(FlightValidationException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = PackageValidationException.class)
	public ResponseEntity<Message> packageValidationException(PackageValidationException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RegistrationValidationException.class)
	public ResponseEntity<Message> registrationValidationException(RegistrationValidationException exception) {
		Message message = new Message();
		message.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}
