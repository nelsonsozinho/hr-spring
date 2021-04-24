package com.devsuperior.hrapigatewayzuul.config


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

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

        http.cors().configurationSource(corsConfigurationSource())
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfig: CorsConfiguration = CorsConfiguration()
        corsConfig.allowedOrigins = mutableListOf("*")
        corsConfig.allowedMethods = mutableListOf("POST", "GET", "PUT", "DELETE", "PATCH")
        corsConfig.allowCredentials = true
        corsConfig.allowedHeaders = mutableListOf("Authorization", "Content-Type")

        val source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)

        return source
    }

    @Bean
    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
        val bean: FilterRegistrationBean<CorsFilter> = FilterRegistrationBean(CorsFilter(corsConfigurationSource()))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}


