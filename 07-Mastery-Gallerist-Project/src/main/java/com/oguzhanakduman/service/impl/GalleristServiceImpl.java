package com.oguzhanakduman.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoGallerist;
import com.oguzhanakduman.dto.DtoGalleristIU;
import com.oguzhanakduman.exception.BaseException;
import com.oguzhanakduman.exception.ErrorMessage;
import com.oguzhanakduman.exception.MessageType;
import com.oguzhanakduman.model.Address;
import com.oguzhanakduman.model.Gallerist;
import com.oguzhanakduman.repository.AddressRepository;
import com.oguzhanakduman.repository.GalleristRepository;
import com.oguzhanakduman.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService{

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	GalleristRepository galleristRepository;
	
	private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
		Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
		}
		
		Gallerist gallerist = new Gallerist();
		gallerist.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		
		gallerist.setAddress(optAddress.get());
		return gallerist;
		
	}

	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoAddress dtoAddress = new DtoAddress();
		
		Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));
		
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
		
		dtoGallerist.setAddress(dtoAddress);
		return dtoGallerist;
	}

}
