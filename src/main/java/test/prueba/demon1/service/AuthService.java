package test.prueba.demon1.service;

import test.prueba.demon1.Repository.UserRepository;
import test.prueba.demon1.model.User;

public class AuthService {
    private UserRepository userRepository;

    // Constructor for dependency injection
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findUser(username, password);
        return user != null;  // Returns true if the user exists
    }
}

