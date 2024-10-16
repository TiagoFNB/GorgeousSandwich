package com.gorgeous.ShopManagement;

import com.gorgeous.ShopManagement.controller.ChangeShopPropertiesController;
import com.gorgeous.ShopManagement.controller.CreateShopController;
import com.gorgeous.ShopManagement.controller.GetShopByIdController;
import com.gorgeous.ShopManagement.controller.GetShopController;
import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.dto.ShopDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class Router {

    protected CreateShopController createShopController;
    protected GetShopByIdController getShopByIdController;
    protected GetShopController getShopController;
    protected ChangeShopPropertiesController changeShopPropertiesController;

    public Router(CreateShopController createShopController, GetShopController getShopController, GetShopByIdController getShopByIdController, ChangeShopPropertiesController changeShopPropertiesController) {
        this.createShopController = createShopController;
        this.getShopController = getShopController;
        this.getShopByIdController = getShopByIdController;
        this.changeShopPropertiesController = changeShopPropertiesController;
    }

    @MutationMapping
    public Shop create(@Argument ShopDTO shopDTO) {
        return createShopController.createShop(shopDTO);
    }

    @QueryMapping
    public List<Shop> getList() {
        return getShopController.listShop();
    }

    @QueryMapping
    public Shop getShopById(@Argument String id) {
        return getShopByIdController.get(id);
    }

    @MutationMapping
    public Shop changeShopProperties(@Argument ShopDTO shopDTO) {
        return changeShopPropertiesController.changeShopProperties(shopDTO);
    }
}