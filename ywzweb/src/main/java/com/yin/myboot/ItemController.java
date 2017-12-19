package com.yin.myboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zcy on 2017/12/6.
 */
@Controller
public class ItemController {

    @ResponseBody
    @RequestMapping(value="/item/create",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public Response<String> itemCreate(Item item){
        item.getBrand();
        System.out.print("come here");
        return new Response<String>(false,"message");
    }

    @ResponseBody
    @RequestMapping(value="/item/create",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String itemCreate(String itemName){
        //item.getBrand();
        System.out.print("come here");
        return "cb({\"status\":"+false +"})";
    }

    @RequestMapping(value = "/item/view",method = RequestMethod.GET)
    public String itemView(){

        return "item_create";
    }
}
