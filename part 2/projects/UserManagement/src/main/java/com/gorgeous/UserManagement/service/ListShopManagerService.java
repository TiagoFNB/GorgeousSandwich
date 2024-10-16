package com.gorgeous.UserManagement.service;

import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.repository.ShopManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListShopManagerService {

    protected ShopManagerRepository shopManagerRepository;

    public ListShopManagerService(ShopManagerRepository shopManagerRepository) {
        this.shopManagerRepository = shopManagerRepository;
    }

    public List<ShopManager> getAllShopManagers() {
        return this.shopManagerRepository.findAll();
    }
}
