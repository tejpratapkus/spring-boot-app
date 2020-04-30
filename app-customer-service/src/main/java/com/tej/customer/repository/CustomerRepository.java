package com.tej.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tej.modal.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
