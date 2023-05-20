package ru.home.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "security.accessMode", havingValue = "full")
public class FullAccessWebSecurityConfig extends WebSecurityConfigBase {

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.anyRequest().permitAll());
        http.httpBasic().disable();
        http.formLogin().disable();
    }

    @Override
    protected AuthenticationManager authenticationManager() {
        return null;
    }
}
