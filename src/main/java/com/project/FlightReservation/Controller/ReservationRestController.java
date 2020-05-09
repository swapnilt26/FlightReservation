package com.project.FlightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlightReservation.Entities.Reservation;
import com.project.FlightReservation.Repository.ReservationRepository;
import com.project.FlightReservation.dto.ReservationUpdateRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@GetMapping("/reservation/{id}")
	public Reservation showReservation(@PathVariable("id") Long id)
	{
		LOGGER.info("Inside showReservation() with Id: "+id);
		return reservationRepo.findById(id).get();
	}
	
	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request)
	{
		LOGGER.info("Inside updateReservation() Method");
		Reservation reserve = reservationRepo.findById(request.getId()).get();
		reserve.setCheckedIn(request.getCheckedIn());
		reserve.setNumberOfBags(request.getNumberOfBags());
		
		LOGGER.info("Saving Reservation With Updated values of CheckIn status and NumberOfBags");
		return reservationRepo.save(reserve);
	}
}
