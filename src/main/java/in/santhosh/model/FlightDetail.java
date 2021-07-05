package in.santhosh.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(value = "flight_detail")

public class FlightDetail {

	@Column("country_name")
	private String countryName;
	@Column("flight_name")
	private String flightName;
	@Column("departure_time")
	private LocalTime departure;
	@Column("arrival_time")
	private LocalTime arrival;
	private String status;
	private String source;
	private String destination;
	@Column("journey_date")
	private LocalDate journeyDate;
	@Id
	@Column("flight_id")
	private int flightId;

}
