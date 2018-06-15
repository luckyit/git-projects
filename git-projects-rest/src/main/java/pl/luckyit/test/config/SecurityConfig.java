package pl.luckyit.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import pl.luckyit.test.model.User;
import pl.luckyit.test.model.enums.Encoding;
import pl.luckyit.test.properties.UserConfigurationProperties;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String REALM_NAME = "git-projects";

    @Autowired
    private UserConfigurationProperties userConfigurationProperties;

    @Bean
    public AuthenticationEntryPoint authEntryPoint() {
        BasicAuthenticationEntryPoint authEntryPoint = new BasicAuthenticationEntryPoint();
        authEntryPoint.setRealmName(REALM_NAME);
        return authEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        for(User user : userConfigurationProperties.getUsers()) {
            auth.inMemoryAuthentication()
                    .withUser(user.getLogin())
                    .password(user.getPasswordWithEncoding(Encoding.NOOP))
                    .roles(user.getRoles());
        }
    }

}