package com.project.FlightReservation.Service;

import com.project.FlightReservation.Entities.Reservation;
import com.project.FlightReservation.dto.ReservationRequest;

public interface ReservationService {

	public Reservation bookflight(ReservationRequest request);
	
}
