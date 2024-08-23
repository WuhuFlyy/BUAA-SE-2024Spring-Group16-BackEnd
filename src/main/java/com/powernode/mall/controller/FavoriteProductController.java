package com.powernode.mall.controller;

import com.powernode.mall.service.IFavoriteProductService;
import com.powernode.mall.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("favorite")
@CrossOrigin(origins="*")
public class FavoriteProductController extends BaseController {
    @Autowired
    private IFavoriteProductService favoriteProductService;

    @RequestMapping("add")
    public JsonResult<Void> addFavoriteProduct(@RequestParam String username, @RequestParam Integer pid) {
        favoriteProductService.addFavoriteProduct(username, pid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("remove")
    public JsonResult<Void> removeFavoriteProduct(@RequestParam String username, @RequestParam Integer pid) {
        favoriteProductService.removeFavoriteProduct(username, pid);
        return new JsonResult<>(OK);
    }

    @RequestMapping("isFavorite")
    public JsonResult<Boolean> isFavoriteProduct(@RequestParam String username, @RequestParam Integer pid) {
        boolean isFavorite = favoriteProductService.isFavoriteProduct(username, pid);
        return new JsonResult<>(OK, isFavorite);
    }
}