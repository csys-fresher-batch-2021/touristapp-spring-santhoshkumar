package in.santhosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.santhosh.dto.Message;
import in.santhosh.model.FlightDetail;
import in.santhosh.service.Flight;
import in.santhosh.validator.FlightDetailValidation;

@RestController

public class FlightController {

	@Autowired
	Flight flight;

	@Autowired
	FlightDetailValidation flightDetailValidation;

	@PostMapping("AddFlightAction")
	public ResponseEntity<Message> addFlight(@RequestBody FlightDetail flightDetail) {
		Message message = new Message();
		List<FlightDetail> flightList = (List<FlightDetail>) flight.getAllFlight();
		if (!flightDetailValidation.existingFlightDetail(flightDetail, flightList)) {
			flight.addFlight(flightDetail);
			message.setInfoMessage("Added Successfully");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping("ListOfFlight")
	public Iterable<FlightDetail> getAllFlight() {
		return flight.getAllFlight();
	}

	@GetMapping("RemoveFlightAction")
	public ResponseEntity<Message> removeFlight(@RequestParam("id") int id) {
		Message message = new Message();
		flight.removeFlight(id);
		message.setInfoMessage("Removed Successfully");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
}
