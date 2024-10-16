package gourgeossandwich.route.user;

import gourgeossandwich.controller.user.CreateAdminController;
import gourgeossandwich.controller.user.CreateShopManagerController;
import gourgeossandwich.controller.user.GetShopManagersController;
import gourgeossandwich.dto.user.AdminDTO;
import gourgeossandwich.dto.user.ShopManagerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shopmanager")
public class ShopManagerRoute {

    protected GetShopManagersController getShopManagersController;
    protected CreateShopManagerController createShopManagerController;

    public ShopManagerRoute(CreateShopManagerController createShopManagerController,
                            GetShopManagersController getShopManagersController) {
        this.createShopManagerController = createShopManagerController;
        this.getShopManagersController = getShopManagersController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody ShopManagerDTO shopManagerDTO) {
        try{
            return createShopManagerController.createShopManager(shopManagerDTO);
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getList() {
        try{
            return getShopManagersController.listShopManagers();
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}
