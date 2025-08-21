package com.example.com.service;

import com.example.com.model.User;
import com.example.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String username,String password) {
        User user = userRepository.login(username, password);
        if(user == null){
            throw new RuntimeException("Vui lòng không được để trống tên đăng nhập hoặc password");
        }
        return user;
    }
    public boolean checkExistUsername(String username){
        return userRepository.checkExistUsername(username);
    }

    public boolean save(User user) {
        return userRepository.save(user);
    }
}
