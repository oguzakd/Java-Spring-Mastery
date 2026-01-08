package com.oguzhanakduman.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.AuthRequest;
import com.oguzhanakduman.dto.AuthResponse;
import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.dto.RefreshTokenRequest;
import com.oguzhanakduman.exception.BaseException;
import com.oguzhanakduman.exception.ErrorMessage;
import com.oguzhanakduman.exception.MessageType;
import com.oguzhanakduman.jwt.JWTService;
import com.oguzhanakduman.model.RefreshToken;
import com.oguzhanakduman.model.User;
import com.oguzhanakduman.repository.RefreshTokenRepository;
import com.oguzhanakduman.repository.UserRepository;
import com.oguzhanakduman.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	RefreshTokenRepository refreshTokenRepository;
	
	private User createUser(AuthRequest request) {
		User user = new User();
		user.setCreateTime(new Date());
		user.setUsername(request.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		
		return user;
	}
	
	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setUser(user);
		
		return refreshToken;
	}
	
	public DtoUser register(AuthRequest request) {
		DtoUser dtoUser = new DtoUser();
		
		User savedUser = userRepository.save(createUser(request));
		
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}

	@Override
	public AuthResponse authenticate(AuthRequest request) {

	    try {
	        // 1. Kimlik bilgilerini doğrula (Şifre kontrolü burada yapılır)
	        UsernamePasswordAuthenticationToken auth = 
	                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
	        
	        authenticationProvider.authenticate(auth); // Hata varsa catch'e zıplar
	        
	        // 2. Eğer buraya geldiyse şifre doğrudur. Kullanıcıyı çek.
	        User dbUser = userRepository.findByUsername(request.getUsername())
	                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı"));
	        
	        boolean check = bCryptPasswordEncoder.matches(request.getPassword(), dbUser.getPassword());
	        
	        if (dbUser != null) {
	            boolean isMatch = bCryptPasswordEncoder.matches(request.getPassword(), dbUser.getPassword());
	            System.out.println("Manuel Kontrol - Şifreler eşleşti mi?: " + isMatch);
	        }
	        
	        // 3. AccessToken üret
	        String accessToken = jwtService.generateToken(dbUser);
	        
	        // 4. RefreshToken üret
	        RefreshToken refreshToken = createRefreshToken(dbUser);
	        refreshTokenRepository.save(refreshToken);
	        
	        return new AuthResponse(accessToken, refreshToken.getRefreshToken());
	        
	    } catch (BadCredentialsException e) {
	        // Şifre yanlışsa buraya düşer
	        throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
	    } catch (Exception e) {
	        // Diğer her türlü hata (DB bağlantısı, null pointer vs.)
	        System.out.println("Beklenmedik bir hata oluştu: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}

	public boolean isRefreshTokenExpired(Date expiredDate) {
		return new Date().before(expiredDate);
	}
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		if(optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, request.getRefreshToken()));
		}
		
		RefreshToken refreshToken = optional.get();
		if(!isRefreshTokenExpired(refreshToken.getExpiredDate())) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, request.getRefreshToken()));
		}
		
		String accessToken = jwtService.generateToken(refreshToken.getUser());
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));
		
		return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
	}

}
