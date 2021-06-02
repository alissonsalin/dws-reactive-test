package dws.reactive.test.configuration;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dws.reactive.test.exception.CompareFilterNotFoundException;
import dws.reactive.test.exception.handler.BandCompareFilterFactory;

@Configuration
public class BandsCompareFilterConfig {

	@Bean("parserFactory")
	public FactoryBean<?> serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(BandCompareFilterFactory.class);
		factoryBean.setServiceLocatorExceptionClass(CompareFilterNotFoundException.class);
		return factoryBean;
	}
}
