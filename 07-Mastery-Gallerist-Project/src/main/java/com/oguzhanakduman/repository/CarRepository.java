package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguzhanakduman.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
