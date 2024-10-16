package gourgeossandwich.service.shop;

import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.domain.sandwich.SandwichInternalId;
import gourgeossandwich.domain.shop.*;
import gourgeossandwich.domain.user.shopmanager.ShopManager;
import gourgeossandwich.dto.shop.DailyScheduleDTO;
import gourgeossandwich.dto.shop.ShopDTO;
import gourgeossandwich.repository.sandwich.SandwichRepository;
import gourgeossandwich.repository.shop.ShopRepository;
import gourgeossandwich.repository.user.ShopManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateShopService {

    protected ShopRepository shopRepository;
    protected ShopManagerRepository shopManagerRepository;
    protected SandwichRepository sandwichRepository;

    public CreateShopService(ShopRepository shopRepository, ShopManagerRepository shopManagerRepository, SandwichRepository sandwichRepository) {
        this.shopRepository = shopRepository;
        this.shopManagerRepository = shopManagerRepository;
        this.sandwichRepository = sandwichRepository;
    }

    public Shop createNewShop(ShopDTO shopDTO) {
        final ShopInternalId id = ShopInternalId.genNewId();
        final ShopDesignation shopDesignation = new ShopDesignation(shopDTO.getShopDesignation());
        final ShopAddress shopAddress = new ShopAddress(shopDTO.getShopAddress());
        final List<DailySchedule> dailySchedules = createWeeklySchedule(shopDTO.getDailySchedule());
        final ShopManager shopManager = shopManagerRepository.findByEmail(shopDTO.getShopManagerEmail());
        final List<Sandwich> sandwichList = createSandwichList(shopDTO.getSandwichIdList());

        final Shop shop = new Shop(id,shopDesignation,shopAddress, dailySchedules, shopManager, sandwichList);

        this.shopRepository.save(shop);

        return shop;
    }

    private List<Sandwich> createSandwichList(List<String> sandwichIdList) {
        List<Sandwich> newList = new ArrayList<>();
        for (String id : sandwichIdList) {
            newList.add(this.sandwichRepository.getSandwichById(new SandwichInternalId(id)));
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
