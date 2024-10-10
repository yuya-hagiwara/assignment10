package com.tutorial.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    List<User> getById(int id);

    @Insert("INSERT INTO users (name, date_of_birth) VALUES(#{name}, #{date_of_birth})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
}

