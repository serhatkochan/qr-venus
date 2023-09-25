package xtech.qrvenus.core.utilities.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xtech.qrvenus.business.rules.UserBusinessRules;
import xtech.qrvenus.core.utilities.exceptions.BusinessException;
import xtech.qrvenus.dataAccess.abstracts.UserRepository;

@Configuration
@AllArgsConstructor
public class ApplicationConfig {
    private UserRepository userRepository;
    private UserBusinessRules userBusinessRules;



    @Bean
    public UserDetailsService userDetailsService() {
        return phoneNumber -> {
            userBusinessRules.checkIfUserPhoneNumberNotExists(phoneNumber);
            return userRepository.findByPhoneNumber(phoneNumber);
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
