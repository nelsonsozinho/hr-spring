package com.devsuperior.hrapigatewayzuul.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
class AppConfig {

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

    @Bean("tokenConverter")
    fun accessTokenConverter(): JwtAccessTokenConverter {
        var tokenConverter = JwtAccessTokenConverter()
        tokenConverter.setSigningKey("MY-SECRET-KEY")
        return tokenConverter
    }

    @Bean
    fun tokenStore(): JwtTokenStore = JwtTokenStore(accessTokenConverter())

}