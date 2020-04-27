package com.tej.modal.rent;

import java.time.LocalDateTime;

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
@Table(name = "rent")
@Data
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentId;
    private int customerId;
    private int vehicleId;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTill;
    private int currentOdometer;
    private String returnLocation;

}
