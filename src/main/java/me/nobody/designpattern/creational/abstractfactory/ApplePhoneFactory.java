package me.nobody.designpattern.creational.abstractfactory;

public class ApplePhoneFactory implements PhonePartsFactory {
    @Override
    public Camera createCamera() {
        return new AppleCamera();
    }

    @Override
    public Display createDisplay() {
        return new AppleDisplay();
    }
}
