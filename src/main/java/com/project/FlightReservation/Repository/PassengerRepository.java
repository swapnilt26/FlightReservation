package com.project.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FlightReservation.Entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
