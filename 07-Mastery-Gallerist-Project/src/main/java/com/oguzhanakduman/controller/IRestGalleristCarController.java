package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoGalleristCar;
import com.oguzhanakduman.dto.DtoGalleristCarIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestGalleristCarController {
	
	public RestRootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);

}
