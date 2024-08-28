package com.powernode.mall.service;

import com.powernode.mall.po.TVersion;

import java.util.ArrayList;

public interface IVerisonService {
    void addVersion(TVersion version);

    void removeVersion(Integer vid);

    void updateVersion(TVersion version);

    TVersion getVersion(Integer vid);

    void removeByPid(Integer pid);

    ArrayList<TVersion> getVersionByPid(Integer pid);
}
