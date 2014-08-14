package com.persistence.service;

import java.util.List;

import com.persistence.beans.User;
import com.persistence.dao.UserDao;

/**
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public User getUser(String email, String password){
        return getUserDao().getUser(email, password);
    }

    public User addUser(User user){
        return getUserDao().addUser(user);
    }

    private UserDao getUserDao(){
        return userDao;
    }
}
