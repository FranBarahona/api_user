package com.user.api_user.controller;

import com.user.api_user.security.JwtConfig;
import com.user.api_user.model.Dto.AuthenticationRequest;
import com.user.api_user.model.Dto.AuthenticationResponse;
import com.user.api_user.service.security.UsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersDetailsService usersDetailsService;

    @Autowired
    private JwtConfig jwtConfig;


    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),  request.getPassword()));
            UserDetails userDetails = usersDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtConfig.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch(BadCredentialsException e){
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
