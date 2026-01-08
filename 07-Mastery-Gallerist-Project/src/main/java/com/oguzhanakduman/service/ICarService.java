package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoCar;
import com.oguzhanakduman.dto.DtoCarIU;

public interface ICarService {
	
	public DtoCar saveCar(DtoCarIU dtoCarIU);

}
