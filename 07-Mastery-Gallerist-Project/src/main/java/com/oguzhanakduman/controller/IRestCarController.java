package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoCar;
import com.oguzhanakduman.dto.DtoCarIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestCarController {
	
	public RestRootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

}
