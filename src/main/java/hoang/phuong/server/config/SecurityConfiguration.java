package hoang.phuong.server.config;

import hoang.phuong.server.config.security.CsrfRequestMatcher;
import hoang.phuong.server.config.security.RestUnauthorizedEntryPoint;
import hoang.phuong.server.config.security.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"hoang.phuong.server.config"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RestUnauthorizedEntryPoint restAuthenticationEntryPoint;
    private final AccessDeniedHandler restAccessDeniedHandler;
    private final AuthenticationSuccessHandler restAuthenticationSuccessHandler;
    private final AuthenticationFailureHandler restAuthenticationFailureHandler;

    @Inject
    public SecurityConfiguration(UserDetailsService userDetailsService,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 RestUnauthorizedEntryPoint restAuthenticationEntryPoint,
                                 AccessDeniedHandler restAccessDeniedHandler,
                                 AuthenticationSuccessHandler restAuthenticationSuccessHandler,
                                 AuthenticationFailureHandler restAuthenticationFailureHandler) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.restAccessDeniedHandler = restAccessDeniedHandler;
        this.restAuthenticationSuccessHandler = restAuthenticationSuccessHandler;
        this.restAuthenticationFailureHandler = restAuthenticationFailureHandler;
    }

    @Bean
    public ExUsernamePasswordAuthenticationFilter exUsernamePasswordAuthenticationFilter()
            throws Exception {
        ExUsernamePasswordAuthenticationFilter exUsernamePasswordAuthenticationFilter = new ExUsernamePasswordAuthenticationFilter();
        exUsernamePasswordAuthenticationFilter
                .setAuthenticationManager(authenticationManagerBean());
        return exUsernamePasswordAuthenticationFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Map<String, String[]> requireCsrfPatterns = new HashMap<>();
        requireCsrfPatterns.put("/api/users/**", new String[]{"GET", "PUT", "DELETE"});
        requireCsrfPatterns.put("/qlsv**", new String[]{"GET", "POST", "PUT", "DELETE"});
        requireCsrfPatterns.put("/api/logout", new String[]{"POST"});

        http.addFilterBefore(exUsernamePasswordAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .requireCsrfProtectionMatcher(new CsrfRequestMatcher(requireCsrfPatterns))
                .ignoringAntMatchers("/api/users")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/login").anonymous()
                .antMatchers(HttpMethod.POST, "/api/users/").anonymous()
                .antMatchers(HttpMethod.POST, "/api/users/**").anonymous()
                .antMatchers(HttpMethod.PATCH, "/api/users").anonymous()
//                .antMatchers("/api/users/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/khoa**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/**").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .formLogin()
                .loginProcessingUrl("/api/login")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout", "POST"))
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
//                .deleteCookies("JSESSIONID"); //I don't know what happen when i deleted this
    }

}
