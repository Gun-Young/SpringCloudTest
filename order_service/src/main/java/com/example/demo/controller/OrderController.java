package com.example.demo.controller;


import com.example.demo.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id") int productId){
        return productOrderService.save(userId, productId);
    }




}
