package com.codecool.apigateway.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@AllArgsConstructor
//public class JwtTokenFilter extends GenericFilterBean {
//
//    private final JwtTokenService jwtTokenService;
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
//        String token = jwtTokenService.getTokenFromRequest((HttpServletRequest) req);
//        if (token != null && jwtTokenService.validateToken(token)) {
//            Authentication auth = jwtTokenService.parseUserFromTokenInfo(token);
//
//            // Marks the user as authenticated.
//            // If this code does not run, the request will fail for routes that are configured to need authentication
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
//
//        // process the next filter.
//        filterChain.doFilter(req, res);
//    }
//}
