package cn.anan.provider.controller;

import cn.anan.provider.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anan
 * @created 2019/3/24 23:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/")
  public List<User> getUser(){

    List<User> list = new ArrayList<>();
    list.add(new User(1, "zhangsan", 22));
    list.add(new User(2,"lisi",24));
    list.add(new User(3,"wangwu",21));
    return list;
  }

}
