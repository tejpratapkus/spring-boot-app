package com.tej.customer.service;

import java.util.List;

import com.tej.model.customer.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	Customer findById(int id);

	List<Customer> findAll();
}
