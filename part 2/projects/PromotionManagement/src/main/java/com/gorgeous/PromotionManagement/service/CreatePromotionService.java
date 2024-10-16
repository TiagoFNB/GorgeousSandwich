package com.gorgeous.PromotionManagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gorgeous.PromotionManagement.domain.*;
import com.gorgeous.PromotionManagement.dto.PromotionDTO;
import com.gorgeous.PromotionManagement.dto.PromotionPeriodDTO;
import com.gorgeous.PromotionManagement.PromotionRepository;

import java.util.HashMap;
import java.util.Map;


@Service
public class CreatePromotionService {

    private static final String sandwichURL = "http://gateway:9000/sandwich";
    protected PromotionRepository promotionRepository;

    public CreatePromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion createNewPromotion(PromotionDTO promotionDTO) {
        final PromotionInternalId id = PromotionInternalId.genNewId();
        final PromotionPercentage percentage = new PromotionPercentage(promotionDTO.getPromotionPercentage());
        final PromotionPeriod period = createPromotionPeriod(promotionDTO.getPromotionPeriod());
        final PromotionType type = getTypeFromDTO(promotionDTO.getPromotionType());
        final SandwichInternalId sandwichInternalId = verifySandwich(promotionDTO.getSandwichInternalId());


        final Promotion promotion = new Promotion(id, percentage, period, type, sandwichInternalId);

        this.promotionRepository.save(promotion);

        return promotion;
    }

    private PromotionType getTypeFromDTO(String type) {
        switch (type.toLowerCase()) {
            case "local":
                return PromotionType.LOCAL;
            case "global":
                return PromotionType.GLOBAL;
            default:
                throw new IllegalArgumentException("Promotion Type must be local or global");
        }
    }

    private PromotionPeriod createPromotionPeriod(PromotionPeriodDTO promotionPeriodDTO) {
        PromotionPeriodBeginning promotionPeriodBeginning = new PromotionPeriodBeginning(promotionPeriodDTO.getPromotionPeriodBeginning());
        PromotionPeriodEnd promotionPeriodEnd = new PromotionPeriodEnd(promotionPeriodDTO.getPromotionPeriodEnd());

        return new PromotionPeriod(promotionPeriodBeginning, promotionPeriodEnd);
    }

    private SandwichInternalId verifySandwich(String sandwichId) {

        ObjectMapper objectMapper = new ObjectMapper();

        WebClient webClient = WebClient.builder().baseUrl(sandwichURL)//url of graphql instance
                .build();

        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("id", sandwichId);

        Object obj = graphqlClient.post("getSandwichById.graphql", stringObjectMap, Object.class).block();

        if (obj != null) {
            return new SandwichInternalId(sandwichId);
        } else {
            return null;
        }
    }

}
