package com.example.springfirst.userAccount;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserAccountService  {


    @GetMapping("/api/user")
    public Map<String, Object> userDetails(){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("Name", Collections.singletonList("rishabh"));
        objectMap.put("Granted Authorities",new ArrayList<>(Arrays.asList("ROLE_USER","SCOPE_read:user")));
        Map<String, Object> map = new HashMap<>();
        map.put("login","rishabh-ioanyt");
        map.put("id","123456789");
        map.put("type","User");
        map.put("name","admin");
        objectMap.put("User Attributes",map);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return objectMap;
    }
}
