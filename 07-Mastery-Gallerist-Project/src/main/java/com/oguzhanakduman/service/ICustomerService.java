package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoCustomer;
import com.oguzhanakduman.dto.DtoCustomerIU;

public interface ICustomerService {
	
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

}
