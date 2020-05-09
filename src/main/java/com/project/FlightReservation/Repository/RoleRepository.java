package com.project.FlightReservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FlightReservation.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
