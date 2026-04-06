package com.fag.lucasmartins.arquitetura_software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fag.lucasmartins.arquitetura_software")
public class ArquiteturaSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaSoftwareApplication.class, args);
	}

}
