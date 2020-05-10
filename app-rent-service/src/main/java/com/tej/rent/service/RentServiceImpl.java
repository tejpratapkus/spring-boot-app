package com.tej.rent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tej.model.customer.Customer;
import com.tej.model.rent.Rent;
import com.tej.model.vehicle.Vehicle;
import com.tej.rent.model.DetailedResponse;
import com.tej.rent.model.Response;
import com.tej.rent.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService {

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Rent save(Rent rent) {
		return rentRepository.save(rent);
	}

	@Override
	public Rent findById(int id) {

		Optional<Rent> rentOptional = rentRepository.findById(id);
		if (rentOptional.isPresent()) {
			return rentOptional.get();
		}
		return new Rent();
	}

	@Override
	public Response findDetailedResponse(int id) {
		Rent rent = findById(id);
		Customer customer = getCustomer(rent.getCustomerId());
		Vehicle vehicle = getVehichle(rent.getVehicleId());
		return new DetailedResponse(rent, customer, vehicle);
	}

	@Override
	public List<Rent> findAll() {
		return rentRepository.findAll();
	}

	private Vehicle getVehichle(int vehicleId) {
		Vehicle vehicle = restTemplate.getForObject("http://localhost:8080/services/vehicle/" + vehicleId,
				Vehicle.class);
		return vehicle;
	}

	private Customer getCustomer(int customerId) {
		Customer customer = restTemplate.getForObject("http://localhost:8080/services/customers/" + customerId,
				Customer.class);
		return customer;
	}

}
