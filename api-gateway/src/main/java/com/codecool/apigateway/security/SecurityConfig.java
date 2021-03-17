package com.codecool.apigateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailsService customUserCredentialsService;
//    private final JwtTokenService jwtTokenService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                .httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("/netflix/account/**").permitAll()
//                    .antMatchers("/test").permitAll()
//                    .antMatchers(HttpMethod.POST, "/login").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
//                    .antMatchers(HttpMethod.POST, "/register").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, "/register").permitAll()
//                    .antMatchers(HttpMethod.OPTIONS, "/netflix/videos/**").authenticated()
//                    .antMatchers(HttpMethod.POST, "/netflix/videos/**").authenticated()
//                    .antMatchers(HttpMethod.GET, "/netflix/videos/**").authenticated()
//                    .anyRequest().authenticated() // anything else is denied
//                .and()
//                    .addFilterBefore(new JwtTokenFilter(jwtTokenService), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserCredentialsService).passwordEncoder(passwordEncoder());
//    }
//}
