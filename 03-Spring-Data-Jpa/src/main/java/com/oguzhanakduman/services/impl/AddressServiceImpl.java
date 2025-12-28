package com.oguzhanakduman.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoCustomer;
import com.oguzhanakduman.entites.Address;
import com.oguzhanakduman.entites.Customer;
import com.oguzhanakduman.repository.AddressRepository;
import com.oguzhanakduman.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	public DtoAddress findAddressById(Long id) {
		DtoAddress dtoAddress = new DtoAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		
		Optional<Address> optional = addressRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		Address address = optional.get();
		Customer customer = optional.get().getCustomer();
		
		BeanUtils.copyProperties(address, dtoAddress);
		BeanUtils.copyProperties(customer, dtoCustomer);
		
		dtoAddress.setCustomer(dtoCustomer);
		
		return dtoAddress;
	}

}
