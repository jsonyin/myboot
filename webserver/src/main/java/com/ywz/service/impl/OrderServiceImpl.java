package com.ywz.service.impl;

import com.ywz.service.Order;
import com.ywz.service.OrderService;

import javax.jws.WebService;

/**
 * Created by zcy on 2017/11/24.
 */
@WebService(endpointInterface = "com.ywz.service.OrderService")
public class OrderServiceImpl implements OrderService {
    public int findOrderNumByCustomerId(String purchase) {
        return 3;
    }

    public Order findOrderById(Long id) {
        Order o = new Order();
        o.setItemId(1232323);
        o.setPurchase("jason");
        o.setShop("yin");
        return o;
    }
}
