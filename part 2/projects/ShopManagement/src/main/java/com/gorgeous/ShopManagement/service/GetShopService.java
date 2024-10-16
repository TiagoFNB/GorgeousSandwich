package com.gorgeous.ShopManagement.service;

import com.gorgeous.ShopManagement.ShopRepository;
import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.domain.ShopInternalId;
import org.springframework.stereotype.Service;

@Service
public class GetShopService {
    protected ShopRepository shopRepository;

    public GetShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop get(String id) {
        return this.shopRepository.getShopById(new ShopInternalId(id));
    }
}
