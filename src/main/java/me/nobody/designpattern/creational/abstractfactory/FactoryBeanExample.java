package me.nobody.designpattern.creational.abstractfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanExample {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        Phone phone = applicationContext.getBean("phone", Phone.class);
//        System.out.println(phone.getName());

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        Phone phone = applicationContext.getBean(Phone.class);
        System.out.println(phone.getName());
    }
}
