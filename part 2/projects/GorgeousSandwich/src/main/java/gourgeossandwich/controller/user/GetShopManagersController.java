package gourgeossandwich.controller.user;


import gourgeossandwich.domain.user.shopmanager.ShopManager;
import gourgeossandwich.service.user.ListShopManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetShopManagersController {

    protected ListShopManagerService listShopManagerService;

    public GetShopManagersController(ListShopManagerService listShopManagerService) {
        this.listShopManagerService = listShopManagerService;
    }

    public ResponseEntity<List<ShopManager>> listShopManagers() {
        return ResponseEntity.ok(listShopManagerService.getAllShopManagers());
    }
}

