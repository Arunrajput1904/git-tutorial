package MICROSERVICES.LEARNING.Controller;


import MICROSERVICES.LEARNING.Dto.FoodItemDto;
import MICROSERVICES.LEARNING.Entity.FoodItem;
import MICROSERVICES.LEARNING.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;


    @GetMapping
    public List<FoodItemDto> findAll(){
        List<FoodItemDto> list=foodService.findall();
        System.out.println("Find food all");
        System.out.println(list);
        return list;
    }

    @GetMapping("/{id}")
    public FoodItemDto findById(@PathVariable Long id){
        System.out.println("Find food by id"+ id);
        return foodService.findbyid(id);
    }

    @PostMapping
    public FoodItemDto save(@RequestBody FoodItemDto foodItemDto){
        return foodService.saveitem(foodItemDto);
    }
}
