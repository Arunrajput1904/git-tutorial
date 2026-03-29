package MICROSERVICES.LEARNING.Service.ConfigService;


import MICROSERVICES.LEARNING.Dto.RestaurantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@FeignClient(name = "restaurant-services")
public interface RestaurantService {




    @GetMapping("/rest/{id}")
    public RestaurantDto getRestaurant(@PathVariable Long id);

    @PostMapping("/rest")
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurantDto);


}
