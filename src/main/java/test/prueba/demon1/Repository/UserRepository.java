package test.prueba.demon1.Repository;

import test.prueba.demon1.model.User;

public interface UserRepository {
    User findUser(String username, String password);
}

