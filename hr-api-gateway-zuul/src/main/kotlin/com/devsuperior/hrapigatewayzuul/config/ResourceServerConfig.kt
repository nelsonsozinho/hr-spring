package com.devsuperior.hrapigatewayzuul.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore

@Configuration
@EnableResourceServer
class ResourceServerConfig: ResourceServerConfigurerAdapter() {

    @Autowired
    lateinit var jwtTokenStore: JwtTokenStore;

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.tokenStore(jwtTokenStore)
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/hr-oauth/oauth/token").permitAll()
            .antMatchers(HttpMethod.GET, "/hr-worker/**").hasAnyRole("OPERATOR", "ADMIN")
            .antMatchers(
                "/hr-payroll/**", "/hr-user/**",
                "/actuator/**",
                "/hr-worker/actuator/**",
                "/hr-oauth/actuator/**").hasRole("ADMIN")
            .anyRequest().authenticated()
    }
}


