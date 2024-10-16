package gourgeossandwich.route.shop;

import gourgeossandwich.controller.shop.CreateShopController;
import gourgeossandwich.controller.shop.GetShopController;
import gourgeossandwich.dto.shop.ShopDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopRoute {

    protected CreateShopController createShopController;
    protected GetShopController getShopController;

    public ShopRoute(CreateShopController createShopController, GetShopController getShopController) {
        this.createShopController = createShopController;
        this.getShopController = getShopController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody ShopDTO shopDTO) {
        try{
            return createShopController.createShop(shopDTO);
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
            return getShopController.listShop();
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}
