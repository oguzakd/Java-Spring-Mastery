package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestAddressController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.DtoAddress;
import com.oguzhanakduman.dto.DtoAddressIU;
import com.oguzhanakduman.service.IAddressService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController{
	
	@Autowired
	IAddressService addressService;

	@PostMapping("/save")
	@Override
	public RestRootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dttoAddressIU) {
		return ok(addressService.saveAddress(dttoAddressIU));
	}

}
