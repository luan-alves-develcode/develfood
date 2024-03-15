package com.develcode.develfood.dto;

import lombok.Getter;

@Getter
public class JwtTokenData {

    private String token;

    public JwtTokenData(String token) {
        this.token = token;
    }
}
