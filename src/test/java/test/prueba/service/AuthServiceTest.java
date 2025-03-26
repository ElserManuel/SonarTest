package test.prueba.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.prueba.demon1.Repository.UserRepository;
import test.prueba.demon1.model.User;
import test.prueba.demon1.service.AuthService;

class AuthServiceTest {

    @BeforeEach
    void setUp() {
        System.out.println("Preparando Pruebas...");
    }

    @Test
    void testLoginSuccess() {
        UserRepository userRepository = mock(UserRepository.class);

        when(userRepository.findUser("user1", "password123"))
                .thenReturn(new User("user1", "password123"));

        AuthService authService = new AuthService(userRepository);

        boolean result = authService.login("user1", "passw2ord123");

        assertTrue(result, "El login debería ser exitoso");

        if (result) {
            System.out.println("¡Login exitoso! ");
        }
    }
}

