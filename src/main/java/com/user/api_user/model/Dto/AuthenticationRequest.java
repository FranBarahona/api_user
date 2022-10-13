package com.user.api_user.model.Dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    public String username;
    public String password;
}
