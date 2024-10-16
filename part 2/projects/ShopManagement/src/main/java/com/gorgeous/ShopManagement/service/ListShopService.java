package com.gorgeous.ShopManagement.service;

import com.gorgeous.ShopManagement.ShopRepository;
import com.gorgeous.ShopManagement.domain.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListShopService {

    protected ShopRepository shopRepository;

    public ListShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getAllShops() {
        return this.shopRepository.findAll();
    }
}
