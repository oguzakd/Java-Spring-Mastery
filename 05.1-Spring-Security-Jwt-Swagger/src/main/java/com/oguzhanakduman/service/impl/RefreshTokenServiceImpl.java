package com.oguzhanakduman.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.jwt.AuthResponse;
import com.oguzhanakduman.jwt.JwtService;
import com.oguzhanakduman.jwt.RefreshTokenRequest;
import com.oguzhanakduman.model.RefreshToken;
import com.oguzhanakduman.model.User;
import com.oguzhanakduman.repository.RefreshTokenRepository;
import com.oguzhanakduman.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService{

	@Autowired
	RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	JwtService jwtService;
	
	public boolean isRefreshTokenExpired(Date expiredDate) {
		return new Date().before(expiredDate);
	}
	
	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setUser(user);
		
		return refreshToken;
	}
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		if(optional.isEmpty()) {
			System.out.println("REFRESH TOKEN GEÇERSİZDİR: " + request.getRefreshToken());
		}
		
		RefreshToken refreshToken = optional.get();
		if(!isRefreshTokenExpired(refreshToken.getExpireDate())) {
			System.out.println("REFRESH TOKEN EXPIRE OLMUŞTUR: " + request.getRefreshToken());
		}
		
		String accessToken = jwtService.generateToken(refreshToken.getUser());
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));
		
		return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
	}

}
