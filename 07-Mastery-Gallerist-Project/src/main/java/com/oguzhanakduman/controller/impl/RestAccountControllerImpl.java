package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestAccountController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.DtoAccount;
import com.oguzhanakduman.dto.DtoAccountIU;
import com.oguzhanakduman.service.IAccountService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController{
	
	@Autowired
	IAccountService accountService;

	@PostMapping("/save")
	@Override
	public RestRootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		return ok(accountService.saveAccount(dtoAccountIU));
	}

}
