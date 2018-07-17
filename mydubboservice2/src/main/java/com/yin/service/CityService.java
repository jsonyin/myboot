package com.yin.service;

import com.yin.model.City;
import com.yin.model.ZQResp;

/**
 * Created by zcy on 2018/3/20.
 */
public interface CityService {
    ZQResp<City>  findBycode(String code);
}
