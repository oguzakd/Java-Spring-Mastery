package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.AuthRequest;
import com.oguzhanakduman.dto.AuthResponse;
import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.dto.RefreshTokenRequest;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest request);
	
	public AuthResponse authenticate(AuthRequest request);
	
	public AuthResponse refreshToken(RefreshTokenRequest request);

}
