package com.oguzhanakduman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhanakduman.entites.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
