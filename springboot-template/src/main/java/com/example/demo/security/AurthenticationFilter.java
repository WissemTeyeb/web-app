package com.example.demo.security;

import com.example.demo.utile.preRun;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

public class AurthenticationFilter extends OncePerRequestFilter {
    private final Log logger = LogFactory.getLog(AurthenticationFilter.class);
    private String header = "Authorization";

    @Autowired
    UserService userService;
    @Autowired
    jwtTokenUtil jTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String path = httpServletRequest.getRequestURI();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            logger.info(authentication.getName());
        }
        String headerToken = httpServletRequest.getHeader(header);
        if (headerToken != null) {
            String username = jTokenUtil.getUsernameFromToken(httpServletRequest.getHeader(header));
            if (username != null) {
                logger.info(username);

                UserDetails userDetails = userService.loadUserByUsername(username);
                if (userDetails != null) {
                    if (jTokenUtil.validateToken(headerToken, userDetails)) {

                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                Collections.emptyList()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    }
                }
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private Optional<String> getTokenString(String header) {
        if (header == null) {
            return Optional.empty();
        } else {
            String[] split = header.split(" ");
            if (split.length < 2) {
                return Optional.empty();
            } else {
                return Optional.ofNullable(split[1]);
            }
        }
    }
}
