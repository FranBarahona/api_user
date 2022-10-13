package com.user.api_user.model.Dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }
}
