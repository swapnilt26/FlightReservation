package com.project.FlightReservation.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.FlightReservation.Entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("select f from Flight f where f.departureCity= ?1 and f.arrivalCity= ?2 and f.dateOfDeparture= ?3")
	List<Flight> findFlights(@Param("departureCity") String departureCity,@Param("arrivalCity") String arrivalCity,@Param("dateOfDeparture") Date dateOfDeparture);

}
