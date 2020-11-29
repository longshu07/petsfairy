package com.longshu.petsfairy;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan(basePackages = "com.longshu.petsfairy.dao")
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class PetsfairyApplication {

    @Bean
    public SpringUtil getSpingUtil() {
        return new SpringUtil();
    }
    public static void main(String[] args) {
        SpringApplication.run(PetsfairyApplication.class, args);
    }


}
