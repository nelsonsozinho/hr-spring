package com.devsuperior.hrapigatewayzuul.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@RefreshScope
@Configuration
class AppConfig {

    @Value("\${jwt.secret}")
    lateinit var jwtSecret: String

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

    @Bean("tokenConverter")
    fun accessTokenConverter(): JwtAccessTokenConverter {
        var tokenConverter = JwtAccessTokenConverter()
        tokenConverter.setSigningKey(jwtSecret)
        return tokenConverter
    }

    @Bean
    fun tokenStore(): JwtTokenStore = JwtTokenStore(accessTokenConverter())

}