package com.example.demo.service;


import com.example.demo.domain.ProductOrder;

/**
 * 订单业务类
 */
public interface ProductOrderService {


    /**
     * 下单接口
     * @param userId
     * @param productId
     * @return
     */
     ProductOrder save(int userId, int productId);


    /**
     * 根据id查询商品
     * @param id
     * @return
     */
     Object findProductById(int id);

}
