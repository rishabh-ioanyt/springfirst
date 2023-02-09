package com.example.springfirst;

import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OAuth2AuthorizationServiceImpl implements OAuth2AuthorizationService {

    @Override
    public void save(OAuth2Authorization authorization) {
        System.out.println(authorization.getId());
        System.out.println(authorization.getPrincipalName());
        System.out.println(authorization.getRegisteredClientId());
        System.out.println(authorization.getAttributes());

    }

    @Override
    public void remove(OAuth2Authorization authorization) {

    }

    @Override
    public OAuth2Authorization findById(String id) {
        System.out.println("find by Id null");
        return null;
    }

    @Override
    public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
        System.out.println("find By Token");
        return null;
    }
}
