package com.project.FlightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FlightReservation.Entities.Flight;
import com.project.FlightReservation.Entities.Reservation;
import com.project.FlightReservation.Repository.FlightRepository;
import com.project.FlightReservation.Service.ReservationService;
import com.project.FlightReservation.dto.ReservationRequest;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	FlightRepository flightrepo;
	
	@Autowired
	ReservationService service;
	
	@RequestMapping("/showCompleteReservation")
	public String showReservation(@RequestParam("Flightid") Long id, ModelMap model)
	{
		LOGGER.info("Inside showReservation() Method where Entered Id is: "+id);
		Flight flight= flightrepo.findById(id).get();
		model.addAttribute("reserve",flight);
		return "displayReservationPage";
	}
	
	@RequestMapping("/completereservation")
	public String completeReservation(ReservationRequest request, ModelMap model)
	{
		LOGGER.info("Inside completeReservation() Method");
		Reservation res = service.bookflight(request);
		model.addAttribute("msg", "Reservation Created Successfully and the Id is "+res.getId());
		LOGGER.info("Reservation Completed Successfully with ID: "+res.getId());
		return "reservationConfirmation";
	}
	

}
