package com.tej.rent.service;

import java.util.List;

import com.tej.model.rent.Rent;
import com.tej.rent.model.Response;

public interface RentService {

	Rent save(Rent rent);

	Rent findById(int id);

	Response findDetailedResponse(int id);

	List<Rent> findAll();

}
