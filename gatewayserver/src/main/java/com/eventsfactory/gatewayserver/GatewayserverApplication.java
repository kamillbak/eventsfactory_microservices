package com.eventsfactory.gatewayserver;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;


@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public HttpClient httpClient() {
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}

	@Bean
	public RouteLocator eventsFactoryRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/events/**")
						.filters(f -> f.rewritePath("/events/(?<segment>.*)", "/${segment}")
								.circuitBreaker(config -> config.setName("eventsCircuitBreaker")
								.setFallbackUri("forward:/contactSupport")))
						.uri("lb://EVENTS"))
				.route(p -> p
						.path("/locations/**")
						.filters(f -> f.rewritePath("/locations/(?<segment>.*)", "/${segment}"))
						.uri("lb://LOCATIONS"))
				.route(p -> p
						.path("/custom/users/**")
						.filters(f -> f.rewritePath("/custom/users/(?<segment>.*)", "/${segment}"))
						.uri("lb://USERS"))
				.build();
	}

}
