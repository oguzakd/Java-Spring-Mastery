package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoHome;

public interface IHomeController {
	
	public DtoHome findHomeById(Long id);

}
