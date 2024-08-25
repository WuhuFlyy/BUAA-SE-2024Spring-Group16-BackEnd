package com.powernode.mall.mapper;

import com.powernode.mall.po.TCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TCartMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TCart row);

    int addNumByCid(int cid);

    int reduceNumByCid(int cid);

    TCart selectByPrimaryKey(Integer cid);

    ArrayList<TCart> selectByUid(int uid);

    List<TCart> selectAll();

    int updateByPrimaryKey(TCart row);
}