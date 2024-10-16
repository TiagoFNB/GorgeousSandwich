package com.gorgeous.ShopManagement.controller;

import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.service.GetShopService;
import org.springframework.stereotype.Service;

@Service
public class GetShopByIdController {
    protected GetShopService getShopService;

    public GetShopByIdController(GetShopService getShopService) {
        this.getShopService = getShopService;
    }

    public Shop get(String id) {
        return getShopService.get(id);
    }
}
