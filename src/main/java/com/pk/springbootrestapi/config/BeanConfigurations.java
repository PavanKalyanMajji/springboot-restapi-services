package com.pk.springbootrestapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
