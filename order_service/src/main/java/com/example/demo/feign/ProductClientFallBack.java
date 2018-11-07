package com.example.demo.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 调用失败后的降级处理
 */

@Service
public class ProductClientFallBack implements ProductClient {
    @Override
    public Object findById(@RequestParam("id") int id) {
        String msg = "feign调用失败，这里是降级处理";
        return msg;
    }
}