package web.dao;

import web.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);
    void deleteUserById(int id);
    List<User> getAllUsers();
    User updateUser(User user);
    Optional<User> getUserById(int id);
}
