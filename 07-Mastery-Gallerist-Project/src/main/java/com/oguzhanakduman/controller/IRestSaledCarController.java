package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoSaledCar;
import com.oguzhanakduman.dto.DtoSaledCarIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestSaledCarController {
	
	public RestRootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);

}
