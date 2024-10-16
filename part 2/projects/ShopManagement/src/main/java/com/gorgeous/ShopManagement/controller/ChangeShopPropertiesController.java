package com.gorgeous.ShopManagement.controller;

import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.dto.ShopDTO;
import com.gorgeous.ShopManagement.service.ChangeShopPropertiesService;
import org.springframework.stereotype.Service;

@Service
public class ChangeShopPropertiesController {
    protected ChangeShopPropertiesService changeShopPropertiesService;

    public ChangeShopPropertiesController(ChangeShopPropertiesService changeShopPropertiesService) {
        this.changeShopPropertiesService = changeShopPropertiesService;
    }

    public Shop changeShopProperties(ShopDTO shopDTO) {
        return changeShopPropertiesService.changeShopProperties(shopDTO);
    }
}
