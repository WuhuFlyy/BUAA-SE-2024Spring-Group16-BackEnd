package com.powernode.mall.mapper;

import com.powernode.mall.po.TImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TImageMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(TImage row);

    TImage selectByPrimaryKey(Integer iid);

    List<TImage> selectAll();

    ArrayList<TImage> selectByPid(Integer pid);

    ArrayList<String> selectBySidLimit4(Integer sid);

    int updateByPrimaryKey(TImage row);
}