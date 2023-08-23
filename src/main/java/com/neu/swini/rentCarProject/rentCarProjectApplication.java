package com.neu.swini.rentCarProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.neu.swini.rentCarProject.controller", "com.neu.swini.rentCarProject.pojo", "com.neu.swini.rentCarProject.dao", "com.neu.swini.rentCarProject.validator"})
public class rentCarProjectApplication extends ServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(rentCarProjectApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("home");
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10000000);
		return multipartResolver;
	}
}