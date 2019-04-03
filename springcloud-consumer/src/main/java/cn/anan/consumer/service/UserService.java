package cn.anan.consumer.service;

import cn.anan.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 这里将调用 provider 服务
 *
 * @author: anan
 * @create: 2019/4/3 10:42
 * @Description:
 */

@Service
public class UserService {

  @Autowired
  private LoadBalancerClient loadBalancerClient; // ribbon 负载均衡器

  public List<User> getUser(){

    /**
     * 选择调用的服务的名称
     * ServiceInstance 封装了服务的基本信息，如IP，端口
     */
    ServiceInstance si = this.loadBalancerClient.choose("provider");

    /**
     * 拼接访问服务的URL
     */
    StringBuffer stringBuffer = new StringBuffer();

    /**
     * http://localhost:9090/user
     */
    stringBuffer.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/user/");

    /**
     * SpringMVC RestTemplate
     */
    RestTemplate rt = new RestTemplate();

    ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>(){};

    /**
     * ResponseEntity : 封装了返回值的信息
     *
     * rt.exchange(String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType)
     *
     * url: 要调用的url，这里是stringBuffer.toString()
     * method: 调用方式 HttpMethod.GET.POST.DELETE.PUT...
     * requestEntity: 请求参数实体
     * responseType: 返回值的实体
     */
    ResponseEntity<List<User>> responseEntity = rt.exchange(stringBuffer.toString(), HttpMethod.GET, null, type);

    return responseEntity.getBody();
  }
}
