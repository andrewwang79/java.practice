package cn.wangyaqi.java.practice.misc.controller;

import cn.wangyaqi.java.practice.misc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = "用户管理POST版本")
@RestController
@RequestMapping(value = "/userp", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
public class UserPostController {

    // 模拟数据库存储的用户
    private static Map<Integer, User> userMap;

    static {
        userMap = new ConcurrentHashMap<>();
        User user = new User(1, "admin", true, new Date());
        userMap.put(user.getId(), user);
    }

    @ApiOperation(value = "列表查询", notes = "User类的列表")
    @RequestMapping("/list")
    public List<User> list() {
        return new ArrayList<>(userMap.values());
    }

    @ApiOperation(value = "获取用户", notes = "User类", response = User.class)
    @RequestMapping("/read")
    public User detail(@ApiParam(name = "用户ID", required = true, value = "{\"id\": 1}") @RequestBody String json) {
        return userMap.get(0);
    }

    @ApiOperation(value = "新增用户", notes = "User类", response = User.class)
    @RequestMapping("/create")
    public User create(@ApiParam(name = "用户", required = true, value = "{\"name\": \"abc\"...}") @RequestBody String json) {
        return userMap.get(0);
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping("/delete")
    public Boolean delete(@ApiParam(name = "用户ID", required = true, value = "{\"id\": 1}") @RequestBody String json) {
        return false;
    }

}