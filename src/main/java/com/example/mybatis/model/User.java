package com.example.mybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author viper
 * @Date 2023/2/10 上午 11:20
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    
    public User(){
    
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}

