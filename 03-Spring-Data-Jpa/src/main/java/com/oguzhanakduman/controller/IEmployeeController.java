package com.oguzhanakduman.controller;

import java.util.List;

import com.oguzhanakduman.dto.DtoEmployee;

public interface IEmployeeController {
	
	public List<DtoEmployee> findAllEmployees();
}
