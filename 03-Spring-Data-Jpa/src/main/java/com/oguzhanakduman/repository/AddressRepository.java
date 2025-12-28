package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhanakduman.entites.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
