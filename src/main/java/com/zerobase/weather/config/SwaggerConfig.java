package com.zerobase.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //http://localhost:8080/swagger-ui/index.html 에서 api 문서를 조회할 수 있다.
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.zerobase.weather"))
            //.paths(PathSelectors.ant("/read/**")) //any는 모든 api가 나오도록 하겠다. none은 아무것도 안보여준다. ant는 특정 경로만 가능
            .paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        String description = "Welcome Log Company";
        return new ApiInfoBuilder()
            .title("날씨 일기 프로젝트")
            .description("날씨 일기를 CRUD 할 수 있는 백엔드 API입니다.")
            .version("1.1")
            .build();
    }
}



