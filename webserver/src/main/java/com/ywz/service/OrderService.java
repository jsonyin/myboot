package com.ywz.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by zcy on 2017/11/24.
 */
@WebService
public interface OrderService {
    int findOrderNumByCustomerId(@WebParam(name = "purchase") String purchase);

    Order findOrderById(@WebParam(name = "orderId") Long id);

}
