package com.yin.myboot.controller;

import com.yin.myboot.dto.ReportBaseDTO;
import com.yin.myboot.service.impl.CacheDemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcy on 2018/7/5.
 */
@RestController
public class CacheDemoController {

    @Autowired
    private CacheDemoServiceImpl cacheDemoService;


    @RequestMapping(value = "hello")
    public String saysay(){
        return cacheDemoService.sayHello();
    }

    @RequestMapping(value = "flush")
    public String ffffff(){
        return cacheDemoService.flushCashe();
    }

    @RequestMapping(value = "selectById")
    public String selectById(String id){
        return cacheDemoService.selectById(id);
    }


    /**
     * todo 1.通过key值获取modelList中的model属性值
     * 2.通过mapKey将model放进map中
     * @param model
     * @param mapKey
     * @param keys
     * @return
     */
    private List<ReportBaseDTO> getResponseData(Class cls,List model,String mapKey,String... keys)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ArrayList data = new ArrayList<>();
        Object dto = null;
        Map<String,Object> map = new HashMap<>();
        String keyValue = null;
        for (Object m:model){
            Class modelClass =  m.getClass();
            Field field = modelClass.getDeclaredField(keys[0]);
            field.setAccessible(true);
            String keyObj = (String) field.get(m);

            Field mapfield = modelClass.getDeclaredField(mapKey);
            mapfield.setAccessible(true);
            String mapKeyObj = (String) field.get(m);

            if(keyValue != null && keyValue.equals(keyObj)){
                map.put(mapKeyObj,m);
            }else{


                if(keyValue != null){
                    Method method = dto.getClass().getMethod("setValueMap",Map.class);
                    method.invoke(map);
                    data.add(dto);
                }

                dto = cls.newInstance();

                if(keys.length>1){
                    for(int i=1;i<keys.length;i++){

                        //从model中获取key属性值
                        Field keyField = modelClass.getDeclaredField(keys[i]);
                        keyField.setAccessible(true);
                        String keyFieldValue = (String) field.get(m);

                        //将属性值付给dto对应的属性
                        Field dtoField = dto.getClass().getDeclaredField(keys[i]);
                        dtoField.setAccessible(true);
                        dtoField.set(dto,keyFieldValue);
                    }
                }

                map = new HashMap<>();
                keyValue = keyObj;
                map.put(mapKeyObj,m);
            }
        }

        Method method = dto.getClass().getMethod("setValueMap",Map.class);
        method.invoke(map);
        data.add(dto);
        return data;
    }

}
