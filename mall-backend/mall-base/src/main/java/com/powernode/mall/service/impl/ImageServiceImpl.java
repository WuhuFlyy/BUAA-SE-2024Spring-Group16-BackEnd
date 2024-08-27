package com.powernode.mall.service.impl;

import com.powernode.mall.mapper.TImageMapper;
import com.powernode.mall.po.TImage;
import com.powernode.mall.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private TImageMapper imageMapper;

    public void addImage(TImage image){
        imageMapper.insert(image);
    }

    public void removeImage(Integer iid){
        imageMapper.deleteByPrimaryKey(iid);
    }

    public void updateImage(TImage image){
        imageMapper.updateByPrimaryKey(image);
    }

    public TImage getImage(Integer iid){
        return imageMapper.selectByPrimaryKey(iid);
    }

    public void removeImageByPid(Integer pid){
        imageMapper.deleteByPid(pid);
    }

    public ArrayList<TImage> getImageByPid(Integer pid){
        return imageMapper.selectByPid(pid);
    }

    public ArrayList<String> getImageBySidLimit4(Integer sid){
        return imageMapper.selectBySidLimit4(sid);
    }
}
