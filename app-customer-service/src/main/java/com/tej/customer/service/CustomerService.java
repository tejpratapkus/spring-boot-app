package com.tej.customer.service;

import java.util.List;

import com.tej.modal.customer.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	Customer fetchById(int profileId);

	List<Customer> fetchAllProfiles();
}
