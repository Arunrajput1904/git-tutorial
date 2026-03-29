package restaurantservice.restaurant.Service;


import org.springframework.stereotype.Service;
import restaurantservice.restaurant.Dto.RestaurantDto;
import restaurantservice.restaurant.Entity.Restaurant;
import restaurantservice.restaurant.Repository.RestaurantRepository;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    // SAVE
    public RestaurantDto saveRestaurant(RestaurantDto dto) {
        Restaurant restaurant = mapToEntity(dto);
        Restaurant saved = repository.save(restaurant);
        return mapToDto(saved);
    }

    // GET ONE
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));

        return mapToDto(restaurant);
    }

    // 🔁 MAPPING METHODS
    private Restaurant mapToEntity(RestaurantDto dto) {
        return new Restaurant(
                dto.getId(),
                dto.getName(),
                dto.getDescription()
        );
    }

    private RestaurantDto mapToDto(Restaurant entity) {
        return new RestaurantDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}