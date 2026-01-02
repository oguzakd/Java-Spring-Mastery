package com.oguzhanakduman.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoDepartment;
import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.model.Department;
import com.oguzhanakduman.model.Employee;
import com.oguzhanakduman.repository.EmployeeRepository;
import com.oguzhanakduman.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public DtoEmployee findEmployeeById(Long id) {
	    DtoEmployee dtoEmployee = new DtoEmployee();
	    DtoDepartment dtoDepartment = new DtoDepartment();
	    
	    Optional<Employee> optional = employeeRepository.findById(id);
	    
	    if (optional.isEmpty()) {
	        // Exception fırlatılabilir veya null dönebilir
	    	System.out.println("optional boş geliyor");
	        return null;
	    }
	    
	    Employee employee = optional.get();
	    Department department = employee.getDepartment();
	    
	    BeanUtils.copyProperties(employee, dtoEmployee);
	    BeanUtils.copyProperties(department, dtoDepartment);
	    
	    dtoEmployee.setDepartment(dtoDepartment);
	    System.out.println("servisde return öncesi dtoemployee: " + dtoEmployee.toString());
	    return dtoEmployee;
	}

}
