package com.udemy.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;
import com.udemy.demo.dto.request.ApiResponse;
import com.udemy.demo.dto.request.AuthenticationRequest;
import com.udemy.demo.dto.request.IntrospectRequest;
import com.udemy.demo.dto.response.AuthenticationResponse;
import com.udemy.demo.dto.response.IntrospectResponse;
import com.udemy.demo.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.experimental.FieldDefaults;

import java.text.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticated(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticated(request);

        return ApiResponse.<AuthenticationResponse>builder()
        .result(result)
        .build();
    }
    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> authenticated(@RequestBody IntrospectRequest request) 
    throws JOSEException, ParseException {
        var result = authenticationService.intropect(request);

        return ApiResponse.<IntrospectResponse>builder()
        .result(result)
        .build();
    }
    
}
