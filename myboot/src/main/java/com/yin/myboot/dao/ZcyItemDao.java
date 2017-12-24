package com.yin.myboot.dao;

import com.yin.myboot.model.ZcyItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcy on 2017/12/22.
 */
@Repository
public class ZcyItemDao extends ZcyDao<ZcyItem> {

    public List<ZcyItem>  findbyIds(List<Long> ids){
        return super.findByIds(ids);
    }
}
