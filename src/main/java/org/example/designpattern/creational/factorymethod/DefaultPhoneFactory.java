package org.example.designpattern.creational.factorymethod;

public abstract class DefaultPhoneFactory implements PhoneFactory {

    @Override
    public void sendEmailTo(String email, Phone phone) {
        System.out.println(phone.getName() + " production complete.");
    }

}
