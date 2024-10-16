package com.gorgeous.UserManagement.controller;

import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.service.GetShopManagerByIdService;
import org.springframework.stereotype.Service;

@Service
public class GetShopManagerByIdController {

    protected GetShopManagerByIdService getShopManagerService;

    public GetShopManagerByIdController(GetShopManagerByIdService getShopManagerService) {
        this.getShopManagerService = getShopManagerService;
    }

    public ShopManager getShopManagerById(String id) {
        return getShopManagerService.getShopManagerById(id);
    }
}
