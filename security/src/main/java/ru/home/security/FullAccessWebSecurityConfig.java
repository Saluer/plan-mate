package ru.home.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@ConditionalOnProperty(value="security.accessMode", havingValue = "full")
public class FullAccessWebSecurityConfig extends WebSecurityConfigBase {

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.anyRequest().permitAll());
        http.httpBasic().disable();
       http.formLogin().disable();
    }
}
