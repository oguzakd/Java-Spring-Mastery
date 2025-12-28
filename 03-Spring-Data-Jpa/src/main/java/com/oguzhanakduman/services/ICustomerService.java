package com.oguzhanakduman.services;

import com.oguzhanakduman.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Long id);

}
