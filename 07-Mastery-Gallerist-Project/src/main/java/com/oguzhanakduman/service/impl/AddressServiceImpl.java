package com.oguzhanakduman.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoAddressIU;
import com.oguzhanakduman.model.Address;
import com.oguzhanakduman.repository.AddressRepository;
import com.oguzhanakduman.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	AddressRepository addressRepository;
	
	private Address createAddress(DtoAddressIU dtoAddressIU) {
		Address address = new Address();
		address.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAddressIU, address);
		return address;
		
	}

	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
		DtoAddress dtoAddress = new DtoAddress();
		
		Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}

}
