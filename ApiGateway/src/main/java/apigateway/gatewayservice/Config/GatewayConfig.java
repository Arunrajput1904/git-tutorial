package apigateway.gatewayservice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@Configuration
public class GatewayConfig {




    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("food-services",
                        route->route.path("/foodservices/**")
                                .filters(it->it.rewritePath("/foodservices/?(?<remaining>.*)","/${remaining}"))
                                .uri("lb://food-services")
                )
                .build();

    };


}
