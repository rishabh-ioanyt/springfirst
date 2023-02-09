package com.example.springfirst;

import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import java.util.Map;

public class OAuth2AuthorizationServiceImpl implements OAuth2AuthorizationService {

    private Map<String, OAuth2Authorization> initializedAuthorizations;
    private final Map<String, OAuth2Authorization> authorizations;

    public OAuth2AuthorizationServiceImpl(Map<String, OAuth2Authorization> initializedAuthorizations, Map<String, OAuth2Authorization> authorizations) {
        this.initializedAuthorizations = initializedAuthorizations;
        this.authorizations = authorizations;
    }

    @Override
    public void save(OAuth2Authorization authorization) {
        if (isComplete(authorization)) {
            System.out.println(authorization.getId());
            System.out.println(authorization.getPrincipalName());
            System.out.println(authorization.getRegisteredClientId());
            System.out.println(authorization.getAccessToken().getToken().getTokenValue());
            this.authorizations.put("first", authorization);
        } else {
            this.initializedAuthorizations.put(authorization.getId(), authorization);
        }
    }

    private static boolean isComplete(OAuth2Authorization authorization) {
        return authorization.getAccessToken() != null;
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
        System.out.println(token);
        OAuth2Authorization.Token<OAuth2AccessToken> accessToken = authorizations.get("first").getAccessToken();
            if(accessToken.getToken().getTokenValue().equals(token))
                return authorizations.get("first");
        return null;
    }


}
