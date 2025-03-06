package com.example.security; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@Configuration 
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class); 
    @Override 
    protected void configure(HttpSecurity http) throws Exception { 
        try { 
            logger.info("Configuring HTTP security settings."); 
            http 
                .csrf().and() // Enable CSRF protection 
                .authorizeRequests() 
                .antMatchers("/", "/feedback-form", "/feedback-list").permitAll() // Allow public access to these URLs 
                .anyRequest().authenticated(); 
            logger.info("HTTP security configuration completed successfully."); 
        } catch (Exception e) { 
            logger.error("Error configuring HTTP security: ", e); 
            throw e; 
        } 
    } 
} 