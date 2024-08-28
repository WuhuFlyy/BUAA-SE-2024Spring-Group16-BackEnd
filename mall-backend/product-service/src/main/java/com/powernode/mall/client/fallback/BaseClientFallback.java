package com.powernode.mall.client.fallback;

import com.powernode.mall.client.BaseClient;
import com.powernode.mall.po.*;
import com.powernode.mall.util.JsonResult;

import java.util.ArrayList;

public class BaseClientFallback implements BaseClient {
    @Override
    public JsonResult<?> insertShop(TShop shop) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<TShop> getShopBySid(Integer sid) {
        return new JsonResult<>(200, new TShop());
    }

    @Override
    public JsonResult<?> addComment(TComment comment) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<Void> removeComment(Integer commentId) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<Void> updateComment(TComment comment) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<TComment> getComment(Integer commentId) {
        return new JsonResult<>(200, new TComment());
    }

    @Override
    public JsonResult<ArrayList<TComment>> getCommentByPid(Integer pid) {
        return new JsonResult<>(200, new ArrayList<TComment>());
    }

    @Override
    public JsonResult<Void> addCommentImage(TCommentImage commentImage) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<Void> removeCommentImage(Integer commentImageId) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<Void> updateCommentImage(TCommentImage commentImage) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> getCommentImage(Integer commentImageId) {
        return new JsonResult<>(200, new TCommentImage());
    }

    @Override
    public JsonResult<?> addVersion(TVersion version) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> removeVersion(Integer vid) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> updateVersion(TVersion version) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> getVersion(Integer vid) {
        return new JsonResult<>(200, new TVersion());
    }

    @Override
    public JsonResult<?> getVersionByPid(Integer pid) {
        return new JsonResult<>(200, new ArrayList<TVersion>());
    }

    @Override
    public JsonResult<?> removeByPid(Integer pid) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> addImage(TImage image) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> removeImage(Integer iid) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<?> updateImage(TImage image) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<TImage> getImage(Integer iid) {
        return new JsonResult<>(200, new TImage());
    }

    @Override
    public JsonResult<?> removeImageByPid(Integer pid) {
        return new JsonResult<>(200);
    }

    @Override
    public JsonResult<ArrayList<TImage>> getImageByPid(Integer pid) {
        return new JsonResult<>(200, new ArrayList<TImage>());
    }

    @Override
    public JsonResult<ArrayList<TImage>> getImageBySid(Integer sid) {
        return new JsonResult<>(200, new ArrayList<TImage>());
    }
}
