package com.example.mybatis.mapper;

import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author viper
 * @Date 2023/2/10 上午 11:21
 * @Version 1.0
 */

@Mapper
public interface UserMapper {
    //@Select() @Update() @Insert() @Delete() 這邊可以直接寫SQL，如果配置在這邊那Mapper.xml可以不用配置sql語法
    List<User> findAll();
    User findById(long id);
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);
    void updateUser(String username, String password, long id);
    void deleteUser(long id);
    void insertBatch(List<User> userList);
}
