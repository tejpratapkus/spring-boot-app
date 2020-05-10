package com.tej.vehicle.service;

import java.util.List;

import com.tej.model.vehicle.Vehicle;

public interface VehicleService {

	Vehicle save(Vehicle vehicle);

	Vehicle findById(int id);

	List<Vehicle> findAll();

}
