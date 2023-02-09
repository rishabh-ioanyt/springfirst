package com.example.springfirst.userAccount;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthenticationContext;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountService  {


    @GetMapping("/api/user")
    public Object userDetails(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return AuthorizationServerContextHolder.getContext().getIssuer();
    }
}
