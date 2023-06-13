package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        List<User> users = userService.list();
        return users;
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        User user = userService.getById(id);
        return user;
    }

    @PostMapping
    public String save(@RequestBody User user){
        boolean b = userService.save(user);
        String msg;
        if (b){
            msg="增加成功";
        }else {
            msg="增加失败";
        }
        return msg;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        boolean b = userService.removeById(id);
        String msg;
        if (b){
            msg="删除成功";
        }else {
            msg="删除失败";
        }
        return msg;
    }

    @PutMapping
    public String updateById(@RequestBody User user){
        boolean b = userService.updateById(user);
        String msg;
        if (b){
            msg="修改成功";
        }else {
            msg="修改失败";
        }
        return msg;

    }


}
