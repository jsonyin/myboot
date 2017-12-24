package com.yin.myboot.controller;

import com.yin.myboot.dao.TaoItemDao;
import com.yin.myboot.dto.TaoItemDTO;
import com.yin.myboot.model.TaoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcy on 2017/12/19.
 */

@RestController
public class ItemController {
private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private TaoItemDao itemDao;

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    //public List<TaoItemDTO> getList(String itemIds){
    public String getList(String itemIds){
        logger.debug("ids are {}",itemIds);
        Map map = new HashMap<>();
        List ids = new ArrayList();
        ids.add("562379");
        map.put("ids",ids);
        List<TaoItem> s =itemDao.selectitems(map);
        s.get(0).getBrand();
        return "hello";
    }


}
