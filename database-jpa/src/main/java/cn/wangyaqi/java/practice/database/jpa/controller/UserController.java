package cn.wangyaqi.java.practice.database.jpa.controller;

import cn.wangyaqi.java.practice.database.jpa.dao.UserDao;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", method = RequestMethod.GET)
public class UserController {

  @Resource
  private UserDao userDao;

  // http://127.0.0.1:9050/user/all
  @RequestMapping("/all")
  public Object all() {
    long count = userDao.count();
    System.out.println("count=" + count);
    return userDao.findAll();
  }

  // http://127.0.0.1:9050/user/findByName/zhangsan
  @RequestMapping("/findByName/{name}")
  public Object findByName(@PathVariable String name) {
    return userDao.findByName(name);
  }
}