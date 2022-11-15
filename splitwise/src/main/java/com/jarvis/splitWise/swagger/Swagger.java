package com.jarvis.splitWise.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Api Swagger").apiInfo(getInfo()).select().paths(regex("/.*")).build();
	}
	
	

	public ApiInfo getInfo() {
		return new ApiInfoBuilder().title("SplitWise WebApp").description("Splitwise webApp ").build();
	}

}
