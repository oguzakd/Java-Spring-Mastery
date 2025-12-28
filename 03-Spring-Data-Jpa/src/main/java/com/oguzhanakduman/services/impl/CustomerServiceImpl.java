package com.oguzhanakduman.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoCustomer;
import com.oguzhanakduman.entites.Address;
import com.oguzhanakduman.entites.Customer;
import com.oguzhanakduman.repository.CustomerRepository;
import com.oguzhanakduman.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		Customer customer = optional.get();
		Address address = optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
	}
}
