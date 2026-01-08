package com.oguzhanakduman.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoAccount;
import com.oguzhanakduman.dto.DtoAccountIU;
import com.oguzhanakduman.model.Account;
import com.oguzhanakduman.repository.AccountRepository;
import com.oguzhanakduman.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAccountIU, account);
		return account;
	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount = new DtoAccount();
		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}
