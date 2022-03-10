//package ncepu.lykkk.exercise.swagger2;
//
//import com.google.common.base.Predicate;
//import com.google.common.base.Predicates;
//import com.google.common.collect.Lists;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Import;
//import springfox.documentation.builders.*;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import javax.annotation.Resource;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @program: spring-cloud-exercise
// * @description: swagger2自动配置类
// * @author: 林玉坤
// * @create: 2022-02-26 11:04
// **/
//@Import({
//        Swagger2Configuration.class
//})
//@EnableConfigurationProperties(Swagger2Properties.class)
//public class Swagger2AutoConfiguration implements BeanFactoryAware {
//    private static final String AUTH_KEY = "token";
//    @Resource
//    Swagger2Properties swagger2Properties;
//
//    private BeanFactory beanFactory;
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(name = "lyk.swagger2.enabled", havingValue = "true", matchIfMissing = true)
//    public List<Docket> createRestApi() {
//        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
//        List<Docket> docketList = new LinkedList<>();
//
//        // 没有分组
//        if (swagger2Properties.getDocket().isEmpty()) {
//            Docket docket = createDocket(swagger2Properties);
//            configurableBeanFactory.registerSingleton(swagger2Properties.getTitle(), docket);
//            docketList.add(docket);
//            return docketList;
//        }
//
//        // 分组创建
//        for (String groupName : swagger2Properties.getDocket().keySet()) {
//            Swagger2Properties.DocketInfo docketInfo = swagger2Properties.getDocket().get(groupName);
//
//            ApiInfo apiInfo = new ApiInfoBuilder()
//                    .title(docketInfo.getTitle().isEmpty() ? swagger2Properties.getTitle() : docketInfo.getTitle())
//                    .description(docketInfo.getDescription().isEmpty() ? swagger2Properties.getDescription() : docketInfo.getDescription())
//                    .version(docketInfo.getVersion().isEmpty() ? swagger2Properties.getVersion() : docketInfo.getVersion())
////                    .license(docketInfo.getLicense().isEmpty() ? swagger2Properties.getLicense() : docketInfo.getLicense())
////                    .licenseUrl(docketInfo.getLicenseUrl().isEmpty() ? swagger2Properties.getLicenseUrl() : docketInfo.getLicenseUrl())
//                    .contact(
//                            new Contact(
//                                    docketInfo.getContact().getName().isEmpty() ? swagger2Properties.getContact().getName() : docketInfo.getContact().getName(),
//                                    docketInfo.getContact().getUrl().isEmpty() ? swagger2Properties.getContact().getUrl() : docketInfo.getContact().getUrl(),
//                                    docketInfo.getContact().getEmail().isEmpty() ? swagger2Properties.getContact().getEmail() : docketInfo.getContact().getEmail()
//                            )
//                    )
////                    .termsOfServiceUrl(docketInfo.getTermsOfServiceUrl().isEmpty() ? swagger2Properties.getTermsOfServiceUrl() : docketInfo.getTermsOfServiceUrl())
//                    .build();
//
//            // base-path处理
//            // 当没有配置任何path的时候，解析/**
//            if (docketInfo.getBasePath().isEmpty()) {
//                docketInfo.getBasePath().add("/**");
//            }
//            List<Predicate<String>> basePath = new ArrayList<>(docketInfo.getBasePath().size());
//            for (String path : docketInfo.getBasePath()) {
//                basePath.add(PathSelectors.ant(path));
//            }
//
//            // exclude-path处理
//            List<Predicate<String>> excludePath = new ArrayList<>(docketInfo.getExcludePath().size());
//            for (String path : docketInfo.getExcludePath()) {
//                excludePath.add(PathSelectors.ant(path));
//            }
////            List<Parameter> parameters = assemblyGlobalOperationParameters(swagger2Properties.getGlobalOperationParameters(),
////                    docketInfo.getGlobalOperationParameters());
//            Docket docket = new Docket(DocumentationType.SWAGGER_2)
////                    .host(swagger2Properties.getHost())
//                    .apiInfo(apiInfo)
////                    .globalOperationParameters(parameters)
//                    .groupName(docketInfo.getGroup())
//                    .select()
//                    .apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
//                    .paths(
//                            Predicates.and(
//                                    Predicates.not(Predicates.or(excludePath)),
//                                    Predicates.or(basePath)
//                            )
//                    )
//                    .build()
////                    .securitySchemes(securitySchemes())
////                    .securityContexts(securityContexts())
////                    .globalResponseMessage(RequestMethod.GET, getResponseMessages())
////                    .globalResponseMessage(RequestMethod.POST, getResponseMessages())
////                    .globalResponseMessage(RequestMethod.PUT, getResponseMessages())
////                    .globalResponseMessage(RequestMethod.DELETE, getResponseMessages())
//                    ;
////                    .extensions(Lists.newArrayList(new OrderExtensions(swagger2Properties.getOrder())));
//
//            configurableBeanFactory.registerSingleton(groupName, docket);
//            docketList.add(docket);
//        }
//        return docketList;
//    }
//
//    /**
//     * 创建 Docket对象
//     *
//     * @param swagger2Properties swagger配置
//     * @return Docket
//     */
//    private Docket createDocket(Swagger2Properties swagger2Properties) {
//        //API 基础信息
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title(swagger2Properties.getTitle())
//                .description(swagger2Properties.getDescription())
//                .version(swagger2Properties.getVersion())
////                .license(swagger2Properties.getLicense())
////                .licenseUrl(swagger2Properties.getLicenseUrl())
//                .contact(new Contact(swagger2Properties.getContact().getName(),
//                        swagger2Properties.getContact().getUrl(),
//                        swagger2Properties.getContact().getEmail()))
////                .termsOfServiceUrl(swagger2Properties.getTermsOfServiceUrl())
//                .build();
//
//        // base-path处理
//        // 当没有配置任何path的时候，解析/**
//        if (swagger2Properties.getBasePath().isEmpty()) {
//            swagger2Properties.getBasePath().add("/**");
//        }
//        List<Predicate<String>> basePath = new ArrayList<>();
//        for (String path : swagger2Properties.getBasePath()) {
//            basePath.add(PathSelectors.ant(path));
//        }
//
//        // exclude-path处理
//        List<Predicate<String>> excludePath = new ArrayList<>();
//        for (String path : swagger2Properties.getExcludePath()) {
//            excludePath.add(PathSelectors.ant(path));
//        }
//
//        return new Docket(DocumentationType.SWAGGER_2)
////                .host(swagger2Properties.getHost())
//                .apiInfo(apiInfo)
//                .groupName(swagger2Properties.getGroup())
////                .globalOperationParameters(
////                        buildGlobalOperationParametersFromSwagger2Properties(
////                                swagger2Properties.getGlobalOperationParameters()))
//                .select()
//
//                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
//                .paths(
//                        Predicates.and(
//                                Predicates.not(Predicates.or(excludePath)),
//                                Predicates.or(basePath)
//                        )
//                )
//                .build()
////                .securitySchemes(securitySchemes())
////                .securityContexts(securityContexts())
////                .globalResponseMessage(RequestMethod.GET, getResponseMessages())
////                .globalResponseMessage(RequestMethod.POST, getResponseMessages())
////                .globalResponseMessage(RequestMethod.PUT, getResponseMessages())
////                .globalResponseMessage(RequestMethod.DELETE, getResponseMessages())
////                .extensions(Lists.newArrayList(new OrderExtensions(swagger2Properties.getOrder())))
//                ;
//    }
//
////    private List<ResponseMessage> getResponseMessages() {
////        List<ResponseMessage> collect = Arrays.asList(
////                new ResponseMessageBuilder().code(0).message("成功").build(),
////                new ResponseMessageBuilder().code(-1).message("系统繁忙").build(),
////                new ResponseMessageBuilder().code(-2).message("服务超时").build(),
////                new ResponseMessageBuilder().code(40001).message("会话超时，请重新登录").build(),
////                new ResponseMessageBuilder().code(40003).message("缺少token参数").build()
////        );
////        return collect;
////    }
////
////    private List<SecurityContext> securityContexts() {
////        List<SecurityContext> contexts = new ArrayList<>(1);
////        SecurityContext securityContext = SecurityContext.builder()
////                .securityReferences(defaultAuth())
////                //.forPaths(PathSelectors.regex("^(?!auth).*$"))
////                .build();
////        contexts.add(securityContext);
////        return contexts;
////    }
////
////    private List<SecurityReference> defaultAuth() {
////        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
////        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
////        authorizationScopes[0] = authorizationScope;
////        List<SecurityReference> references = new ArrayList<>(1);
////        references.add(new SecurityReference(AUTH_KEY, authorizationScopes));
////        return references;
////    }
////
////    private List<ApiKey> securitySchemes() {
////        List<ApiKey> apiKeys = new ArrayList<>(1);
////        ApiKey apiKey = new ApiKey(AUTH_KEY, AUTH_KEY, "header");
////        apiKeys.add(apiKey);
////        return apiKeys;
////    }
//
////    private List<Parameter> buildGlobalOperationParametersFromSwagger2Properties(
////            List<Swagger2Properties.GlobalOperationParameter> globalOperationParameters) {
////        List<Parameter> parameters = Lists.newArrayList();
////
////        if (Objects.isNull(globalOperationParameters)) {
////            /*parameters.add(new ParameterBuilder()
////                    .name(AUTH_KEY)
////                    .description("token令牌")
////                    .modelRef(new ModelRef("string"))
////                    .parameterType("header")
////                    .defaultValue("test")
////                    .required(false)
////                    .order(1)
////                    .build());*/
////            return parameters;
////        }
////        for (Swagger2Properties.GlobalOperationParameter globalOperationParameter : globalOperationParameters) {
////            parameters.add(new ParameterBuilder()
////                    .name(globalOperationParameter.getName())
////                    .description(globalOperationParameter.getDescription())
////                    .modelRef(new ModelRef(globalOperationParameter.getModelRef()))
////                    .parameterType(globalOperationParameter.getParameterType())
////                    .required(globalOperationParameter.getRequired())
////                    .defaultValue(globalOperationParameter.getDefaultValue())
////                    .allowEmptyValue(globalOperationParameter.getAllowEmptyValue())
////                    .order(globalOperationParameter.getOrder())
////                    .build());
////        }
////        return parameters;
////    }
//
//    /**
//     * 局部参数按照name覆盖局部参数
//     *
//     * @param globalOperationParameters
//     * @param docketOperationParameters
//     * @return
//     */
////    private List<Parameter> assemblyGlobalOperationParameters(
////            List<Swagger2Properties.GlobalOperationParameter> globalOperationParameters,
////            List<Swagger2Properties.GlobalOperationParameter> docketOperationParameters) {
////
////        if (Objects.isNull(docketOperationParameters) || docketOperationParameters.isEmpty()) {
////            return buildGlobalOperationParametersFromSwagger2Properties(globalOperationParameters);
////        }
////
////        Set<String> docketNames = docketOperationParameters.stream()
////                .map(Swagger2Properties.GlobalOperationParameter::getName)
////                .collect(Collectors.toSet());
////
////        List<Swagger2Properties.GlobalOperationParameter> resultOperationParameters = Lists.newArrayList();
////
////        if (Objects.nonNull(globalOperationParameters)) {
////            for (Swagger2Properties.GlobalOperationParameter parameter : globalOperationParameters) {
////                if (!docketNames.contains(parameter.getName())) {
////                    resultOperationParameters.add(parameter);
////                }
////            }
////        }
////
////        resultOperationParameters.addAll(docketOperationParameters);
////        return buildGlobalOperationParametersFromSwagger2Properties(resultOperationParameters);
////    }
//
//
//}

package ncepu.lykkk.exercise.swagger2;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: spring-cloud-exercise
 * @description: swagger2自动配置类
 * @author: 林玉坤
 * @create: 2022-02-26 11:04
 **/
//@Import({
//        Swagger2Configuration.class
//})
//@EnableConfigurationProperties(Swagger2Properties.class)
@Configuration
@ConditionalOnProperty(name = "lyk.swagger2.enabled", havingValue = "true", matchIfMissing = true)
@EnableSwagger2
@EnableConfigurationProperties(Swagger2Properties.class)
public class Swagger2AutoConfiguration implements BeanFactoryAware {
    private static final String AUTH_KEY = "token";
    @Resource
    Swagger2Properties swagger2Properties;

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public List<Docket> createRestApi() {
        ConfigurableBeanFactory configurableBeanFactory =
                (ConfigurableBeanFactory) beanFactory;
        List<Docket> docketList = new LinkedList<>();
        // 没有分组
        if (swagger2Properties.getDocket().isEmpty()) {
            Docket docket = createDocket(swagger2Properties);
            configurableBeanFactory.registerSingleton(swagger2Properties.getTitle(),
                    docket);
            docketList.add(docket);
            return docketList;
        }
        // 分组创建
        for (String groupName : swagger2Properties.getDocket().keySet()){
            Swagger2Properties.DocketInfo docketInfo =
                    swagger2Properties.getDocket().get(groupName);
            ApiInfo apiInfo = new ApiInfoBuilder()
                    //页面标题
                    .title(docketInfo.getTitle())
                    //创建人
                    .contact(new Contact(docketInfo.getContact().getName(),
                            docketInfo.getContact().getUrl(),
                            docketInfo.getContact().getEmail()))
                    //版本号
                    .version(docketInfo.getVersion())
                    //描述
                    .description(docketInfo.getDescription())
                    .build();

            // base-path处理
            // 当没有配置任何path的时候，解析/**
            if (docketInfo.getBasePath().isEmpty()) {
                docketInfo.getBasePath().add("/**");
            }
            List<Predicate<String>> basePath = new ArrayList<>();
            for (String path : docketInfo.getBasePath()) {
                basePath.add(PathSelectors.ant(path));
            }

            // exclude-path处理
            List<Predicate<String>> excludePath = new ArrayList<>();
            for (String path : docketInfo.getExcludePath()) {
                excludePath.add(PathSelectors.ant(path));
            }

            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo)
                    .groupName(docketInfo.getGroup())
                    .select()
                    //为当前包路径
                    .apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
                    .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)),Predicates.or(basePath)))
                    .build();
            configurableBeanFactory.registerSingleton(groupName, docket);
            docketList.add(docket);
        }
        return docketList;
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo(Swagger2Properties swagger2Properties) {
        return new ApiInfoBuilder()
                //页面标题
                .title(swagger2Properties.getTitle())
                //创建人
                .contact(new Contact(swagger2Properties.getContact().getName(),
                        swagger2Properties.getContact().getUrl(),
                        swagger2Properties.getContact().getEmail()))
                //版本号
                .version(swagger2Properties.getVersion())
                //描述
                .description(swagger2Properties.getDescription())
                .build();
    }

    //创建接口文档对象
    private Docket createDocket(Swagger2Properties swagger2Properties) {
        //API 基础信息
        ApiInfo apiInfo = apiInfo(swagger2Properties);

        // base-path处理
        // 当没有配置任何path的时候，解析/**
        if (swagger2Properties.getBasePath().isEmpty()) {
            swagger2Properties.getBasePath().add("/**");
        }
        List<Predicate<String>> basePath = new ArrayList<>();
        for (String path : swagger2Properties.getBasePath()) {
            basePath.add(PathSelectors.ant(path));
        }

        // exclude-path处理
        List<Predicate<String>> excludePath = new ArrayList<>();
        for (String path : swagger2Properties.getExcludePath()) {
            excludePath.add(PathSelectors.ant(path));
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName(swagger2Properties.getGroup())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)),Predicates.or(basePath)))
                .build();
    }

}