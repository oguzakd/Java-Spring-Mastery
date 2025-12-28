package com.oguzhanakduman.services;

import java.util.List;

import com.oguzhanakduman.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> findAllEmployees();
}
