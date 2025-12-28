package com.oguzhanakduman.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oguzhanakduman.model.Employee;
import com.oguzhanakduman.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		return employeeList;
	}
	
	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		
		for(Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
		}
		
		return findEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		List<Employee> employeeListWithParamEmployees = new ArrayList<>();
		
		if(firstName == null && lastName == null) {
			return employeeList;
		}
		for(Employee employee : employeeList) {
			if(firstName != null && lastName != null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeListWithParamEmployees.add(employee);
				}
			}
			if(firstName != null && lastName == null) {
				if(employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeListWithParamEmployees.add(employee);
				}
			}
			if(firstName == null && lastName != null) {
				if(employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeListWithParamEmployees.add(employee);
				}
			}
		}
		return employeeListWithParamEmployees;
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public Employee findEmployeeById(String id) {
		Employee findEmployee = null;
		
		for(Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
		}
		return findEmployee;
	}
	
	public boolean deleteEmployee(String id) {
		Employee deleteEmployee = null;
		
		for(Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}
		}
		if(deleteEmployee == null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		Employee findEmployee = findEmployeeById(id);
		if(findEmployee != null) {
			deleteEmployee(id);
			Employee updatedEmployee = new Employee();
			updatedEmployee.setId(id);
			updatedEmployee.setFirstName(request.getFirstName());
			updatedEmployee.setLastName(request.getLastName());
			
			employeeList.add(updatedEmployee);
			return updatedEmployee;
		}
		return null;
	}

}
