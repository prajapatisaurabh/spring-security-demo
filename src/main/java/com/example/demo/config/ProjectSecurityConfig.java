package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @author SAURABH
 */
@Configuration
public class ProjectSecurityConfig  extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withUsername("root1").password("root1").authorities("ADMIN").build();
//        UserDetails user2 = User.withUsername("user").password("user").authorities("USER").build();
//
//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(user2);
//        auth.userDetailsService(userDetailsManager);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((r) -> r.antMatchers("/account").authenticated()
                                    .antMatchers("/balance").authenticated()
                                    .antMatchers("/main").permitAll()
                                    .antMatchers("/update").permitAll()
        );
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    public PasswordEncoder getObject()
    {
        return NoOpPasswordEncoder.getInstance();
    }

}
