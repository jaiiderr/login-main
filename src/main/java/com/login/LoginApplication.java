package com.login;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clase de arranque de Spring Boot.
 *
 * exclude = UserDetailsServiceAutoConfiguration.class:
 * Spring Boot detecta Spring Security en el classpath y auto-configura
 * un UserDetailsService en memoria con un usuario "user" y contraseña
 * aleatoria. Al excluirla, solo nuestro SecurityConfig controla la
 * autenticación vía JWT.
 */
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    /**
     * Bean temporal que genera hashes BCrypt para múltiples usuarios.
     *
     * Uso: los hashes impresos en consola se copian para insertarlos
     * manualmente en MySQL como usuarios de prueba del sistema electoral.
     *
     * IMPORTANTE: BORRAR este método después de crear los usuarios.
     * Este código se ejecuta en cada arranque de la aplicación y genera
     * hashes nuevos cada vez (BCrypt usa salt aleatorio), por lo que
     * los hashes impresos solo son útiles la primera vez.
     */
    @Bean
    public CommandLineRunner generarHashes() {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            System.out.println("═══════════════════════════════════════");
            System.out.println("HASHES GENERADOS PARA LA BASE DE DATOS:");
            System.out.println("═══════════════════════════════════════");
            System.out.println("maria123 → " + encoder.encode("maria123"));
            System.out.println("juan456  → " + encoder.encode("juan456"));
            System.out.println("pedro789 → " + encoder.encode("pedro789"));
            System.out.println("═══════════════════════════════════════");
        };
    }
}