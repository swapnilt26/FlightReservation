package com.project.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FlightReservation.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
