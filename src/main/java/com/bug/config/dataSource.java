package com.bug.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源监控
 */
@Configuration
public class dataSource {

     @ConfigurationProperties(prefix = "spring.datasource")
     @Bean
     public DataSource druid(){
         return new DruidDataSource();
     }


    //注册管理数据源的servlet
    @Bean
     public ServletRegistrationBean getStatViewServlet(){
         ServletRegistrationBean registrationBean=new ServletRegistrationBean();
         registrationBean.setServlet(new StatViewServlet());
         registrationBean.setUrlMappings(Arrays.asList("/druid/*"));//设置访问路径
         Map<String,String> initiParameters=new HashMap<>();
         initiParameters.put("loginUsername","admin");//设置登录账户
         initiParameters.put("loginPassword","123456");
         initiParameters.put("allow","");//为空默认允许所有
//       initiParameters.put("deny","");//拒绝所有
         registrationBean.setInitParameters(initiParameters);
         return registrationBean;
     }


    //注册一个web监控的过滤器
    @Bean
    public FilterRegistrationBean getStatViewFilter(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        Map<String,String> initiParameters=new HashMap<>();
        initiParameters.put("exclusions","*.js,*.css,/druid/*");//设置不拦截路径
        registrationBean.setInitParameters(initiParameters);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));//拦截所有请求
        return registrationBean;
    }
}
