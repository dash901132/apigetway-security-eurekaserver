package com.apigetway.controller;


import com.apigetway.models.AuthenticationRequest;
import com.apigetway.models.AuthenticationResponse;
import com.apigetway.security.MyUserDetailsService;
import com.apigetway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class SecurityController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @RequestMapping("/hello")
    public String getHellow(){
        return "welcome to spring security";
    }
    @RequestMapping(value="/auth",method = RequestMethod.POST)
    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
     try{
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
     }catch (BadCredentialsException credentialsException){
         throw new Exception("invalid username and password",credentialsException);
     }
     final UserDetails userDetails= new MyUserDetailsService()
         .loadUserByUsername(authenticationRequest.getUsername());
     final String jwt=jwtUtil.generateToken(userDetails);
     return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
