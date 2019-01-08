package com.zhihui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// swagger配置信息
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public ApiInfo createApi(){
        return new ApiInfoBuilder().title("智慧商城项目接口文档").description("后端不好过啊，白天要讲课啊，没有时间写啊").
                contact(new Contact("智慧商城后端小组","http://1000phone.com","121212@163.com")).build();
    }

    @Bean
    public Docket createDoc(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApi()).
            select().apis(RequestHandlerSelectors.basePackage("com.zhihui.controller")).build();
    }
}
