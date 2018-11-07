package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service",fallback = ProductClientFallBack.class)  //feign调用失败后的降级处理
public interface ProductClient {
    @RequestMapping(value = "/api/v1/product/find",method = RequestMethod.GET)
    Object findById(@RequestParam("id") int id);
}