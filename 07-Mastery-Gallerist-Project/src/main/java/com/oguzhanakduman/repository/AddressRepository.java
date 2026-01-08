package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguzhanakduman.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	
}
