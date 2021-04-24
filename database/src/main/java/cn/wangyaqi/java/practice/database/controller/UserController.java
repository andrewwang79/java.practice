package cn.wangyaqi.java.practice.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.service.UserService;
import cn.wangyaqi.java.practice.database.vo.UserBrief;

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

    // 实体对象+lambdaQuery
    // http://127.0.0.1:9050/user/page/name/zhangsan
    @RequestMapping("/page/name/{name}")
    public Object page_name(@PathVariable String name) {
        Page<User> page = new Page<>(1, 5);
        page.addOrder(OrderItem.desc("create_time"));
        LambdaQueryWrapper<User> wrappers = Wrappers.<User>lambdaQuery().like(User::getName, name);
        return userService.selectPage(page, wrappers);
    }

    // 视图子对象+sql
    // http://127.0.0.1:9050/user/page2/name/zhangsan
    @RequestMapping("/page2/name/{name}")
    public Object page2_name(@PathVariable String name) {
        Page<UserBrief> page = new Page<>(1, 5);
        page.addOrder(OrderItem.desc("update_time"));
        return userService.selectUserBriefPage(page, name);
    }
}