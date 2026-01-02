package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestEmployeeController;
import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController {
	
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list/{id}")
    @Override
    public DtoEmployee findEmployeeById(Long id) {
        // Parametre içindeki anotasyonları sildik çünkü interface'den miras alıyor
        return employeeService.findEmployeeById(id);
    }
}