package com.tej.vehicle.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tej.model.vehicle.Vehicle;
import com.tej.vehicle.service.VehicleService;

@RestController
@RequestMapping("/service")
public class VehicleController {

	/*
	 * @Autowired private AuthConfiguration authConfiguration;
	 */
	@Autowired
	private VehicleService vehicleService;

	/*
	 * @RequestMapping("/profile") public String getConfig(Model model) {
	 * model.addAttribute("model", authConfiguration.getDefaultModel());
	 * model.addAttribute("min", authConfiguration.getMinimumRent()); return
	 * "mprofile";
	 * 
	 * }
	 */

	@PostMapping(value = "/vehicles")
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);
	}

	@GetMapping(value = "/vehicles/{id}")
	public Vehicle getVehicle(@PathVariable int id) {
		System.out.println("request came on " + LocalDateTime.now() + "  ++++++++++++++++++++++");
		return vehicleService.findById(id);
	}

	@GetMapping(value = "/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.findAll();
	}
}
