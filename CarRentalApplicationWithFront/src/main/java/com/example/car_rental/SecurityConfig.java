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
        http.cors().and().csrf().disable();
        http.httpBasic().and().authorizeRequests()
               ///.anyRequest().authenticated()
                .antMatchers(HttpMethod.POST, "/api/cars/save").hasRole("ADMIN")                            // dziala
                .antMatchers(HttpMethod.GET, "/api/customers/all").hasRole("ADMIN")                         // dziala
                .antMatchers(HttpMethod.DELETE, "/api/customers/del").hasRole("ADMIN")                      // dziala
                .antMatchers(HttpMethod.GET, "/api/rentals/all").hasRole("ADMIN")                           // dziala
                .antMatchers(HttpMethod.DELETE, "/api/rentals/del").hasRole("ADMIN")                        // nie moge sprawdzic
                .antMatchers(HttpMethod.DELETE, "/api/cars/del").hasRole("ADMIN")                           // dziala
                .antMatchers(HttpMethod.POST, "/api/rentals/save").hasAnyRole("USER", "ADMIN")       // nie moge sprawdzic
                .antMatchers(HttpMethod.POST, "/api/customers/save").hasAnyRole("USER", "ADMIN")     // dziala
                .antMatchers(HttpMethod.GET, "/api/cars/all").permitAll()                                   // zmiana
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }

}
