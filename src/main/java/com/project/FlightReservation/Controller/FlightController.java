package com.project.FlightReservation.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FlightReservation.Entities.Flight;
import com.project.FlightReservation.Repository.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	FlightRepository flightRepo;

	@RequestMapping(value="/findflight", method=RequestMethod.GET)
	public String getLogin()					
	{
		LOGGER.info("Inside getLogin() Method");
		return "findflight";
	}
	
	@RequestMapping(value="/findflight", method=RequestMethod.POST)
	public String findflight(@RequestParam String departurecity, @RequestParam String arrivalcity, 
			 @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date traveldate, ModelMap model, HttpServletRequest req)
	{
		LOGGER.info("Inside findflight() Method with DepartureCity as: "+departurecity+" ArrivalCity as: "+arrivalcity+" TravleDate as: "+traveldate);
		List<Flight> flight = flightRepo.findFlights(departurecity, arrivalcity, traveldate);
		model.addAttribute("find",  flight);
		return "displayflights";
	}
	
	@RequestMapping("/admin/addFlight")
	public String addFlight()
	{
		return "addFlight";
	}
}
