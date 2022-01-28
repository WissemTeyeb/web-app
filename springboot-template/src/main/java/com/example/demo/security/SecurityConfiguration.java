package com.example.demo.security;

import com.example.demo.model.ToDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//SecurityConfiguration is to configure the web security layer of spring boot
//-add the permitted endpoints
//-add the denied endpoints
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final String[] publicEndpoints = {"/url/api/auth/signin", "/url/api/v1/signup", "/url/api/v1/users","/v2/api-docs", "/webjars/**", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/actuator/*"};


    @Autowired
    UserService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

// configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AurthenticationFilter doFiltrer() throws Exception {
        return new AurthenticationFilter();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(publicEndpoints).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(doFiltrer(), UsernamePasswordAuthenticationFilter.class);

    }

}