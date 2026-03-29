package restaurantservice.restaurant.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restaurantservice.restaurant.Dto.RestaurantDto;
import restaurantservice.restaurant.Service.RestaurantService;

@RestController
@RequestMapping("/rest")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto dto) {
        System.out.println("2+.........................");
        return ResponseEntity.ok(service.saveRestaurant(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRestaurantById(id));
    }
}