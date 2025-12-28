package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.model.RootEntity;

public interface IEmployeeController {

	public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
