package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhanakduman.entites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
