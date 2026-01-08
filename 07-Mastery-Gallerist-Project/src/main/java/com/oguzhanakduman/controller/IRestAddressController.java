package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoAddressIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestAddressController {
	
	public RestRootEntity<DtoAddress> saveAddress(DtoAddressIU dttoAddressIU);

}
