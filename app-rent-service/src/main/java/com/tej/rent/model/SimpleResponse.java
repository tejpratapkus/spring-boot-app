package com.tej.rent.model;

import com.tej.model.rent.Rent;

public class SimpleResponse implements Response {

	private Rent rent;

	public SimpleResponse(Rent rent) {
		this.rent = rent;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

}
