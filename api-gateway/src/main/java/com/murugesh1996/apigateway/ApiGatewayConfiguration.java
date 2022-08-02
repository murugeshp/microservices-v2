package com.murugesh1996.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        Function<PredicateSpec, Buildable<Route>> routeFuntion
                = p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader","MyURI")
                                .addRequestParameter("Param","MyValue"))
                        .uri("http://httpbin.org:80");

        return builder.routes()
                .route(routeFuntion)
                .route(p -> p.path("/checkout-purchase-service/**").uri("lb://checkout-purchase-service"))
                .route(p -> p.path("/product-category-service/**").uri("lb://product-category-service"))
                .build();
    }
}
