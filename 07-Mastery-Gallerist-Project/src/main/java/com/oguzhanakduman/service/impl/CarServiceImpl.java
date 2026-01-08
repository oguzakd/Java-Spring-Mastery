package com.oguzhanakduman.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoCar;
import com.oguzhanakduman.dto.DtoCarIU;
import com.oguzhanakduman.model.Car;
import com.oguzhanakduman.repository.CarRepository;
import com.oguzhanakduman.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{
	
	@Autowired
	CarRepository carRepository;
	
	private Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar = new DtoCar();
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		return dtoCar;
	}

}
