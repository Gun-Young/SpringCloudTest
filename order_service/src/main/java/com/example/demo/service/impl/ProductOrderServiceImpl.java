package com.example.demo.service.impl;


import com.example.demo.domain.ProductOrder;
import com.example.demo.feign.ProductClient;
import com.example.demo.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.www.URLConnection;
import sun.net.www.http.HttpClient;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;

    @Override
    public ProductOrder save(int userId, int productId) {

        Object obj = restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId, Object.class);

        System.out.println(obj);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());

        return productOrder;
    }

    /**
     * 使用feign测试
     * @param id
     * @return
     */
    @Override
    public Object findProductById(int id){
        return productClient.findById(id);
    }
}
