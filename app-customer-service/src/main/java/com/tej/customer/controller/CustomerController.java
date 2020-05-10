package com.tej.customer.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tej.customer.service.CustomerService;
import com.tej.model.customer.Customer;

@RestController
@RequestMapping(value = "/service")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(value = "/customers")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@GetMapping(value = "/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {

		System.out.println("request came on " + LocalDateTime.now() + "  ++++++++++++++++++++++");
		return customerService.findById(id);
	}

	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}
}
