package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.jwt.AuthRequest;
import com.oguzhanakduman.jwt.AuthResponse;
import com.oguzhanakduman.jwt.RefreshTokenRequest;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
	
	public AuthResponse refreshToken(RefreshTokenRequest request);
}
