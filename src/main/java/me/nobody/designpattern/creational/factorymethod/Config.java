package me.nobody.designpattern.creational.factorymethod;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class Config {

    @Bean
    public String hello() {
        return "hello";
    }
}
