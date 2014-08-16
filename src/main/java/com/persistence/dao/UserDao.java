package com.persistence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.persistence.beans.User;

/**
 */
public class UserDao {

    private Integer id = 1;
    private Map<String, User> currentUsers = new HashMap<String, User>();

    public User getUser(String emailId, String password){
        if(currentUsers.containsKey(emailId)){
            User u =  currentUsers.get(emailId);
            if(u.getPassword().equals(password)){
                return u;
            }
            else{
                System.out.println("Invalid Password");
            }
        }
        else{
            System.out.println("User with email address not found.");
        }
        return null;
    }

    public User addUser(User user){
        if(!currentUsers.containsKey(user.getEmail())){
            user.setId(id.toString());
            currentUsers.put(user.getEmail(), user);
            id += 1;
        }
        else{
            System.out.println("User with email address already present.");
            return null;
        }
        return currentUsers.get(user.getEmail());
    }
}
