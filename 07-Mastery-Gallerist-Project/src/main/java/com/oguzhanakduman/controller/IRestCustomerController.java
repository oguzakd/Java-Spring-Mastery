package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoCustomer;
import com.oguzhanakduman.dto.DtoCustomerIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestCustomerController {
	
	public RestRootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

}
