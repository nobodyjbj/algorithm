package me.nobody.designpattern.creational.abstractfactory;

import org.springframework.beans.factory.FactoryBean;

public class PhoneFactoryBean implements FactoryBean<Phone> {

    @Override
    public Phone getObject() throws Exception {
        Phone phone = new Phone();
        phone.setName("15Pro");
        return phone;
    }

    @Override
    public Class<?> getObjectType() {
        return Phone.class;
    }
}
