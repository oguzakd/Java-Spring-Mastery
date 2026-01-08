package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoGallerist;
import com.oguzhanakduman.dto.DtoGalleristIU;

public interface IGalleristService {
	
	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);

}
