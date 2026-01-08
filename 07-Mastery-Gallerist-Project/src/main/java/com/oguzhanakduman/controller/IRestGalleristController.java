package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoGallerist;
import com.oguzhanakduman.dto.DtoGalleristIU;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestGalleristController {

	public RestRootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
