/*
package com.work.inetum01.controlers;

import com.work.inetum01.models.AuthentificationRequest;
import com.work.inetum01.models.AuthentificationResponce;
import com.work.inetum01.util.JwtUtil;
import org.elasticsearch.action.admin.indices.shards.TransportIndicesShardStoresAction;
import org.elasticsearch.client.security.AuthenticateRequest;
import org.elasticsearch.client.security.DelegatePkiAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.net.Authenticator;


@RestController
public class Auth {
    @Autowired
    private AuthenticationManager authenticationManager ;
    @Autowired
    private MyUserDetailsService userDetailsService ;
    @Autowired
    private JwtUtil jwtTokenUtil ;

    @RequestMapping ("/hello")
    public String hello(){return  "Hello world";}
    @RequestMapping(value = "/authentificate" , method=RequestMethod.POST)
    public ResponseEntity<?> createAuthentificationToken(@RequestBody AuthentificationRequest authenticattionRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticattionRequest.getUsername(), authenticattionRequest.getPassword())
            );
        }catch (BadCredentialsException e) {
                throw new Exception("Incorrect Username or password",e) ;
            }

        final UserDetails userDetails =userDetailsService
                .loadUserByUsername(authenticattionRequest.getUsername()) ;
        final String jwt =jwtTokenUtil.generateToken(userDetails) ;
        return ResponseEntity.ok(new AuthentificationResponce(jwt));
    }
*/
