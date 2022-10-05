package com.yxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.yxk.simpleLibrary.*.mapper"})
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(com.yxk.Demo01Application.class, args);
	}

}
