package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestCustomerController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.DtoCustomer;
import com.oguzhanakduman.dto.DtoCustomerIU;
import com.oguzhanakduman.service.ICustomerService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController{
	
	@Autowired
	ICustomerService customerService;

	@PostMapping("/save")
	@Override
	public RestRootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.saveCustomer(dtoCustomerIU));
	}

}
