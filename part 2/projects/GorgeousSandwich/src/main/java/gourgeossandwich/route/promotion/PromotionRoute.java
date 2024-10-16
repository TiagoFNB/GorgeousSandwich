package gourgeossandwich.route.promotion;


import gourgeossandwich.controller.promotion.CreatePromotionController;
import gourgeossandwich.controller.promotion.GetPromotionController;
import gourgeossandwich.dto.promotion.PromotionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/promotion")
public class PromotionRoute {
  
    protected CreatePromotionController createPromotionController;
   protected GetPromotionController getPromotionController;

    public PromotionRoute(CreatePromotionController createPromotionController, GetPromotionController getPromotionController) {
        this.createPromotionController = createPromotionController;
        this.getPromotionController = getPromotionController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody PromotionDTO promotionDTO) {
        try {
            return createPromotionController.createPromotion(promotionDTO);
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
            return getPromotionController.listPromotion();
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity getPromotionByType(@PathVariable String type) {
        try{
            type = type.toUpperCase();
            return getPromotionController.getPromotionByType(type);
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}