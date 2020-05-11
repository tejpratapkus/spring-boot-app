package com.tej.rent.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.tej.model.customer.Customer;
import com.tej.model.rent.Rent;
import com.tej.model.vehicle.Vehicle;
import com.tej.rent.hystrix.CommonHystrixCommand;
import com.tej.rent.hystrix.CustomerHystrixCommand;
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
	
	@Autowired
	HystrixCommand.Setter setter;

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
		//Vehicle vehicle = restTemplate.getForObject("http://vehicle/services/vehicle/" + vehicleId,
		//		Vehicle.class);
		
		 CommonHystrixCommand<Vehicle> vehicleCommonHysctrixCommand=new CommonHystrixCommand<Vehicle>("default",()->
	        {
	            return restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
	        },()->{
	            return new Vehicle();
	        });

	        Future<Vehicle> vehicleFuture=vehicleCommonHysctrixCommand.queue();
	        return vehicleFuture.get();	
		//return vehicle;
	}

	private Customer getCustomer(int customerId) {
		//Customer customer = restTemplate.getForObject("http://customer/services/customers/" + customerId,
		//		Customer.class);
		CustomerHystrixCommand customerHystrixCommand = new CustomerHystrixCommand(restTemplate, customerId);
		return customerHystrixCommand.execute();
	}

}
