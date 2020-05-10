package com.tej.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tej.model.rent.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
