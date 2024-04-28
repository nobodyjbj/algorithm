package org.example.designpattern.creational.factorymethod;

public class SamsungFactory extends DefaultPhoneFactory {

    @Override
    public Phone createPhone() {
        return new Galaxy();
    }
}
