package com.eazybytes.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.eazybytes.filter.CsrfCookieFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf");
		
		http.securityContext().requireExplicitSave(false)
		.and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
		.cors().configurationSource(new CorsConfigurationSource(){
		    @Override
		    public CorsConfiguration getCorsConfiguration(HttpServletRequest request){
		        CorsConfiguration config = new CorsConfiguration();
		        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		        config.setAllowedMethods(Collections.singletonList("*"));
		        config.setAllowCredentials(true);
		        config.setAllowedHeaders(Collections.singletonList("*"));
		        config.setMaxAge(3600L);
		        return config;
		    }
		}).and().csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/registerUser")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
				.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
				.authorizeHttpRequests()
                .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoan", "/user").authenticated()
                .requestMatchers("/notices", "/contact", "/registerUser").permitAll()
                .and().formLogin(withDefaults()).httpBasic(withDefaults());
		return http.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
		//Approach I using withDefaultPasswordEncoder
//		@SuppressWarnings("deprecation")
//		UserDetails admin =  User.withDefaultPasswordEncoder()
//			.username("Santhu")
//			.password("12345")
//			.authorities("admin")
//			.build();
//		
//		@SuppressWarnings("deprecation")
//		UserDetails user = User.withDefaultPasswordEncoder()
//							   .username("Anne Hathaway")
//							   .password("12345")
//							   .authorities("read")
//							   .build();
		
//		UserDetails admin = User.withUsername("Santhu").password("12345").authorities("admin").build();
//		UserDetails user = User.withUsername("Anne Hathaway").password("12345").authorities("user").build();
//		
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
//	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
