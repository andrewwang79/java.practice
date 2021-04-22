package cn.wangyaqi.java.practice.database.controller;

import cn.wangyaqi.java.practice.database.dao.UserDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path="/jpauser", method = RequestMethod.GET)
public class JpaUserController {

    @Resource
    private UserDao userDao;

    // http://127.0.0.1:9050/jpauser/all
    @RequestMapping("/all")
    public Object all() {
        long count = userDao.count();
        System.out.println("count=" + count);
        return userDao.findAll();
    }

    // http://127.0.0.1:9050/jpauser/findByName/zhangsan
    @RequestMapping("/findByName/{name}")
    public Object findByName(@PathVariable String name) {
        return userDao.findByName(name);
    }
}