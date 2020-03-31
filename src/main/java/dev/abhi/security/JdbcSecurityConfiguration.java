package dev.abhi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class JdbcSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
		//BY DEFAULT SPRING EXPECTS TABLES AND COLUMNS AND EXECUTES BELOW QUERIES TO FETCH USER DETAILS
		//.usersByUsernameQuery(" select username, password, enabled from users where  username=?")
		//.authoritiesByUsernameQuery(" select username, authority from authorities where  username=?");
		//TO OVERRRIDE THIS WE CAN CHANGE THE QUERY SUCH.
		//e.g.  select username, password, enabled from my_users where  username=? ETC
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin").hasRole("ROLE_ADMIN").antMatchers("/user").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
				.antMatchers("/").permitAll().and().formLogin();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
