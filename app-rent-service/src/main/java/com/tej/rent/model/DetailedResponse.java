package com.tej.rent.model;

import com.tej.model.customer.Customer;
import com.tej.model.rent.Rent;
import com.tej.model.vehicle.Vehicle;

public class DetailedResponse implements Response {

	private Rent rent;
	private Customer customer;
	private Vehicle vehicle;

	public DetailedResponse(Rent rent, Customer customer, Vehicle vehicle) {
		this.rent = rent;
		this.customer = customer;
		this.vehicle = vehicle;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
