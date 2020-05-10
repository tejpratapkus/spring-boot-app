package com.tej.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tej.model.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
