package com.bobo.dealcontroller.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.UserService;
import com.bobo.deal.bean.User;
import com.bobo.dealcontroller.util.CryptManager;
import com.bobo.dealcontroller.util.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserSecurity userSecurity;
    @Autowired
    CryptManager cryptManager;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurity).passwordEncoder(new PasswordEncoder() {
            public String encode(CharSequence charSequence) {

                return cryptManager.getCrpyt(charSequence.toString());
            }

            public boolean matches(CharSequence charSequence, String s) {
                return cryptManager.matched(charSequence.toString(),s);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/open/**","/static/**").permitAll()
                .antMatchers("/manager/**").hasRole("管理员")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login_page").successHandler(new AuthenticationSuccessHandler() {
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {

                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();


                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                })
                .loginProcessingUrl("/login")
                .usernameParameter("email").passwordParameter("password").permitAll()
                .and()
                .logout().logoutUrl("/layout").logoutSuccessUrl("/open/success_logout").permitAll()
                .and()
                .csrf().disable().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
    }
    @Override
     public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/image/**","/static/**");
    }
    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }

}
