package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IEmployeeController;
import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.model.RootEntity;
import com.oguzhanakduman.service.IEmployeeService;

@RestController
@RequestMapping(path = "rest/api/employee")
public class EmployeeController extends RestBaseController implements IEmployeeController{
	
	@Autowired
	private IEmployeeService employeeService;

	@GetMapping(path = "/list/{id}")
	@Override
	public RootEntity<DtoEmployee> findEmployeeById(@PathVariable(value = "id") Long id) {
		return ok(employeeService.findEmployeeById(id));
	}

}
