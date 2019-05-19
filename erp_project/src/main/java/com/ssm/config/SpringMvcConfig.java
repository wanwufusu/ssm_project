package com.ssm.config;

import com.ssm.bean.MyDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/15
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ssm.controller")
public class SpringMvcConfig extends WebMvcConfigurationSupport {
    /*@Autowired
    ConfigurableConversionService configurableConversionService;*/

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        registry.addResourceHandler("/css/*").addResourceLocations("/WEB-INF/css");
        registry.addResourceHandler("/js/*").addResourceLocations("/WEB-INF/js");
        registry.addResourceHandler("/image/*").addResourceLocations("/WEB-INF/image");
    }
   /* @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService(){
        return configurableConversionService();
    }
    @PostConstruct
    public void addConverterToService(){
        configurableConversionService().addConverter(new MyDateConverter());
    }*/


}
