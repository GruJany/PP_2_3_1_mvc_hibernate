package web.service;

import web.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    void deleteUserById(int id);
    List<User> getAllUsers();
    User updateUser(int id, User user);
    Optional<User> getUserById(int id);
}
