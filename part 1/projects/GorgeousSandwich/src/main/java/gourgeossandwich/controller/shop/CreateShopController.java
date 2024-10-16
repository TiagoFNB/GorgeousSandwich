package gourgeossandwich.controller.shop;

import gourgeossandwich.domain.shop.Shop;
import gourgeossandwich.dto.shop.ShopDTO;
import gourgeossandwich.service.shop.CreateShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateShopController {

    protected CreateShopService createShopService;

    public CreateShopController(CreateShopService createShopService) {
        this.createShopService = createShopService;
    }

    public ResponseEntity<Shop> createShop(ShopDTO shopDTO) {
        return ResponseEntity.ok(createShopService.createNewShop(shopDTO));
    }
}
