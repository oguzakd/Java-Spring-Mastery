package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoEmployee;

public interface IEmployeeService {
	
	DtoEmployee findEmployeeById(Long id);

}
