package cn.wangyaqi.java.practice.database.dm.controller;

import cn.wangyaqi.java.practice.database.dm.entity.User;
import cn.wangyaqi.java.practice.database.dm.service.UserService;
import cn.wangyaqi.java.practice.database.dm.vo.CatDetail;
import cn.wangyaqi.java.practice.database.dm.vo.UserBrief;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.time.LocalDateTime;
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

  // INSERT : userService.save()

  // ALL
  // http://127.0.0.1:9050/user/all
  @RequestMapping("/all")
  public Object all() {
    return userService.list(null);
  }

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

  // 联表查询：符合主表字段条件的子表列表，返回的列表项中有一个字段是主表的
  // http://127.0.0.1:9050/user/find_catdetail_List/zhangsan
  @RequestMapping("/find_catdetail_List/{userName}")
  public Object findCatDetailList(@PathVariable String userName) {
    return userService.findCatDetailList(userName);
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

  // PAGE
  // 实体对象+LambdaQueryWrapper
  // http://127.0.0.1:9050/user/page/name/zhangsan
  @RequestMapping("/page/name/{name}")
  public Object page_name(@PathVariable String name) {
    Page<User> page = new Page<>(1, 5);
    page.addOrder(OrderItem.desc("CREATE_TIME"));
    LambdaQueryWrapper<User> wrappers = Wrappers.<User>lambdaQuery().like(User::getName, name);
    return userService.selectPage(page, wrappers);
  }

  // 视图子对象+sql
  // http://127.0.0.1:9050/user/page2/name/zhangsan
  @RequestMapping("/page2/name/{name}")
  public Object page2_name(@PathVariable String name) {
    Page<UserBrief> page = new Page<>(1, 5);
    page.addOrder(OrderItem.desc("UPDATE_TIME"));
    return userService.selectUserBriefPage(page, name);
  }

  // 分页联表查询：QueryWrapper
  // https://www.codeleading.com/article/21282428947/
  // http://127.0.0.1:9050/user/page/catdetail/zhangsan
  @RequestMapping("/page/catdetail/{userName}")
  public Object page_catdetail(@PathVariable String userName) {
    Page<CatDetail> page = new Page<>(1, 5);
    return userService.selectCatDetailPage(page, userName);
  }

  // 分页联表查询：SQL
  // http://127.0.0.1:9050/user/page/catdetail_sql/zhangsan
  @RequestMapping("/page/catdetail_sql/{userName}")
  public Object page_catdetailSQL(@PathVariable String userName) {
    Page<CatDetail> page = new Page<>(1, 5);
    LocalDateTime createTime = LocalDateTime.now().minusDays(100);
    return userService.selectCatDetailPageSql(page, userName, createTime);
  }
}