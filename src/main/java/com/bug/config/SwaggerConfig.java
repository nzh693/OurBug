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
	// API接口包扫描的路径
	public static final String SWAGGER2_SCAN_PACKAGE = "com.bug.controller";
	// API文档的版本
	public static final String VERSION = "1.0.0";
	  @Bean
	  public Docket createRestApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage(SWAGGER2_SCAN_PACKAGE)) //指定controller根包
	            .paths(PathSelectors.any())
	            .build();
	  }

	  private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("CRM管理系统 - API文档")  //标题
	            .description("文档描述 - CRM服务接口定义")  //描述
	            .contact(new Contact("liewona","http://www.liewona.com","service@mail.liewona")) //联系信息
	            .version(VERSION) //版本号
	            .build();
	  }
}