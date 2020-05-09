package com.project.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FlightReservation.Entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
