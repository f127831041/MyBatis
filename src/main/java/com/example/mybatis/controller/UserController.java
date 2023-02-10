package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author viper
 * @Date 2023/2/10 上午 11:20
 * @Version 1.0
 */
@RestController
public class UserController {
    
    @Autowired
    private UserMapper userMapper;
    
    @GetMapping("/user")
    public List<User> getUserList() {
        return userMapper.findAll();
    }
    
    @GetMapping("/user/{id}")
    public User getUserList(@PathVariable("id") Long id) {
        return userMapper.findById(id);
    }
    
    @Transactional
    @GetMapping("/user/add")
    public User addUser() {
        User user = new User();
        user.setUsername("馬五");
        user.setPassword("123456");
        userMapper.insertUser(user);
        return user;
    }
    
    @Transactional
    @GetMapping("/user/batchAdd")
    public void batchAddUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        userMapper.insertBatch(users);
    }
    
    @Transactional
    @GetMapping("/user/update/{id}")
    public void updateUser(@PathVariable("id") Long id) {
        userMapper.updateUser("王老先生", "3345678", id);
    }
    
    @Transactional
    @GetMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userMapper.deleteUser(id);
    }
}
