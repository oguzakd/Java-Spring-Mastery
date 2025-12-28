package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoCustomer;

public interface ICustomerController {
	
	public DtoCustomer findCustomerById(Long id);

}
