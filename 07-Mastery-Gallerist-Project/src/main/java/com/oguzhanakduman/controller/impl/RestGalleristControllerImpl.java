package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestGalleristController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.DtoGallerist;
import com.oguzhanakduman.dto.DtoGalleristIU;
import com.oguzhanakduman.service.IGalleristService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController{

	@Autowired
	private IGalleristService galleristService;

	@PostMapping("/save")
	@Override
	public RestRootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
		return ok(galleristService.saveGallerist(dtoGalleristIU));
	}
	
}
