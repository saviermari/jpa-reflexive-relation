package com.smari.reflexive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author smari
 * This demo application does not cover exception handloing and validation, it will work for the correct payload
 */
@SpringBootApplication
public class JpaReflexiveRelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaReflexiveRelationApplication.class, args);
	}

}
