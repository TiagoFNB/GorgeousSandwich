package gourgeossandwich.service.sandwich;

import gourgeossandwich.domain.sandwich.*;
import gourgeossandwich.dto.sandwich.SandwichDTO;
import gourgeossandwich.repository.sandwich.SandwichRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateSandwichService {

    protected SandwichRepository sandwichRepository;

    public CreateSandwichService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public Sandwich createNewSandwich(SandwichDTO sandwichDTO) throws Exception {
        final SandwichInternalId id = SandwichInternalId.genNewId();
        final SandwichDesignation design = new SandwichDesignation(sandwichDTO.getSandwichDesignation());
        final SellingPrice price = new SellingPrice(sandwichDTO.getSellingPrice());
        final List<Description> descriptions = createDescriptions(sandwichDTO.getDescriptionList());

        final Sandwich sandwich = new Sandwich(id,design,price,descriptions);

        this.sandwichRepository.save(sandwich);

        return sandwich;
    }

    private List<Description> createDescriptions(List<String> descriptions) throws Exception {
        List<Description> newList = new ArrayList<Description>();
        for( String desc : descriptions) {
            newList.add(new Description(desc));
        }
        return newList;
    }
}
