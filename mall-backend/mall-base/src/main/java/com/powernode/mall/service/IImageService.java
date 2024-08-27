package com.powernode.mall.service;

import com.powernode.mall.po.TImage;

import java.util.ArrayList;

public interface IImageService {
    void addImage(TImage image);

    void removeImage(Integer iid);

    void updateImage(TImage image);

    TImage getImage(Integer iid);

    void removeImageByPid(Integer pid);

    ArrayList<TImage> getImageByPid(Integer pid);

    ArrayList<String> getImageBySidLimit4(Integer sid);
}
