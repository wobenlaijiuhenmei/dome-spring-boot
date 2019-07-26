package com.example.zijian.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloControllers {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> map() {
        List<Map<String, Object>> list =jdbcTemplate.queryForList("select *from user ");
        return list.get(0);
    }
    @RequestMapping("/success")
    public String succes() {
        return "index1";
    }

    @RequestMapping("/change")
    public String change() {
        return "index2";
    }
    @RequestMapping("add")
    public String addMan(Integer id, String names, String sex, Integer age, String role) {
        jdbcTemplate.update("insert into USER(id,names,sex,age,role) values(?,?,?,?,?)", id,names,sex,age,role);
        System.out.println(id+" "+names+" "+sex+" "+age+" "+role);
        return "index";
    }
    @RequestMapping("del")
    public String delMan(Integer id) {
        jdbcTemplate.update("delete from USER where id = ?",id);
        return "index1";
    }
    @RequestMapping("gai")
    public String gaiAge(Integer age,Integer id) {
//        System.out.println(id+"  "+age);
        String sql = "updata user set age=? where id=?";
       jdbcTemplate.update("update user set age=? where id=?",age,id);
        return "index1";
    }
    @RequestMapping("geng")
    public String gengXin(Integer id, String names, String sex, Integer age, String role) {
//        System.out.println(id+"  "+names+"  "+sex+"  " +age+"  "+role);
//        System.out.println(id.getClass().getName()+" "+names.getClass().getName()+"  "+sex.getClass().getName()+" "+age.getClass().getName()+" "+role.getClass().getName());
        jdbcTemplate.update("UPDATE user set names=?,sex=?,age=?,role=? where id=?",names,sex,age,role,id);
        return "index";
    }

}
