package com.oguzhanakduman.controller.impl;

import com.oguzhanakduman.model.RootEntity;

public class RestBaseController {
	
	public <T> RootEntity<T> ok(T data) {
		return RootEntity.ok(data);
	}
	
	public <T> RootEntity<T> error(String errorMessage, T data) {
		return RootEntity.error(errorMessage, data);
	}

}
