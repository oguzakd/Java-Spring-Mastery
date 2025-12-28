package com.oguzhanakduman.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IEmployeeController;
import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.services.IEmployeeService;

@RestController
@RequestMapping(path = "rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

}
