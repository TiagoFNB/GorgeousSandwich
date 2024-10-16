package gourgeossandwich.service.shop;

import gourgeossandwich.domain.shop.Shop;
import gourgeossandwich.repository.shop.ShopRepository;
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
