package com.example.demo.config;


import com.example.demo.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.example.demo" })
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl loginService;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/mainTeacher/**").hasRole("TEACHER")
                .antMatchers("/mainStudent/**").hasRole("STUDENT")
                .antMatchers("/mainAdmin/**").hasRole("ADMIN")
                .antMatchers("/resources/css/**").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                .anyRequest().authenticated()

                .and()

                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .successHandler(myAuthenticationSuccessHandler())
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()

                .and()


                .logout()
                .permitAll();
    }
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//      //  auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//
//
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username,password,enabled from schoolTest.account where username = ?")
//                .authoritiesByUsernameQuery(
//                        "select username, role from schoolTest.accountRole where username = ?").passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }



//@Autowired
//public void configAuthBuilder(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(accountService);
//}

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("u")
//                        .password("1")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}