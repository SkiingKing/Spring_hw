package com.example.spring_hw.service;

import com.example.spring_hw.Database;
import com.example.spring_hw.dao.UserDao;
import com.example.spring_hw.entity.UserImpl;
import com.example.spring_hw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDao {

    private final Logger logger = Logger.getLogger(String.valueOf(UserService.class));

    @Autowired
    UserDao userDao;

    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUsersByName(name, pageSize, pageNum);
    }

    public User createUser(UserImpl user) {
        logger.info("New user was created" + user.getId());
        return userDao.createUser(user);
    }

    public User updateUser(UserImpl user) {
        logger.info("User was updated" + user.getId());
        return userDao.updateUser(user);
    }

    public boolean deleteUser(long userId) {
        logger.info("User was deleted" + userId);
        return userDao.deleteUser(userId);
    }
}
