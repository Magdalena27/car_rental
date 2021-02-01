package com.example.car_rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select login, password, enabled from customer where login=?")
                .authoritiesByUsernameQuery("select login, role from customer where login=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
               // .anyRequest().authenticated()
                .antMatchers(HttpMethod.GET, "/api/customers/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/customers/del").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "api/customers/save").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/rentals/").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/rentals/del").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/rentals/save").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "api/cars/").hasAnyRole()
                .antMatchers(HttpMethod.POST, "api/cars/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "api/cars/del").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }

}
