package com.oguzhanakduman.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oguzhanakduman.model.Employee;

@Configuration
public class AppConfig {

	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Oğuzhan", "Akduman"));
		employeeList.add(new Employee("2", "Ömer", "Akduman"));
		employeeList.add(new Employee("3", "Haci Bayram", "Akduman"));
		employeeList.add(new Employee("4", "Alparslan Kayra", "Aydın"));
		employeeList.add(new Employee("5", "Mustafa Arda", "Aydın"));
		return employeeList;
	}
}
