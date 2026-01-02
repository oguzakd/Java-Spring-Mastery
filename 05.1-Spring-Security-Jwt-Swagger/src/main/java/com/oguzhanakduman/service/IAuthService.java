package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.jwt.AuthRequest;
import com.oguzhanakduman.jwt.AuthResponse;

public interface IAuthService {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
}
