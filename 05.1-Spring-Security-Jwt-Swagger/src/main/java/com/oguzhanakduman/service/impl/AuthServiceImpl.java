package com.oguzhanakduman.service.impl;


import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.oguzhanakduman.config.AppConfig;
import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.jwt.AuthRequest;
import com.oguzhanakduman.jwt.AuthResponse;
import com.oguzhanakduman.jwt.JwtService;
import com.oguzhanakduman.model.RefreshToken;
import com.oguzhanakduman.model.User;
import com.oguzhanakduman.repository.RefreshTokenRepository;
import com.oguzhanakduman.repository.UserRepository;
import com.oguzhanakduman.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService{

    private final AppConfig appConfig;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	RefreshTokenRepository refreshTokenRepository;

    AuthServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
	
	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setUser(user);
		
		return refreshToken;
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
	        
	        boolean check = passwordEncoder.matches(request.getPassword(), dbUser.getPassword());
	        
	        if (dbUser != null) {
	            boolean isMatch = passwordEncoder.matches(request.getPassword(), dbUser.getPassword());
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
	        System.out.println("Hata: Kullanıcı adı veya şifre yanlış!");
	        e.printStackTrace();
	        throw e; 
	    } catch (Exception e) {
	        // Diğer her türlü hata (DB bağlantısı, null pointer vs.)
	        System.out.println("Beklenmedik bir hata oluştu: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public DtoUser register(AuthRequest request) {
		User user = new User();
	    user.setUsername(request.getUsername());
	    user.setPassword(passwordEncoder.encode(request.getPassword()));
	    System.out.println("user username: " + user.getUsername() + " user password: " + user.getPassword());
	    
	    // Veritabanına kaydet
	    User savedUser = userRepository.save(user); 
	    System.out.println("savedUser username: " + savedUser.getUsername() + " savedUser password: " + savedUser.getPassword());
	    
	    // DTO'yu oluştur ve alanları ELİNLE setle
	    DtoUser dtoUser = new DtoUser();
	    dtoUser.setUsername(savedUser.getUsername());
	    // Güvenlik gereği DTO içinde şifre dönmemen iyi olur ama test için ekleyebilirsin:
	    dtoUser.setPassword(savedUser.getPassword()); 
	    System.out.println("dtoUser username: " + dtoUser.getUsername() + " dtoUser password: " + dtoUser.getPassword());
	    return dtoUser;
	}

}
