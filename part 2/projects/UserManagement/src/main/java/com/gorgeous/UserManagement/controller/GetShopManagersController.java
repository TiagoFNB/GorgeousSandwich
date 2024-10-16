package com.gorgeous.UserManagement.controller;


import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.service.ListShopManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetShopManagersController {

    protected ListShopManagerService listShopManagerService;

    public GetShopManagersController(ListShopManagerService listShopManagerService) {
        this.listShopManagerService = listShopManagerService;
    }

    public List<ShopManager> listShopManagers() {
        return listShopManagerService.getAllShopManagers();
    }
}

