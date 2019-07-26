package com.example.zijian.service;



import java.util.List;
import java.util.Map;

public interface UserService {

//增加一个用户
    void addNewMan(Integer id, String name,String sex,Integer age,String role);
//删除一个用户
    void delaMan(Integer id);
//改变一个用户的年龄
    void changeAge(String name, Integer age);

    int oneSele(Integer id);
//查询所有的用户
    List<Map<String, Object>> getAllUsers();

}
