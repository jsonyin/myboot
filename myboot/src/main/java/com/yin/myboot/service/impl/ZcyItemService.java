package com.yin.myboot.service.impl;

import com.yin.myboot.dao.ZcyItemDao;
import com.yin.myboot.model.ZcyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcy on 2017/12/22.
 */
@Service
public class ZcyItemService {
    @Autowired
    private ZcyItemDao zcyItemDao;

    public List<ZcyItem> getList(List<Long> ids){
        return zcyItemDao.findByIds(ids);
    }

}
