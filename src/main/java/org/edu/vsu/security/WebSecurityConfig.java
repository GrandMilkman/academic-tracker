package org.edu.vsu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth,
                                @Qualifier("userDetailsServiceImpl") final UserDetailsService userDetailsService)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new MessageDigestPasswordEncoder("MD5"));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/login**", "/**", "/js/**",
                        "/css/**", "/resources/**", "/academicCreateAction**", "/courseDelete**", "/courseEdit**",
                        "/courseCreate**", "/listCourse**", "/academicCreate**", "/academicCreateAction**",
                        "/academicDelete**", "/academicEdit**", "/listAcademic**", "/userDelete**", "/userEdit**",
                        "/userCreate**", "/listUser**").permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
            .headers()
                .frameOptions().sameOrigin();
    }
}
