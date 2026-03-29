package restaurantservice.restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantservice.restaurant.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}