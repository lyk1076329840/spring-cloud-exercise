package ncepu.lykkk.exercise.config;

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

/**
 * @program: spring-cloud-exercise
 * @description: swagger2配置类
 * @author: 林玉坤
 * @create: 2022-02-22 23:12
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestAPi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ncepu.lykkk.exercise.controller"))
                .paths(PathSelectors.any())
                .build();
//                .securityContexts(securityContexts())
//                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("选择题接口文档")
                .description("选择题接口文档")
                .contact(new Contact("林玉坤","http:localhost:8080/doc.html","1076329840@qq.com"))
                .version("0.1")
                .build();
    }

}
