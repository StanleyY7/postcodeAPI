package postcode.project.backend.postcodes;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeHttpRequests()
	            .requestMatchers(HttpMethod.GET)
	                .permitAll()
	            .requestMatchers(HttpMethod.POST)
	                .authenticated().and().httpBasic();

	    return http.build();
	}

}
