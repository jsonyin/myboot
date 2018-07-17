package com.example.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zcy on 2018/1/19.
 */
//@RestController
//public class CityController {
//
//    @Reference(version = "1.0.0")
//    private CityService cityService;
//
//    @Reference(version = "1.0.0")
//    private TcTestService tcTestService;
//
//    @RequestMapping(value = "/city/getBycode",method = RequestMethod.GET)
//    public City getcityBycode(String code){
//        return cityService.findCityByCode("330000");
//    }
//
//    @RequestMapping(value = "/tc/tcTest",method = RequestMethod.GET)
//    public ZQResp<City> tcTest(){
//        return tcTestService.updateTable();
//    }
//}
