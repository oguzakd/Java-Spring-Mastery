package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.AuthRequest;
import com.oguzhanakduman.dto.AuthResponse;
import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.dto.RefreshTokenRequest;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestAuthenticationController {

	public RestRootEntity<DtoUser> register(AuthRequest request); 
	
	public RestRootEntity<AuthResponse> authenticate(AuthRequest request);
	
	public RestRootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);
	
}
