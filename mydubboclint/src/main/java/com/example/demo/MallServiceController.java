package com.example.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.model.Admin;
import com.example.demo.model.User;
import com.yin.model.MallResponse;
import com.yin.model.OrderSearchCreator;
import com.yin.model.TbItem;
import com.yin.model.TbOrder;
import com.yin.service.TbItemCatService;
import com.yin.service.TbItemService;
import com.yin.service.TbOrderService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zcy on 2018/2/6.
 */
@RestController
public class MallServiceController {

    @Reference(version = "1.0.0")
    private TbItemService tbItemService;

    @Reference(version = "1.0.0")
    private TbItemCatService tbItemCatService;

    @Reference(version = "1.0.0")
    private TbOrderService tbOrderService;

    @RequestMapping(value = "/mall/selectByPrimaryKey",method = RequestMethod.POST)
    public MallResponse selectByPrimaryKey(TbItem item){
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(item.getId());
        ids.add(844022);
        ids.add(847276);
        map.put("ids",ids);
        map.put("title","三星%");
        //map.put("status","1");
        //map.put("endAt","2018-01-01 00:00:00");
        MallResponse result = tbItemService.selectByPrimaryKey(map);
        return result;
    }

    @RequestMapping(value = "/mall/itemcat/selectById",method = RequestMethod.GET)
    public MallResponse selectcatById(long id){
        return tbItemCatService.findById(id);
    }

    @RequestMapping(value = "/mall/itemcat/selectByParentId",method = RequestMethod.POST)
    public MallResponse selectcatByParentId(int[] ids){
        List l = new ArrayList();
        for(int id:ids){
            l.add(id);
        }
        return tbItemCatService.findByParentIds(l);
    }

    @RequestMapping(value = "/mall/order/create",method = RequestMethod.POST)
    public MallResponse createOrder(TbOrder order){
        return tbOrderService.insert(order);
    }

    @RequestMapping(value = "/mall/order/findBySearchCreator",method = RequestMethod.POST)
    public MallResponse findBySearchCreator(OrderSearchCreator creator){
        return tbOrderService.findbyCreator(creator);
    }

    //todo model test
    @RequestMapping(value = "/mvctest/bid",method = RequestMethod.GET)
    public String bidtest(User user, Admin admin){
        return user.toString()+admin.toString();
    }

    @InitBinder("user")
    public void userBinder(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void adminBinder(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("admin.");
    }
}
