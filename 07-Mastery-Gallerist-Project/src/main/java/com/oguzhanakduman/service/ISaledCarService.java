package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoSaledCar;
import com.oguzhanakduman.dto.DtoSaledCarIU;

public interface ISaledCarService {
	
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
