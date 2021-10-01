package ru.vorobyov.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private DataSource myDataSource;
//
//	@Autowired
//	public void setMyDataSource(DataSource myDataSource) {
//		this.myDataSource = myDataSource;
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(myDataSource);
		
		User.UserBuilder users = User.builder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("{noop}admin").roles("USER", "ADMIN"))
			.withUser(users.username("user").password("{noop}user").roles("USER"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
//			.antMatchers("/hello*").hasAnyRole("ADMIN", "USER")
			.and()
			.formLogin()
			.permitAll()
			.and()
			.logout()
			.permitAll();
			
			
	}
}
