package com.khoapd.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SercurityConfig {


    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-resources/**",
            "/swagger-resource",
            "/favicon.ico",
            "/webjars/**",
            "/product/v3/api-docs",
            "/order/v3/api-docs",
            "/customer/v3/api-docs",
            "/payment/v3/api-docs"
    };


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/eureka/**").permitAll()
                        .pathMatchers(HttpMethod.GET, SWAGGER_WHITELIST).permitAll()
                        .anyExchange()
                        .authenticated()
                ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .logout(ServerHttpSecurity.LogoutSpec::disable);
        return serverHttpSecurity.build();
    }

}
