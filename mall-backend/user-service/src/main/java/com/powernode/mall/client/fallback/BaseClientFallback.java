package com.powernode.mall.client.fallback;

import com.powernode.mall.client.BaseClient;
import com.powernode.mall.po.*;
import com.powernode.mall.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
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

}
