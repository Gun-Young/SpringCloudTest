package com.example.demo.controller;


import com.example.demo.service.ProductOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {


    @Autowired
    private ProductOrderService productOrderService;


    /**
     * 保存订单信息
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "saveOrderFail")  //在此方法上加入熔断机制，出异常会调用saveOrderFail
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id") int productId){
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",0);
        msg.put("msg","成功");
        msg.put("data",productOrderService.save(userId, productId));
        return msg;
    }

    //熔断时调用的方法：注意： 参数列表要一致
    public Object saveOrderFail(int userId,int productId){
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",-1);
        msg.put("msg","人数太多，您被挤出来了，稍等重试");
        return msg;
    }


    @RequestMapping(value = "/findProduct",method = RequestMethod.GET)
    public Object findProductById(@RequestParam("id") int id){
        return productOrderService.findProductById(id);
    }

}
