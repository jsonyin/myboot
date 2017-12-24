package com.yin.myboot.dao;

import com.yin.myboot.model.TaoItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface TaoItemDao {
     List<TaoItem> selectitems(Map map);
}
