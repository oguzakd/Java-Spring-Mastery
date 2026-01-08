package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoAccount;
import com.oguzhanakduman.dto.DtoAccountIU;

public interface IAccountService {
	
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
