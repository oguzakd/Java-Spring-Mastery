package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoAccount;
import com.oguzhanakduman.dto.DtoAccountIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestAccountController {

	public RestRootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU); 
}
