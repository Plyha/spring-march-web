package ru.specialist.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/sign-in")
                .defaultSuccessUrl("/")
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/")
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder,
                                UserDetailsService userDetailsService) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

}
