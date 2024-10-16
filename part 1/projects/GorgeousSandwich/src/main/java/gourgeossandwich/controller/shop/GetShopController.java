package gourgeossandwich.controller.shop;

import gourgeossandwich.domain.shop.Shop;
import gourgeossandwich.service.shop.ListShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetShopController {

    protected ListShopService listShopService;

    public GetShopController(ListShopService listShopService) {
        this.listShopService = listShopService;
    }

    public ResponseEntity<List<Shop>> listShop() {
        return ResponseEntity.ok(listShopService.getAllShops());
    }
}
