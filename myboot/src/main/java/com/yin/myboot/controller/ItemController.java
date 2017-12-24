package com.yin.myboot.controller;

import com.yin.myboot.dto.TaoItemDTO;
import com.yin.myboot.model.TaoItem;
import com.yin.myboot.service.impl.ZcyItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcy on 2017/12/19.
 */

@RestController
public class ItemController {
    @Autowired
    private ZcyItemService zcyItemService;
private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    //public List<TaoItemDTO> getList(String itemIds){
    public String getList(String itemIds){
        logger.debug("ids are {}",itemIds);
        return "hello";
    }

    @RequestMapping(value = "/zcyitem/list",method = RequestMethod.GET)
    //public List<TaoItemDTO> getList(String itemIds){
    public String getZcyItemList(String itemIds){
        List<Long> ids = new ArrayList();
        ids.add((long)248);
        ids.add((long)352);
        ids.add((long)353);
        zcyItemService.getList(ids);
        return "hello";
    }

}
