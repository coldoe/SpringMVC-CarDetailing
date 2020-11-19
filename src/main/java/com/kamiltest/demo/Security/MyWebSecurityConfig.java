package com.kamiltest.demo.Security;

import com.kamiltest.demo.manager.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/car/addcar").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/car/getallcars").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/car/updatecar/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/car/deletecar/**").hasAnyAuthority("ADMIN")

                .antMatchers("/api/client/addclient").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/client/assigncartoclient").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/client/getallclients").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/client/updateclient/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/client/deleteclient/**").hasAnyAuthority("ADMIN")

                .antMatchers("/api/order/addorder").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/order/getallorders").hasAnyAuthority("ADMIN","MODERATOR","WORKER")
                .antMatchers("/api/order/getspecificorder/client/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/order/getspecificorder/worker/**").hasAnyAuthority("ADMIN","WORKER")
                .antMatchers("/api/order/setboolean/done/**").hasAnyAuthority("ADMIN","WORKER")
                .antMatchers("/api/order/setboolean/payed/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/order/updateorder/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/order/deleteorder/**").hasAnyAuthority("ADMIN")


                .antMatchers("/api/service/addservice").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/service/getallservices").hasAnyAuthority("ADMIN","MODERATOR","WORKER")
                .antMatchers("/api/service/updateservice/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/service/deleteservice/**").hasAnyAuthority("ADMIN")

                .antMatchers("/api/worker/getallworkers").hasAnyAuthority("ADMIN","MODERATOR","WORKER")
                .antMatchers("/api/worker/addworker").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/worker/updateworker/**").hasAnyAuthority("ADMIN","MODERATOR")
                .antMatchers("/api/worker/deleteworker/**").hasAnyAuthority("ADMIN")
                .antMatchers("/api/worker/assignwork").hasAnyAuthority("ADMIN","MODERATOR")

                .antMatchers("/api/home").permitAll()

                .and()

                .formLogin().permitAll()
                .defaultSuccessUrl("/api/home")

                .and()

                .logout().permitAll()
                .deleteCookies()

                .and()

                .exceptionHandling().accessDeniedPage("/api/403")
        ;
    }
}
