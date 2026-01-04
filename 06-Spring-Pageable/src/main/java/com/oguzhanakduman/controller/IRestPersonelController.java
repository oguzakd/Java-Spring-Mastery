package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoPersonel;
import com.oguzhanakduman.utils.RestPageableEntity;
import com.oguzhanakduman.utils.RestPageableRequest;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestPersonelController {
	
	public RestRootEntity<RestPageableEntity<DtoPersonel>> findAllPageable(RestPageableRequest pagableRequest);

}
