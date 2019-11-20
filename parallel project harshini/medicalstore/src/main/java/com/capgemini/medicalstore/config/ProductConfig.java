package com.capgemini.medicalstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration // can use @Component
public class ProductConfig {
	@Bean
	public LocalEntityManagerFactoryBean getEMF() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("medicalPersistentUnit");
		return factoryBean;

	}// END OF getEMF()
}// END OF CLASS
