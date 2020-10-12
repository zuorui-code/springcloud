package controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Line;

/**
 * @author zuorui
 * @creat 2020-10-12-15:16
 */

@RestController
public class CustomerController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/customer")
    public String customer() {

        //通过eurekaClien获取到search服务的信息
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("SEARCH", false);

        //获取访问的地址
        String url = instanceInfo.getHomePageUrl();
        System.out.println(url);
        //通过restTemplate访问
         String result = restTemplate.getForObject(url+ "/search" , String.class);
        //返回
        return result;
    }
}
