package se.iths.autofix.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import se.iths.autofix.security.jwt.config.JwtAuthenticationEntryPoint;
import se.iths.autofix.security.jwt.config.JwtRequestFilter;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AutofixUserDetailsService userDetailsService;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(AutofixUserDetailsService userDetailsService, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                          JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setAuthoritiesMapper(authoritiesMapper());
        return provider;
    }

    @Bean
    public GrantedAuthoritiesMapper authoritiesMapper() {
        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
        authorityMapper.setConvertToUpperCase(true);
        authorityMapper.setDefaultAuthority("USER");
        return authorityMapper;
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Kolla upp CSRF
//        http.addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        http.cors().and()
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "/home", "/client/create", "/authenticate").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest()
//                .authenticated()
//             //   .antMatchers("/admin").hasRole("ADMIN")
//                //.antMatchers("/client").hasRole("USER") // TODO: Avvakta med denna om denna behövs eller ej
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll();
//        http.headers().frameOptions().disable();
//    }
    @Configuration
    @Order(1)
    public class ApiSecurityAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
            http.antMatcher("/api/**")
                    //<= Security only available for /api/**
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/authenticate","/api/client/create").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.headers().frameOptions().disable();
        }
    }

@Configuration
@Order(2)
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http // <= Security available for others (not /api/)
//                .authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/resources/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/central", false)
//                .failureForwardUrl("/login/fail")
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/") ------
                .authorizeRequests()
                .antMatchers("/", "/home","/signUp").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/createClient").permitAll()
                .antMatchers("/MaintenanceRequest").permitAll()
                .antMatchers("/createMaintenanceAsClient").permitAll()
                .antMatchers("/Employee/**").hasRole("ADMIN")
                .antMatchers("/Maintenance/**").hasRole("ADMIN")
                .antMatchers("/createAdmin/**").hasRole("ADMIN")
                .antMatchers("/CreateSparePart/**").hasRole("ADMIN")
                .antMatchers("/saveSparePart").hasRole("ADMIN")
                .antMatchers("/saveUser").hasRole("ADMIN")

                //  .antMatchers("/Client/**").hasAnyRole("ADMIN","USER")
                .anyRequest()
                .authenticated()

             //   .antMatchers("/Client").hasRole("USER") // TODO: Avvakta med denna om denna behövs eller ej
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .and()
                .csrf().disable(); // ta bort disable om man vill ta bort åtkomst till /H2-console
        http.headers().frameOptions().disable();
    }
}
}
