package cn.wangyaqi.java.practice.database.controller;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user", method = RequestMethod.GET)
public class UserController {

    @Autowired
    private UserService userService;

    // http://127.0.0.1:9050/user/all
    @RequestMapping("/all")
    public Object all() {
        return userService.list(null);
    }

    // http://127.0.0.1:9050/user/findAllByName/c/zhangsan
    @RequestMapping("/findAllByName/c/{name}")
    public Object findAllByName_c(@PathVariable String name) {
        return userService.lambdaQuery().eq(User::getName, name).list();
    }

    // http://127.0.0.1:9050/user/findAllByName/s/zhangsan
    @RequestMapping("/findAllByName/s/{name}")
    public Object findAllByName_s(@PathVariable String name) {
        return userService.findAllByName_lambda(name);
    }

    // http://127.0.0.1:9050/user/findAllByName/m/zhangsan
    // TODO : 无效
    @RequestMapping("/findAllByName/m/{name}")
    public Object findAllByName_m(@PathVariable String name) {
        return userService.findAllByName_m(name);
    }

    // http://127.0.0.1:9050/user/update/zhangsan/13912345677
    @RequestMapping("/update/{name}/{phone}")
    public Object update(@PathVariable String name, @PathVariable String phone) {
        return userService.updatePhoneByName_lambda(phone, name);
    }
}