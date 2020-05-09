package com.project.FlightReservation.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.FlightReservation.Entities.Flight;
import com.project.FlightReservation.Entities.Passenger;
import com.project.FlightReservation.Entities.Reservation;
import com.project.FlightReservation.Repository.FlightRepository;
import com.project.FlightReservation.Repository.PassengerRepository;
import com.project.FlightReservation.Repository.ReservationRepository;
import com.project.FlightReservation.Utility.EmailUtil;
import com.project.FlightReservation.Utility.PDFGenerator;
import com.project.FlightReservation.dto.ReservationRequest;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${Itinerary_dirPath}")
	private String FILE_PATH;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	EmailUtil email;
	
	@Autowired
	PDFGenerator pdf;
	
	@Override
	@Transactional
	public Reservation bookflight(ReservationRequest request) 
	{	
		
		LOGGER.info("Inside bookflight() Method"); 
		Flight flight = flightRepo.findById(request.getFlightId()).get();
		LOGGER.info("Fetching Flight for Flight ID: "+request.getFlightId());
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerfirstName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerMobile());
		LOGGER.info("Saving the Passenger: "+passenger);
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		
		Reservation res = new Reservation();
		res.setFlight(flight);
		res.setPassenger(savedPassenger);
		res.setCheckedIn(false);
		LOGGER.info("Saving the Reservation: "+res);
		Reservation reservation = reservationRepo.save(res);
		
		String filePath = FILE_PATH+reservation.getId()+".pdf";
		
		LOGGER.info("Generating pdf");
		pdf.generateItinerary(reservation, filePath);
		
		LOGGER.info("Sending EMAIL");
		email.mailItinerary(passenger.getEmail(), filePath);
		
		return reservation;
	}

}
