package cn.anan.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anan
 * @created 2019/3/24 23:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/")
  public String ma(){
    return "111111111111111";
  }

}
