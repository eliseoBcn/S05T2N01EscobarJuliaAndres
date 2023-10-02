package cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s05.t02.n01.security.JWTAuthorizationFilter;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class S05T2N01EscobarJuliaAndresApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T2N01EscobarJuliaAndresApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	
	class WebSecurityConfig  {

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            // disabling csrf since we won't use form login
	            .csrf().disable()
 				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
	            // giving permission to every request for /login endpoint
	            .authorizeRequests().antMatchers(HttpMethod.POST,"/user").permitAll()
	            // for everything else, the user has to be authenticated
	            .anyRequest().authenticated()
	            // setting stateless session, because we choose to implement Rest API
	            .and().sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        return http.build();
	    }
	}
}
