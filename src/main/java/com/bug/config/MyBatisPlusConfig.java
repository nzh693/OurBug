package com.bug.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Description MyBatisPlus配置
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@Configuration
@MapperScan("com.bug.mapper")
public class MyBatisPlusConfig {
    
    /**
     * 分页配置
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
