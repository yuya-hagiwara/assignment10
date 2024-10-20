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


    public User insert(String name, String dateOfBirth) {
        User user = new User(name, dateOfBirth);
        userMapper.insert(user);
        return user;
    }


    public User update(int id, String name, String dateOfBirth) {
        User user = null;
        try {
            user = this.userMapper.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("user not found with id: " + id));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

        user.setName(name);
        user.setDateOfBirth(dateOfBirth);

        userMapper.update(user);
        return user;
    }
}
