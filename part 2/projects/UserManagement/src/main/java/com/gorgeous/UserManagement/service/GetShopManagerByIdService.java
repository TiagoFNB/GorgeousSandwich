package com.gorgeous.UserManagement.service;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.repository.ShopManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class GetShopManagerByIdService {

    protected ShopManagerRepository shopManagerRepository;

    public GetShopManagerByIdService(ShopManagerRepository shopManagerRepository) {
        this.shopManagerRepository = shopManagerRepository;
    }

    public ShopManager getShopManagerById(String id) {
        return this.shopManagerRepository.getShopManagerrById((new UserInternalId(id)));
    }
}

