package com.develcode.develfood.controller;

import com.develcode.develfood.dto.AuthData;
import com.develcode.develfood.dto.JwtTokenData;
import com.develcode.develfood.infra.security.TokenService;
import com.develcode.develfood.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JwtTokenData> login(@RequestBody @Valid AuthData authData) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authData.getEmail(), authData.getPassword());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJwt = tokenService.generateToken( (User) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtTokenData(tokenJwt));
    }
}
