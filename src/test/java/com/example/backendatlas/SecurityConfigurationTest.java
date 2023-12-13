/*package com.example.backendatlas;

import com.example.backendatlas.config.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SecurityConfigurationTest {

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Test
    public void passwordEncoderBean_exists() {
        assertNotNull(SecurityConfiguration.passwordEncoder());
    }

    @Test
    public void filterChainBean_correctlyConfigured() {
        assertDoesNotThrow(() -> securityConfiguration.filterChain(null));
    }

    @Test
    public void authenticationManagerBean_exists() {
        assertDoesNotThrow(() -> securityConfiguration.authenticationManager(null));
    }

    @Test
    public void corsConfiguration_isCorrect() {
        CorsRegistry registry = new CorsRegistry();
        securityConfiguration.addCorsMappings(registry);
        // Her skal du tilføje yderligere checks for at bekræfte, at CORS konfigurationen er korrekt.
    }
}

*/