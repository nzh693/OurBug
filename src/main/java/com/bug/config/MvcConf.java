package com.bug.config;

import com.bug.convertor.LocalDateTimeConverter;
import com.bug.interceptor.MyLocaleResolver;
import com.bug.interceptor.UserInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
//@EnableAutoConfiguration
public class MvcConf implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.*").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.*").setViewName("login");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/sign", "/login", "user");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        System.out.println("---addFormatters------");
        registry.addConverter(new LocalDateTimeConverter());
    }



    @Bean
    public LocaleResolver localeResolver() {
        System.out.println("localeResolver---------------");
        return new MyLocaleResolver();
    }

}
