package MICROSERVICES.LEARNING.Service.ConfigService;


import MICROSERVICES.LEARNING.Dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantWebclient {
    private final WebClient.Builder webClientBuilder;

    public RestaurantDto getRestaurantDto(Long id){
        return webClientBuilder.build()
                .get()
                .uri("http://restaurant-services/rest/{id}",id)
                .retrieve()
                .bodyToMono(RestaurantDto.class)
                .block();
    }

    public Mono<RestaurantDto> CreateRestaurantDto(RestaurantDto restaurantDto){
        Mono<RestaurantDto>res= webClientBuilder.build()
                .post()
                .uri("http://restaurant-services/rest")
                .bodyValue(restaurantDto)
                .retrieve()
                .bodyToMono(RestaurantDto.class);

        return res.map(user->{
            return user;
        });
    }





}
