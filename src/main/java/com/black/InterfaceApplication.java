package com.black;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.black.mapper")
public class InterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfaceApplication.class, args);
	}
}
