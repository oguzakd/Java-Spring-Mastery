package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoEmployee;

public interface IEmployeeService {
	
	public DtoEmployee findEmployeeById(Long id);

}
