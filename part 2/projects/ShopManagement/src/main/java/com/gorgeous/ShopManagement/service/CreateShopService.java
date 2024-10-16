package com.gorgeous.ShopManagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gorgeous.ShopManagement.ShopRepository;
import com.gorgeous.ShopManagement.domain.*;
import com.gorgeous.ShopManagement.dto.DailyScheduleDTO;
import com.gorgeous.ShopManagement.dto.ShopDTO;
import com.gorgeous.ShopManagement.dto.ShopPropertiesDTO;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateShopService {

    private static final String sandwichURL = "http://gateway:9000/sandwich";
    private static final String userURL = "http://gateway:9000/user";

    protected ShopRepository shopRepository;

    public CreateShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop createNewShop(ShopDTO shopDTO) {
        final ShopInternalId id = ShopInternalId.genNewId();
        final ShopDesignation shopDesignation = new ShopDesignation(shopDTO.getShopDesignation());
        final ShopAddress shopAddress = new ShopAddress(shopDTO.getShopAddress());
        final List<DailySchedule> dailySchedules = createWeeklySchedule(shopDTO.getDailySchedule());
        final UserInternalId shopManager = verifyShopManager(shopDTO.getShopManagerId());
        final List<SandwichInternalId> sandwichList = createSandwichList(shopDTO.getSandwichIdList());
        final ShopProperties shopProperties = createShopProperties(shopDTO.getShopProperties());

        final Shop shop = new Shop(id, shopDesignation, shopAddress, dailySchedules, shopManager, sandwichList, shopProperties);

        this.shopRepository.save(shop);

        return shop;
    }

    private ShopProperties createShopProperties(ShopPropertiesDTO shopPropertiesDTO) {
        MaximumNumberDeliveries maximumNumberDeliveries = new MaximumNumberDeliveries(shopPropertiesDTO.getMaximumNumberDeliveries());
        MinimumAcceptableAdvance minimumAcceptableAdvance = new MinimumAcceptableAdvance(shopPropertiesDTO.getMinimumAcceptableAdvance());
        Period period = new Period(shopPropertiesDTO.getPeriod());

        return new ShopProperties(minimumAcceptableAdvance, maximumNumberDeliveries, period);
    }

    private UserInternalId verifyShopManager(String shopManagerId) {
        ObjectMapper objectMapper = new ObjectMapper();

        WebClient webClient = WebClient.builder().baseUrl(userURL)//url of graphql instance
                .build();

        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("id", shopManagerId);

        Object obj = graphqlClient.post("getShopManagerById.graphql", stringObjectMap, Object.class).block();

        if (obj != null) {
            return new UserInternalId(shopManagerId);
        } else {
            return null;
        }
    }

    private List<SandwichInternalId> createSandwichList(List<String> sandwichIdList) {
        List<SandwichInternalId> newList = new ArrayList<>();
        for (String id : sandwichIdList) {
            ObjectMapper objectMapper = new ObjectMapper();

            WebClient webClient = WebClient.builder().baseUrl(sandwichURL)//url of graphql instance
                    .build();

            GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("id", id);

            Object obj = graphqlClient.post("getSandwichById.graphql", stringObjectMap, Object.class).block();

            if (obj != null) {
                newList.add(new SandwichInternalId(id));
            }
        }
        return newList;
    }

    private List<DailySchedule> createWeeklySchedule(List<DailyScheduleDTO> dailyScheduleDTOList) {
        List<DailySchedule> newList = new ArrayList<>();
        for (DailyScheduleDTO dto : dailyScheduleDTOList) {
            OpeningHours openingHours = new OpeningHours(dto.getOpeningHours());
            ClosingHours closingHours = new ClosingHours(dto.getClosingHours());
            Day day = getDayFromDTO(dto.getDay());
            newList.add(new DailySchedule(openingHours, closingHours, day));
        }
        return newList;
    }

    private Day getDayFromDTO(String day) {
        switch (day.toLowerCase()) {
            case "monday":
                return Day.MONDAY;
            case "tuesday":
                return Day.TUESDAY;
            case "wednesday":
                return Day.WEDNESDAY;
            case "thursday":
                return Day.THURSDAY;
            case "friday":
                return Day.FRIDAY;
            case "saturday":
                return Day.SATURDAY;
            case "sunday":
                return Day.SUNDAY;
            default:
                throw new IllegalArgumentException("Day must be monday, tuesday, wednesday, thursday, friday, saturday or sunday");
        }
    }
}
