package com.yin.service.impl;

import com.yin.model.City;
import com.yin.model.ZQResp;
import com.yin.service.CityService;
//import org.springframework.stereotype.Service;

/**
 * Created by zcy on 2018/3/20.
 */
@org.springframework.stereotype.Service
public class CityServiceImpl implements CityService {
    
    @Override
    public ZQResp<City> findBycode(String code) {
        City c = new City("339900","浙江省本级");
        ZQResp<City> result = new ZQResp<City>(c);
        return result;
    }
}
