package com.robin.itrms.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {
        var authorities = authentication.getAuthorities();
        if(authorities.stream()
                .anyMatch(a ->
                        a.getAuthority().equals("ROLE_ADMIN"))){
            response.sendRedirect("/admin/dashboard");
            return;
        }
        response.sendRedirect("/member/home");
    }
}
