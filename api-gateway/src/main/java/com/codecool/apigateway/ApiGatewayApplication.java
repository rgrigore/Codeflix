package com.codecool.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

//	@Autowired
//	GatewayProperties properties;

	@Autowired
	RouteLocator routeLocator;

//	@Bean
//	public JsonSerializer jsonSerializer(List<JacksonModuleRegistrar> moduleRegistrars) {
//		return new JsonSerializer(moduleRegistrars);
//	}

//	@Primary
//	@Bean
//	@Lazy
//	public SwaggerResourcesProvider swaggerResourcesProvider() {
//		return () -> {
//			List<SwaggerResource> resources = new ArrayList<>();
//			properties.getRoutes().stream()
//					.map(route -> resources
//							.add(createResource(route.getId(), getRouteLocation(route), "2.0")));
//			return resources;
//		};
//	}

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			routeLocator.getRoutes()
					.map(route -> resources
							.add(createResource(route.getId(), route.getUri().toString(), "2.0")));
			return resources;
		};
	}
//
//	private String getRouteLocation(RouteDefinition route) {
//		return Optional.ofNullable(route.getPredicates().get(0).getArgs().values().toArray()[0])
//				.map(String::valueOf)
//				.map(s -> s.replace("*", ""))
//				.orElse(null);
//	}

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
