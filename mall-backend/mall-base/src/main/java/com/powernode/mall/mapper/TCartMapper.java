package com.powernode.mall.mapper;

import com.powernode.mall.po.TCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TCartMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TCart row);

    TCart selectByPrimaryKey(Integer cid);

    List<TCart> selectAll();

    int addNumByCid(int cid);

    int reduceNumByCid(int cid);

    ArrayList<TCart> selectByUid(int uid);

    ArrayList<TCart> selectByUsername(String username);

    int updateByPrimaryKey(TCart row);
}