package com.gorgeous.ShopManagement.controller;

import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.service.ListShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetShopController {

    protected ListShopService listShopService;

    public GetShopController(ListShopService listShopService) {
        this.listShopService = listShopService;
    }

    public List<Shop> listShop() {
        return listShopService.getAllShops();
    }
}
