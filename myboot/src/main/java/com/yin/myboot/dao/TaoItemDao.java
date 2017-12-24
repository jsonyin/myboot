package com.yin.myboot.dao;

import com.yin.myboot.model.TaoItem;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface TaoItemDao {
     List<TaoItem> selectitems(Map map);
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaoItemDao extends YinDao<TaoItem> {

    private static final Logger log = LoggerFactory.getLogger(TaoItemDao.class);

    public String findList(Long id){
        log.debug("this is yindatasource findlist");
        this.selectOne(id);
        return "1 2 3 4 5 6";
    }

>>>>>>> 68977c723a9e75597f9bcfadb0560ca4b0bf5b3b
}
