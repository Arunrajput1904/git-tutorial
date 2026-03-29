package MICROSERVICES.LEARNING.Service;


import MICROSERVICES.LEARNING.Dto.RestaurantDto;
import MICROSERVICES.LEARNING.Dto.FoodItemDto;
import MICROSERVICES.LEARNING.Entity.FoodItem;
import MICROSERVICES.LEARNING.Repository.FoodRepo;
import MICROSERVICES.LEARNING.Service.ConfigService.RestaurantService;
import MICROSERVICES.LEARNING.Service.ConfigService.RestaurantWebclient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepo foodRepo;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    RestaurantService restaurantService;


    @Autowired
    RestaurantWebclient webclient;


    public List<FoodItemDto> findall() {
        List<FoodItem> list= foodRepo.findAll();

        List<FoodItemDto>foodItemDtoList=new ArrayList<>();

        list.forEach(foodItem->{ foodItemDtoList.add(modelMapper.map(foodItem,FoodItemDto.class)); });

        return foodItemDtoList;
    }


    public FoodItemDto findbyid(Long id) {

        FoodItemDto foodItemDto=modelMapper.map(foodRepo.findById(id).get(),FoodItemDto.class);



        RestaurantDto restaurantDto=restaurantService.getRestaurant(foodItemDto.restid);


        foodItemDto.setRestaurantDto(restaurantDto);



        return foodItemDto;
    }


    public FoodItemDto saveitem(FoodItemDto foodItemDto) {

        RestaurantDto restaurantDto=restaurantService.createRestaurant(foodItemDto.getRestaurantDto());

//        foodItemDto.setRestaurantDto(restaurantDto);
////        System.out.println(restaurantDto+"  "+foodItemDto);
//        foodItemDto.setRestid(restaurantDto.getId());
        FoodItem foodItem=modelMapper.map(foodItemDto,FoodItem.class);
        FoodItemDto foodItemDto1=modelMapper.map(foodRepo.save(foodItem),FoodItemDto.class);


        foodItemDto1.setRestaurantDto(restaurantDto);
        System.out.println(foodItemDto1);
        return foodItemDto1;
    }
}
