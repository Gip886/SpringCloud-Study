package com.gip.controller;


import com.gip.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class DeptConsumerController {
    /*理解：消费者不应该有服务层*/
    // RestFul

    //服务提供方地址前缀
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    //Ribbon 在这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    //服务提供方地址前缀
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的Restful服务模板


    /**
     * 消费方添加部门信息
     * @param dept
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        System.out.println(dept);
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, boolean.class);
    }

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        // getForObject(服务提供方地址(接口),返回类型.class)
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
