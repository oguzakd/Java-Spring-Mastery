package com.oguzhanakduman.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oguzhanakduman.utils.PagerUtil;
import com.oguzhanakduman.utils.RestPageableEntity;
import com.oguzhanakduman.utils.RestPageableRequest;
import com.oguzhanakduman.utils.RestRootEntity;

public class RestBaseController {
	
	public Pageable toPageable(RestPageableRequest request) {
		return PagerUtil.toPageable(request);
	}
	
	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {
		return PagerUtil.toPageableResponse(page, content);
	}
	
	public <T> RestRootEntity<T> ok(T payload) {
		return RestRootEntity.ok(payload);
	}

}
