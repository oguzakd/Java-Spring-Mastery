package com.oguzhanakduman.service;

import com.oguzhanakduman.jwt.AuthResponse;
import com.oguzhanakduman.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {
	
	public AuthResponse refreshToken(RefreshTokenRequest request);

}
