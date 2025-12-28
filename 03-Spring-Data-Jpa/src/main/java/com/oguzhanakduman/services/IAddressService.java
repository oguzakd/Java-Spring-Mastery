package com.oguzhanakduman.services;

import com.oguzhanakduman.dto.DtoAddress;

public interface IAddressService {
	
	public DtoAddress findAddressById(Long id);
}
