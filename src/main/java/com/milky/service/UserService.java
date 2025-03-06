package com.milky.service;

import com.milky.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
}
