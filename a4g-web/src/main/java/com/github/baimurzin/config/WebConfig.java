package com.github.baimurzin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by vlad on 16.10.15.
 */
@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan(basePackages = {"com.github.baimurzin.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver url = new InternalResourceViewResolver();
        url.setPrefix("/WEB-INF/");
        url.setSuffix(".html");
        return url;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    @Bean
    public String getBean(ObjectMapper mapper) {
        return "";
    }

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo());
    }

    /*
        write ur own api info here
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Api A4G",
                "API v0.0.1",
                "http://arena4game.ru/terms",
                "Baimurzin.719@gmail.com",
                "Please read the license terms...",
                "Arena4Game.ru"
        );

        return apiInfo;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//        registry.addResourceHandler(Constants.EXTERNAL_PATH + "/**").addResourceLocations("file:///" + env.getProperty("image.upload.path")).setCachePeriod(86400);

        /**
         * swagger UI resources
         */
        registry.addResourceHandler("/css/**").addResourceLocations("/public/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/public/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/public/js/")
                .addResourceLocations("/app/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/public/fonts/");
        registry.addResourceHandler("/lib/**").addResourceLocations("/public/lib/");
        registry.addResourceHandler("*.html").addResourceLocations("/");

        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations("/app/vendor/bootstrap/");
    }

}
