package MICROSERVICES.LEARNING.Repository;

import MICROSERVICES.LEARNING.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface FoodRepo extends JpaRepository<FoodItem,Long> {
}
