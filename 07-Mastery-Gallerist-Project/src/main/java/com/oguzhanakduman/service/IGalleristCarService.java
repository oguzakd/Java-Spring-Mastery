package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoGalleristCar;
import com.oguzhanakduman.dto.DtoGalleristCarIU;

public interface IGalleristCarService {
	
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);

}
