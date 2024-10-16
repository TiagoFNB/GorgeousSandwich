package gourgeossandwich.controller.user;

import gourgeossandwich.domain.user.shopmanager.ShopManager;
import gourgeossandwich.dto.user.ShopManagerDTO;
import gourgeossandwich.service.user.CreateShopManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateShopManagerController {

    protected CreateShopManagerService createShopManagerService;

    public CreateShopManagerController(CreateShopManagerService createShopManagerService) {
        this.createShopManagerService = createShopManagerService;
    }

    public ResponseEntity<ShopManager> createShopManager(ShopManagerDTO shopManagerDTO) {
        return ResponseEntity.ok(createShopManagerService.createNewShopManager(shopManagerDTO));
    }
}
