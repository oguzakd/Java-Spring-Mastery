package com.oguzhanakduman.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoDepartment;
import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.entites.Employee;
import com.oguzhanakduman.repository.EmployeeRepository;
import com.oguzhanakduman.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<DtoEmployee> dtoEmployees = new ArrayList<>();
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(employees.isEmpty()) {
			return null;
		}
		
		
		for(Employee employee : employees) {
			DtoEmployee dtoEmployee = new DtoEmployee();
			
			BeanUtils.copyProperties(employee, dtoEmployee);
			
			dtoEmployee.setDepartment(new DtoDepartment(employee.getId(), employee.getDepartment().getDepartmentName()));
			
			dtoEmployees.add(dtoEmployee);
		}
		
		return dtoEmployees;
	}

}
