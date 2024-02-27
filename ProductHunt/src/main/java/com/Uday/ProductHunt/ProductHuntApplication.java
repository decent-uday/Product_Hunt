package com.Uday.ProductHunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ProductHuntApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductHuntApplication.class, args);
	}

}
