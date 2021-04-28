package cn.wangyaqi.java.practice.database.dm.controller;

import cn.wangyaqi.java.practice.database.dm.entity.Cat;
import cn.wangyaqi.java.practice.database.dm.entity.User;
import cn.wangyaqi.java.practice.database.dm.service.CatService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cat", method = RequestMethod.GET)
public class CatController {

  @Autowired
  private CatService catService;

  // ALL
  // http://127.0.0.1:9050/cat/all
  @RequestMapping("/all")
  public Object all() {
    return catService.list(null);
  }

  // FIND
  // http://127.0.0.1:9050/cat/findAllByName/c/zs1
  @RequestMapping("/findAllByName/c/{name}")
  public Object findAllByName_c(@PathVariable String name) {
    return catService.lambdaQuery().eq(Cat::getName, name).list();
  }

  // PAGE
  // 实体对象+LambdaQueryWrapper
  // http://127.0.0.1:9050/cat/page/name/zs1
  @RequestMapping("/page/name/{name}")
  public Object page_name(@PathVariable String name) {
    Page<Cat> page = new Page<>(1, 5);
    page.addOrder(OrderItem.desc("CREATE_TIME"));
    LambdaQueryWrapper<Cat> wrappers = Wrappers.<Cat>lambdaQuery().like(Cat::getName, name);
    return catService.selectPage(page, wrappers);
  }
}