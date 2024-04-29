package me.nobody.designpattern.creational.abstractfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfig {

    @Bean
    public PhoneFactoryBean shipFactory() {
        return new PhoneFactoryBean();
    }
}
