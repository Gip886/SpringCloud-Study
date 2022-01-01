package com.gip.controller;


import com.gip.pojo.Dept;
import com.gip.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class DeptConsumerController {
   @Autowired
   private DeptClientService deptClientService;


    /**
     * 消费方添加部门信息
     * @param dept
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {

        return deptClientService.addDept(dept);
    }

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        // getForObject(服务提供方地址(接口),返回类型.class)
        return deptClientService.queryAll();
    }

}
