package cn.anan.provider.pojo;

import java.io.Serializable;

/**
 * @author: anan
 * @create: 2019/4/3 11:22
 * @Description:
 */
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private Integer age;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public User(){}

  public User(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }
}
