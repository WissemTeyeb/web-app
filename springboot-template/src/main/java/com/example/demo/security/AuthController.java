package com.example.demo.security;

import com.example.demo.errors.NotFoundException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/url/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private jwtTokenUtil jTokenUtil;
    private final Log logger = LogFactory.getLog(AuthController.class);

    @PostMapping(value = "/signin")
    public String signIn(@RequestBody SignInRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final userApp userDetails = userService
                .loadUserByUsername(authenticationRequest.getEmail());
        final String token = jTokenUtil.generateToken(userDetails);
        logger.info(token);

        return token;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

           System.out.println("hello");
        } catch (DisabledException e) {
            throw new NotFoundException("NotFoundException auth");
        }
    }


}

