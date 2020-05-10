package com.tej.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tej.model.vehicle.Vehicle;
import com.tej.vehicle.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle findById(int id) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

		if (vehicleOptional.isPresent()) {
			return vehicleOptional.get();
		}
		return new Vehicle();
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

}
