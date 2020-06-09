package com.bug.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	  @Bean
	  public Docket createRestApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.bug.controller")) //指定controller根包
	            .paths(PathSelectors.any())
	            .build();
	  }

	  private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("CRM管理系统")  //标题
	            .description("xxxxxxxxxxx")  //描述
	            .contact(new Contact("liewona","http://www.liewona.com","service@mail.liewona")) //联系信息
	            .version("1.0") //版本号
	            .build();
	  }
}