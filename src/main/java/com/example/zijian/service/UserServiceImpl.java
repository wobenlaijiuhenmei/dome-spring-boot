package com.example.zijian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    public JdbcTemplate jdbcTemplate;



    @Override
    public void addNewMan(Integer id, String name, String sex, Integer age, String role) {
        jdbcTemplate.update("insert into USER(id,name,sex,age,role) values(?,?,?,?,?)", id,name,sex,age,role);
    }

    @Override
    public void delaMan(Integer id) {
        jdbcTemplate.update("delete from USER where id = ?", id);

    }

    @Override
    public void changeAge(String name, Integer age) {
        jdbcTemplate.update("update USER SET age='？' where name =?",age,name);

    }

    @Override
    public int oneSele(Integer id) {
        return jdbcTemplate.update("select age from uesr where id=?",id);
    }

    @Override
    public List<Map<String, Object>> getAllUsers() {
        return jdbcTemplate.queryForList("select * from user");
    }
}
