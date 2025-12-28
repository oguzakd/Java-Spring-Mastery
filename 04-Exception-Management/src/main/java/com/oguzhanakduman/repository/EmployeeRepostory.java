package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oguzhanakduman.model.Employee;

@Repository
public interface EmployeeRepostory extends JpaRepository<Employee, Long>{

}
