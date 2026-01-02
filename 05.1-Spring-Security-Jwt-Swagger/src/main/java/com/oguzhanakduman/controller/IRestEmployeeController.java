package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoEmployee;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface IRestEmployeeController {
	
    // Kural burada: id hem URL'den gelmeli (@PathVariable) hem de boş olmamalı (@NotNull)
    DtoEmployee findEmployeeById(@Valid @NotNull @PathVariable(value = "id") Long id);

}