package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
