package com.dio.guilherme.pontoeacesso.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    
@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())//basePackage("com.dio.guilherme.pontoeacesso"))
        .paths(PathSelectors.any())
        .build()
        //.apiInfo(apiInfo())
        ;
}
/*
@Bean
public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Controle de Ponto e Acesso REST API")
            .description("API Rest para controle de ponto e acesso utilizando Spring-boot, H2 e Swagger")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .contact(new Contact("Guilherme Silva", "https://github.com/guilherme0541", "guilherme0541@gmail.com"))
            .build();
}*/

}