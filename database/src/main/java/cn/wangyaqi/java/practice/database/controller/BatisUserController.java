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
@RequestMapping(method = RequestMethod.GET)
public class BatisUserController {

    @Autowired
    private UserService userService;

    // http://127.0.0.1:9050/batis/all
    @RequestMapping("/batis/all")
    public Object jpa_all() {
        return userService.list(null);
    }

    // http://127.0.0.1:9050/batis/findByName/zhangsan
    @RequestMapping("/batis/findByName/{name}")
    public Object batis_findByName(@PathVariable String name) {
        List<User> list = userService.list(new QueryWrapper<User>().lambda().eq(User::getName, name));
        return list;
    }
}