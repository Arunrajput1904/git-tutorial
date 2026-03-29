package MICROSERVICES.LEARNING.Dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FoodItemDto {


    private Long id;
    private String name;
    private String description;
    private double price;
    public Long restid;
    public RestaurantDto restaurantDto;
}
