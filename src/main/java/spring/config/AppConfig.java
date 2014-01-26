package spring.config;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.strategy.ProcessStrategyFactory;
import spring.strategy.Type1;

@Configuration
@ComponentScan({ "spring.strategy" })
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
