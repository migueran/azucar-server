package com.mrando.azucardj.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

  @Bean
  UserDetailsManager usersDbManager( DataSource dataSource) {
    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    users.setUsersByUsernameQuery("SELECT username, password, status FROM users WHERE username = ?");
    users.setAuthoritiesByUsernameQuery("select u.username, p.profile from UsersProfiles up " + 
                                        "inner join Users u on u.id = u.id " + 
                                        "inner join Profiles p on ur.id = p.id " + 
                                        "where u.username = ?");
    return users;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authz) -> authz
        .requestMatchers("/**").permitAll()
        // .requestMatchers("/**").hasAuthority("admin")
        // .requestMatchers("/**").hasAuthority("writer")
        // .requestMatchers("/**").hasAuthority("guest")
        // .requestMatchers("/", "/lists", "/artists").permitAll()
        .anyRequest().authenticated()
      );

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
