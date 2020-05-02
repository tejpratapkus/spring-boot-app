package com.tej.model.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Tej pratap 
 * tejpratapk@gmail.com 
 * on 27-April-2020 20:32
 * @Project app-modal
 */

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String make;
	private String model;
	private String type;
	private int year;
	private int odometerValueOnRegister;
	private String color;

}
