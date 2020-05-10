package com.tej.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tej.model.rent.Rent;
import com.tej.rent.model.Response;
import com.tej.rent.model.SimpleResponse;
import com.tej.rent.service.RentService;

@RestController
@RequestMapping("/service")
public class RentController {

	@Autowired
	private RentService rentService;

	@PostMapping("/rent")
	public Rent save(@RequestBody Rent rent) {
		return rentService.save(rent);
	}

	@GetMapping("/rents/{id}")
	public Response getRent(@PathVariable int id, @RequestBody(required = false) String type) {

		if (type == null || "".equals(type)) {
			return new SimpleResponse(rentService.findById(id));
		} else {
			return rentService.findDetailedResponse(id);
		}

	}

	@GetMapping("/rents")
	public List<Rent> findAllRents() {
		return rentService.findAll();
	}

}
