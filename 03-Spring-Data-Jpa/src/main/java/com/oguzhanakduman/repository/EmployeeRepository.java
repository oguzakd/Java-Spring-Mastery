package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhanakduman.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
