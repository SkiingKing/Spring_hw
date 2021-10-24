package com.example.spring_hw.dao;

import com.example.spring_hw.Database;
import com.example.spring_hw.entity.EventImpl;
import com.example.spring_hw.entity.UserImpl;
import com.example.spring_hw.model.Event;
import com.example.spring_hw.model.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserDao {
     default User getUserById(long userId) {
        return Database.getInstance().getMapOfUsers().get("user:" + userId);
    }

     default User getUserByEmail(String email) {
        return Database.getInstance().getMapOfUsers().values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

     default List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return Database.getInstance().getMapOfUsers().values().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

     default User createUser(UserImpl user) {
        return saveUser(user);
    }

     default User updateUser(UserImpl user) {
        return saveUser(user);
    }

    default boolean deleteUser(long userId) {
         if(Database.getInstance().getMapOfUsers().containsKey("user:" + userId)){
             Database.getInstance().getMapOfUsers().remove("user:" + userId);
             return true;
         }else return false;
    }

    default User saveUser(UserImpl user){
        return Database.getInstance().getMapOfUsers().put("event:" + user.getId(), user);
    }
}
