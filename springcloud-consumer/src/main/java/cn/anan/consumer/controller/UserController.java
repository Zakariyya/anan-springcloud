package cn.anan.consumer.controller;

import cn.anan.consumer.pojo.User;
import cn.anan.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anan
 * @create: 2019/4/3 16:13
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping("/")
  public List<User> getUser(){

    List<User> user = userService.getUser();
    return user;
  }

}
