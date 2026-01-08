package com.oguzhanakduman.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "saled_car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity{

	@ManyToOne
	private Gallerist gallerist;
	
	@ManyToOne
	private Car car;
	
	@ManyToOne
	private Customer customer;
}
