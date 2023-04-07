package postcode.project.backend.tests;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import postcode.project.backend.postcodes.SecurityConfig;

@Configuration
@EnableWebSecurity
@Import(SecurityConfig.class)
public class TestSecurityConfig {
}
