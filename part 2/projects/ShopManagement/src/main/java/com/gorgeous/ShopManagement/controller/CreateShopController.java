package com.gorgeous.ShopManagement.controller;

import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.dto.ShopDTO;
import com.gorgeous.ShopManagement.service.CreateShopService;
import org.springframework.stereotype.Service;

@Service
public class CreateShopController {

    protected CreateShopService createShopService;

    public CreateShopController(CreateShopService createShopService) {
        this.createShopService = createShopService;
    }

    public Shop createShop(ShopDTO shopDTO) {
        return createShopService.createNewShop(shopDTO);
    }
}
