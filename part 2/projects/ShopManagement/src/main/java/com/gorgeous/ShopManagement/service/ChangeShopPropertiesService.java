package com.gorgeous.ShopManagement.service;

import com.gorgeous.ShopManagement.ShopRepository;
import com.gorgeous.ShopManagement.domain.*;
import com.gorgeous.ShopManagement.dto.ShopDTO;
import com.gorgeous.ShopManagement.dto.ShopPropertiesDTO;
import org.springframework.stereotype.Service;

@Service
public class ChangeShopPropertiesService {

    protected ShopRepository shopRepository;

    public ChangeShopPropertiesService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop changeShopProperties(ShopDTO shopDTO) {
        Shop toChange = this.shopRepository.getShopByAddress(new ShopAddress(shopDTO.getShopAddress()));

        final ShopProperties shopProperties = createShopProperties(shopDTO.getShopProperties());

        toChange.setShopProperties(shopProperties);

        return this.shopRepository.save(toChange);
    }

    private ShopProperties createShopProperties(ShopPropertiesDTO shopPropertiesDTO) {
        MaximumNumberDeliveries maximumNumberDeliveries = new MaximumNumberDeliveries(shopPropertiesDTO.getMaximumNumberDeliveries());
        MinimumAcceptableAdvance minimumAcceptableAdvance = new MinimumAcceptableAdvance(shopPropertiesDTO.getMinimumAcceptableAdvance());
        Period period = new Period(shopPropertiesDTO.getPeriod());

        return new ShopProperties(minimumAcceptableAdvance, maximumNumberDeliveries, period);
    }
}
