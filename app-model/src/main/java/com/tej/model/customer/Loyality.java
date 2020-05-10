package com.tej.model.customer;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Tej pratap 
 * tejpratapk@gmail.com 
 * on 27-April-2020 20:32
 * @Project app-modal
 */

@Entity
@Table(name = "loyalityPoint")
@Data
public class Loyality {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int transactionId;
	@ManyToOne
	@JoinColumn
	Customer customer;
	int point;
	LocalDateTime expireDate;
	
}
