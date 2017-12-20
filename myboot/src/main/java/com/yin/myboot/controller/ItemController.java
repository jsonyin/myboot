package com.yin.myboot.controller;

import com.yin.myboot.dto.TaoItemDTO;
import com.yin.myboot.model.TaoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zcy on 2017/12/19.
 */

@RestController
public class ItemController {
private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    //public List<TaoItemDTO> getList(String itemIds){
    public String getList(String itemIds){
        logger.debug("ids are {}",itemIds);
        return "hello";
    }


}
