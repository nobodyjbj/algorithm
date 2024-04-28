package me.nobody.designpattern.creational.factorymethod;

public class AppleFactory extends DefaultPhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
