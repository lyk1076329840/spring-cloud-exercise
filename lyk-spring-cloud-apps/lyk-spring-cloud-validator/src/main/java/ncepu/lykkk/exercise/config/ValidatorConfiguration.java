package ncepu.lykkk.exercise.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;

import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @program: spring-cloud-exercise
 * @description: validator配置类，指定教研室使用快速失败返回模式
 * @author: 林玉坤
 * @create: 2022-02-28 16:42
 **/
public class ValidatorConfiguration {

    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast","true")
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    /**
     * 开启快速返回
     * 如果参数检验有异常，直接抛出异常，不会进入到controller使用全局异常拦截来进行拦截
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

}
