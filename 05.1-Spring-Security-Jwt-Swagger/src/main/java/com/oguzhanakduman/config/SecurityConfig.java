package com.oguzhanakduman.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.oguzhanakduman.jwt.AuthEntryPoint;
import com.oguzhanakduman.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public static final String AUTHENTICATE = "/authenticate";
	public static final String REGISTER = "/register";
	public static final String REFRESH_TOKEN = "/refreshToken";
	
	public static final String[] SWAGGER_PATH_STRINGS = {
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/swagger-ui.html"
	};
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	AuthEntryPoint authEntryPoint;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        // CSRF'i yeni yöntemle devre dışı bırakıyoruz
        .csrf(csrf -> csrf.disable())
        
        // Yetkilendirme ayarları
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(REGISTER, AUTHENTICATE, REFRESH_TOKEN).permitAll()
            .requestMatchers(SWAGGER_PATH_STRINGS).permitAll()
            .anyRequest().authenticated()
        )
        
        // hatayı handle etmek
        .exceptionHandling(exception -> exception
                .authenticationEntryPoint(authEntryPoint)
            )
        
        // Session yönetimi (Stateless/JWT için)
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        
        // Provider ve Filter ekleme
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
	}
}
