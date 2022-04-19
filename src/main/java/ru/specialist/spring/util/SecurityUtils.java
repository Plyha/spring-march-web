package ru.specialist.spring.util;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {


    public static final String ACCESS_DENIED = "Access Denied";

    public static UserDetails getCurrentUserDetails(){
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (!(principal instanceof UserDetails)){
            throw new AccessDeniedException(ACCESS_DENIED);
        }

        return (UserDetails) principal;

    }
}
