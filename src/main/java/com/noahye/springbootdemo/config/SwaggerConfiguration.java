package com.noahye.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger 配置类
 *
 * @author noah
 */
@EnableOpenApi
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.noahye.springbootdemo"))
                .build();
    }

    /**
     * 创建 API 信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口文档示例")
                .description("我是一段描述")
                // 版本号
                .version("1.0.0")
                // 联系人
                .contact(new Contact("noah", "http://www.noah.cn", "yepengfei97@163.com"))
                .build();
    }
}
