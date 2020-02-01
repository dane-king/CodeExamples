package com.daneking.springboot.config;

import com.daneking.springboot.strategy.ProcessStrategyFactory;
import com.daneking.springboot.strategy.Type1;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.daneking.springboot.strategy" })
public class AppConfig {
	@Bean
	public ServiceLocatorFactoryBean processStrategyFactory() {
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(ProcessStrategyFactory.class);
		return bean;
	}

	@Bean(name = { "Type1", "t1" })
	public Type1 getType1() {
		return new Type1();
	}

}
