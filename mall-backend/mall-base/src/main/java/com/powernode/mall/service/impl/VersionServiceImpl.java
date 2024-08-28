package com.powernode.mall.service.impl;

import com.powernode.mall.mapper.TImageMapper;
import com.powernode.mall.mapper.TVersionMapper;
import com.powernode.mall.po.TImage;
import com.powernode.mall.po.TVersion;
import com.powernode.mall.service.IVerisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VersionServiceImpl implements IVerisonService {
    @Autowired
    private TVersionMapper versionMapper;

    public void addVersion(TVersion version){
        versionMapper.insert(version);
    }

    public void removeVersion(Integer vid){
        versionMapper.deleteByPrimaryKey(vid);
    }


    public void updateVersion(TVersion version){
        versionMapper.updateByPrimaryKey(version);
    }

    public TVersion getVersion(Integer vid){
        return versionMapper.selectByPrimaryKey(vid);
    }

    public void removeByPid(Integer pid){
        versionMapper.deleteByPid(pid);
    }

    public ArrayList<TVersion> getVersionByPid(Integer pid){
        return versionMapper.selectByPid(pid);
    }
}
