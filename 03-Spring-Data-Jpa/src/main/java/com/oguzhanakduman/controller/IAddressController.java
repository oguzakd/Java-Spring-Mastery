package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoAddress;

public interface IAddressController {
	public DtoAddress findAddressById(Long id);
}
