package org.sid.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
public class CloudGatewayApplication {

    @Bean
    RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
            .route(r->r
                .path("/countries/**")
                .filters(f->f
                    .addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                    .addRequestHeader("x-rapidapi-key", "ad80afeac4msh51f711fc0af147dp1a2b93jsnc7074e60c436")
                    .rewritePath("/countries/(?<segment>.*)", "/${segment}")
                    .hystrix(h->h.setName("rest-countries")
                        .setFallbackUri("forward:/restCountriesFallBack"))
                )
                    .uri("https://restcountries-v1.p.rapidapi.com").id("countries")
            )

            .route(r->r.path("/restMuslimsalat/**")
                .filters(f->f
                    .addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                    .addRequestHeader("x-rapidapi-key", "ad80afeac4msh51f711fc0af147dp1a2b93jsnc7074e60c436")
                    .rewritePath("/restMuslimsalat/(?<segment>.*)", "/${segment}")
                    .hystrix(h->h.setName("rest-muslimsalat")
                            .setFallbackUri("forward:/muslimsalatFallBack"))
                )
                    .uri("https://restcountries-v1.p.rapidapi.com").id("countries")
            )

            .route(r->r.path("/costumers/**").uri("lb://COSTUMER-SERVICE").id("r1"))
            .route(r->r.path("/products/**").uri("lb://INVENTOR-SERVICE").id("r2"))
            .build();
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

}
