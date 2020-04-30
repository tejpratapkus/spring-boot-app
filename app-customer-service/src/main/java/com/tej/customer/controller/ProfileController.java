package com.tej.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tej.customer.service.CustomerService;
import com.tej.modal.customer.Customer;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public Customer fetch(@RequestParam int profileId) {
		return customerService.fetchById(profileId);
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public List<Customer> fetch() {
		return customerService.fetchAllProfiles();
	}
}
