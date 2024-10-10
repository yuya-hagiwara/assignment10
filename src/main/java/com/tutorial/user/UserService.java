package com.tutorial.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.getAll();
    }

    public List<User> findById(int id) {
        return userMapper.getById(id);
    }

    public User insert(String name, String date_of_birth) {
        User user = new User(name, date_of_birth);
        userMapper.insert(user);
        return user;
    }
}
