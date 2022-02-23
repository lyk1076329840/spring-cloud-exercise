package ncepu.lykkk.exercise.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
 * @description: swagger2配置类
 * @author: 林玉坤
 * @create: 2022-02-22 17:43
 **/
//@Configuration
//@EnableSwagger2
public class Swagger2Config {

//    @Bean
//    public Docket createRestAPi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(this.swagger2Properties.getBase_package()))
////                .apis(RequestHandlerSelectors.basePackage("ncepu.lykkk.exercise.controller"))
//                .paths(PathSelectors.any())
//                .build();
////                .securityContexts(securityContexts())
////                .securitySchemes(securitySchemes());
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title(this.swagger2Properties.getTitle())
//                .description(this.swagger2Properties.getDescription())
//                .contact(new Contact(this.swagger2Properties.getName(),
//                        this.swagger2Properties.getUrl(),
//                        this.swagger2Properties.getEmail()))
//                .version(this.swagger2Properties.getVersion())
//                .build();
//    }

//    @Bean
    public Docket createRestAPi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.lykkk.controller"))
                .paths(PathSelectors.any())
                .build();
//                .securityContexts(securityContexts())
//                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("选择题接口文档")
                .description("选择题接口文档")
                .contact(new Contact("林玉坤","http:localhost:9000/doc.html","1076329840@qq.com"))
                .version("0.1")
                .build();
    }

    private List<ApiKey> securitySchemes(){
        //设置请求头信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization","Authorization","Header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts(){
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/hello/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope [] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }

}
