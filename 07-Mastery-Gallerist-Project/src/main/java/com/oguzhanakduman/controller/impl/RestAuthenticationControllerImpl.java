package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestAuthenticationController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.AuthRequest;
import com.oguzhanakduman.dto.AuthResponse;
import com.oguzhanakduman.dto.DtoUser;
import com.oguzhanakduman.dto.RefreshTokenRequest;
import com.oguzhanakduman.service.IAuthenticationService;
import com.oguzhanakduman.utils.RestRootEntity;

import jakarta.validation.Valid;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController{
	
	@Autowired
	IAuthenticationService authenticationService;

	@PostMapping("/register")
	@Override
	public RestRootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
		return ok(authenticationService.register(request));
	}

	@PostMapping("/authenticate")
	@Override
	public RestRootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
		return ok(authenticationService.authenticate(request));
	}
	
	@PostMapping("/refreshToken")
	@Override
	public RestRootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
		return ok(authenticationService.refreshToken(request));
	}
	
}
