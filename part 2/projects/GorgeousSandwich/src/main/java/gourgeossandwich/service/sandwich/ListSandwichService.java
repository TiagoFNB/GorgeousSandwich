package gourgeossandwich.service.sandwich;

import gourgeossandwich.domain.sandwich.*;
import gourgeossandwich.repository.sandwich.SandwichRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSandwichService {

    protected SandwichRepository sandwichRepository;

    public ListSandwichService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public List<Sandwich> getAllSandwiches() {
        return this.sandwichRepository.findAll();
    }
}
