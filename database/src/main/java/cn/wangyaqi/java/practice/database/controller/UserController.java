package cn.wangyaqi.java.practice.database.controller;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", method = RequestMethod.GET)
public class UserController {

    @Autowired
    private UserService userService;

    // ALL
    // http://127.0.0.1:9050/user/all
    @RequestMapping("/all")
    public Object all() {
        return userService.list(null);
    }

    // INSERT : userService.save()

    // FIND
    // http://127.0.0.1:9050/user/findAllByName/c/zhangsan
    @RequestMapping("/findAllByName/c/{name}")
    public Object findAllByName_c(@PathVariable String name) {
        return userService.lambdaQuery().eq(User::getName, name).list();
    }

    // http://127.0.0.1:9050/user/findAllByName/s/zhangsan
    @RequestMapping("/findAllByName/s/{name}")
    public Object findAllByName_s(@PathVariable String name) {
        return userService.findAllByName(name);
    }

    // http://127.0.0.1:9050/user/findAllByName/m/zhangsan
    @RequestMapping("/findAllByName/m/{name}")
    public Object findAllByName_m(@PathVariable String name) {
        return userService.findAllByName_mapper(name);
    }

    // UPDATE
    // http://127.0.0.1:9050/user/update/name/zhangsan/13912345677
    @RequestMapping("/update/name/{name}/{phone}")
    public Object updateByName(@PathVariable String name, @PathVariable String phone) {
        return userService.updatePhoneByName(phone, name);
    }

    // http://127.0.0.1:9050/user/update/id/1/13912345676
    @RequestMapping("/update/id/{id}/{phone}")
    public Object updateById(@PathVariable Integer id, @PathVariable String phone) {
        return userService.updatePhoneById(id, phone);
    }

    // DELETE
    // http://127.0.0.1:9050/user/delete/zhangsan
    @RequestMapping("/delete/{name}")
    public Object delete(@PathVariable String name) {
        userService.findAllByName(name).forEach(o -> userService.removeById(o.getId()));
        return true;
    }

    // http://127.0.0.1:9050/user/delete/zhangsan
    @RequestMapping("/delete2/{name}")
    public Object delete2(@PathVariable String name) {
        return userService.deleteByName(name); // 等同于userService.remove(Wrappers.<User>lambdaQuery().eq(User::getName, name));
    }
}