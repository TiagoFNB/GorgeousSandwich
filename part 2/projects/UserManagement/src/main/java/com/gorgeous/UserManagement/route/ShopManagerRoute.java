package com.gorgeous.UserManagement.route;

import com.gorgeous.UserManagement.controller.CreateShopManagerController;
import com.gorgeous.UserManagement.controller.GetShopManagerByIdController;
import com.gorgeous.UserManagement.controller.GetShopManagersController;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.dto.ShopManagerDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopmanager")
public class ShopManagerRoute {

    protected GetShopManagersController getShopManagersController;
    protected GetShopManagerByIdController getShopManagerByIdController;
    protected CreateShopManagerController createShopManagerController;

    public ShopManagerRoute(CreateShopManagerController createShopManagerController,
                            GetShopManagersController getShopManagersController,
                            GetShopManagerByIdController getShopManagerByIdController) {
        this.createShopManagerController = createShopManagerController;
        this.getShopManagersController = getShopManagersController;
        this.getShopManagerByIdController = getShopManagerByIdController;
    }

    @MutationMapping
    public ShopManager createShopManager(@Argument ShopManagerDTO shopManager) throws Exception {
        return createShopManagerController.createShopManager(shopManager);
    }

    @QueryMapping
    public List<ShopManager> getShopManagers() {
        return getShopManagersController.listShopManagers();
    }
    @QueryMapping
    public ShopManager getShopManagerById(@Argument String id) {
        return getShopManagerByIdController.getShopManagerById(id);
    }

}
