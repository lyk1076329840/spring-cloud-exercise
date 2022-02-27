package ncepu.lykkk.exercise.config;

import ncepu.lykkk.exercise.service.Swagger2Service;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: swagger2自动配置类
 * @author: 林玉坤
 * @create: 2022-02-22 17:01
 **/
@Configuration
@EnableConfigurationProperties(Swagger2Properties.class)
@EnableSwagger2
public class Swagger2AutoConfiguration {

    private Swagger2Properties swagger2Properties;

    public Swagger2AutoConfiguration(Swagger2Properties swagger2Properties){
        this.swagger2Properties = swagger2Properties;
    }

    @ConditionalOnMissingBean
    @Bean
    public Docket createRestAPi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.swagger2Properties.getBase_package()))
//                .apis(RequestHandlerSelectors.basePackage("ncepu.lykkk.exercise.controller"))
                .paths(PathSelectors.any())
                .build();
//                .securityContexts(securityContexts())
//                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(this.swagger2Properties.getTitle())
                .description(this.swagger2Properties.getDescription())
                .contact(new Contact(this.swagger2Properties.getName(),
                        this.swagger2Properties.getUrl(),
                        this.swagger2Properties.getEmail()))
                .version(this.swagger2Properties.getVersion())
                .build();
    }

}
