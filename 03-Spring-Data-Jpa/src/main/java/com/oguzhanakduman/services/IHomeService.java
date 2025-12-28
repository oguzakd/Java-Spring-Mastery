package com.oguzhanakduman.services;

import com.oguzhanakduman.dto.DtoHome;

public interface IHomeService {

	public DtoHome findHomeById(Long id);
}
