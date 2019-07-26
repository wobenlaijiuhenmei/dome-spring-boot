package com.example.zijian.web;


import com.example.zijian.service.UserService;
import com.example.zijian.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private  UserService userService;

//
//    @ResponseBody
//    @GetMapping("/query")
//    public Map<String, Object> map() {
//        List<Map<String, Object>> list =jdbcTemplate.queryForList("select *from user ");
//        return list.get(0);
//    }
//    @RequestMapping("/success")
//    public String succes() {
//        return "index1";
//    }


    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public  List<Map<String, Object>> data() {
        List<Map<String, Object>> acbd =jdbcTemplate.queryForList("select * from user ");
        return acbd;
    }



}

