package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestSaledCarController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.DtoSaledCar;
import com.oguzhanakduman.dto.DtoSaledCarIU;
import com.oguzhanakduman.service.ISaledCarService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements IRestSaledCarController{
	
	@Autowired
	ISaledCarService saledCarService;

	@PostMapping("/save")
	@Override
	public RestRootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
