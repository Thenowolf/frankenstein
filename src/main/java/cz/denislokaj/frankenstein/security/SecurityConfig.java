package cz.denislokaj.frankenstein.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cz.denislokaj.frankenstein.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }*/
	@Autowired
	UserService user;
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http.authorizeHttpRequests()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/login*")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/*")).permitAll()
	            .and()
	            .csrf().ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
	            .and()
	            .csrf().ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/login*"))
	            .and()
	            .formLogin().permitAll()
	    		.and()
	    		.userDetailsService(user)
	            .headers(headers -> headers.frameOptions().sameOrigin())
	            .build();
	}
}
