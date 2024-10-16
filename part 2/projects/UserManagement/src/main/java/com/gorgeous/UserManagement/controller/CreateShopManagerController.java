package com.gorgeous.UserManagement.controller;

import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.dto.ShopManagerDTO;
import com.gorgeous.UserManagement.service.CreateShopManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateShopManagerController {

    protected CreateShopManagerService createShopManagerService;

    public CreateShopManagerController(CreateShopManagerService createShopManagerService) {
        this.createShopManagerService = createShopManagerService;
    }

    public ShopManager createShopManager(ShopManagerDTO shopManagerDTO) throws Exception {
        return createShopManagerService.createNewShopManager(shopManagerDTO);
    }
}
