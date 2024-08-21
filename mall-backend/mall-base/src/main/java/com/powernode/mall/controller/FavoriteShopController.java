package com.powernode.mall.controller;

import com.powernode.mall.service.IFavoriteShopService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("favorite_shop")
public class FavoriteShopController extends BaseController {
    @Autowired
    private IFavoriteShopService favoriteShopService;

    @RequestMapping("add")
    public JsonResult<Void> addFavoriteShop(@RequestParam String username, @RequestParam Integer sid) {
        favoriteShopService.addFavoriteShop(username, sid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("remove")
    public JsonResult<Void> removeFavoriteShop(@RequestParam String username, @RequestParam Integer sid) {
        favoriteShopService.removeFavoriteShop(username, sid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("isFavorite")
    public JsonResult<Boolean> isFavoriteShop(@RequestParam String username, @RequestParam Integer sid) {
        boolean isFavorite = favoriteShopService.isFavoriteShop(username, sid);
        return new JsonResult<>(OK, isFavorite);
    }
}