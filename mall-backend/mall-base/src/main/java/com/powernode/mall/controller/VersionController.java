package com.powernode.mall.controller;

import com.powernode.mall.po.TVersion;
import com.powernode.mall.service.IVerisonService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("version")
public class VersionController extends BaseController{
    @Autowired
    private IVerisonService versionService;

    @RequestMapping("add")
    public JsonResult<?> addVersion(@RequestParam TVersion version){
        versionService.addVersion(version);
        return new JsonResult<>(OK);
    }

    @RequestMapping("remove")
    public JsonResult<?> removeVersion(@RequestParam Integer vid){
        versionService.removeVersion(vid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<?> updateVersion(@RequestParam TVersion version){
        versionService.updateVersion(version);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get")
    public JsonResult<?> getVersion(@RequestParam Integer vid){
        TVersion version = versionService.getVersion(vid);
        return new JsonResult<>(OK, version);
    }

    @RequestMapping("getByPid")
    public JsonResult<?> getVersionByPid(@RequestParam Integer pid){
        ArrayList<TVersion> versions = versionService.getVersionByPid(pid);
        return new JsonResult<>(OK, versions);
    }

    @RequestMapping("removeByPid")
    public JsonResult<?> removeVersionByPid(@RequestParam Integer pid){
        versionService.removeByPid(pid);
        return new JsonResult<>(OK);
    }
}
