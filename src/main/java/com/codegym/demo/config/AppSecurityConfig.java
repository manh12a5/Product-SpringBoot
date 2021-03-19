package com.codegym.demo.config;

import com.codegym.demo.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

//    //Cấu hình Account trực tiếp trên config
//    @Bean
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
//        memoryUserDetailsManager.createUser(userBuilder.username("hung").password("123456").roles("USER").build());
//        memoryUserDetailsManager.createUser(userBuilder.username("vohung").password("123456").roles("ADMIN").build());
//        return memoryUserDetailsManager;
//    }

    //Cấu hình Login
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/about").permitAll()
                .and()
                .authorizeRequests().antMatchers("/category/**").hasAnyRole("ADMIN", "SHOP")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/products/**").hasAnyRole("USER", "ADMIN", "SHOP")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/products/**").hasAnyRole("ADMIN", "SHOP")
                .and()
                .formLogin().successHandler(customSuccessHandler)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedPage("/error-403");
        http.csrf().disable();
    }

}
