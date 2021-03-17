package com.codecool.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableZuulProxy
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

	@Autowired
	ZuulProperties properties;

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			properties.getRoutes().values().stream()
					.forEach(zuulRoute -> resources
							.add(createResource(zuulRoute.getServiceId(), zuulRoute.getLocation(), "2.0")));
			return resources;
		};
	}

	private SwaggerResource createResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation("/" + location + "/v2/api-docs");
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
