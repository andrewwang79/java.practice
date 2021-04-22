package cn.wangyaqi.java.practice.database.controller;

import cn.wangyaqi.java.practice.database.entity.Dog;
import cn.wangyaqi.java.practice.database.service.DogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.GET)
public class DogController {

    @Autowired
    private DogService dogService;

    // http://127.0.0.1:9050/dog/all
    @RequestMapping("/dog/all")
    public Object jpa_all() {
        return dogService.list();
    }

    // http://127.0.0.1:9050/dog/findByName/zhangsan
    @RequestMapping("/dog/findByName/{name}")
    public Object batis_findByName(@PathVariable String name) {
        List<Dog> list = dogService.list(new QueryWrapper<Dog>().lambda().eq(Dog::getName, name));
        return list;
    }
}