package com.cg.aps;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ApartmentSecurityManagementMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentSecurityManagementMainApplication.class, args);
	}
	@Bean
	public Docket docket() {
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization") // name of header
				.modelRef(new ModelRef("string")).parameterType("header") // type - header
				.defaultValue("Bearer em9uZTpteXBhc3N3b3Jk") // based64 of - zone:mypassword
				.required(true) // for compulsory
				.build();
		java.util.List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build()); // add parameter
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("").globalOperationParameters(aParameters);
	}

}
