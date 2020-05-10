package com.tej.model.customer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Tej pratap 
 * tejpratapk@gmail.com 
 * on 27-April-2020 20:32
 * @Project app-modal
 */

@Entity
@Table(name = "customer")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String firstName;
	private String lastName;
	private String dlNumber;
	private String zipcode;
	@OneToMany(mappedBy = "customer")
	private List<Loyality> loyalities;
	
}
