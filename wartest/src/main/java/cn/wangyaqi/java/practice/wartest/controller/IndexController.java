package cn.wangyaqi.java.practice.wartest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @RequestMapping("test")
  public String test1() {
    return "testandrew";
  }
}