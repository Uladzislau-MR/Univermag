//package com.vladislav.univermag.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManBirthYearrBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//      @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManBirthYearrBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);
//
//    }
////        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
////        auth.inMemoryAuthentication()
////                .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
////                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
////                .withUser(userBuilder.username("vlad").password("vlad").roles("MANBirthYearR", "HR")
////                );
////
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANBirthYearR")
//                .antMatchers("/manBirthYearr_info").hasRole("MANBirthYearR")
//                .antMatchers("/hr_info").hasRole("HR")
//                .and().formLogin().permitAll();
//
//    }
//}
