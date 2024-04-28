package me.nobody.designpattern.creational.factorymethod;

public class SamsungFactory extends DefaultPhoneFactory {

    @Override
    public Phone createPhone() {
        return new Galaxy();
    }
}
