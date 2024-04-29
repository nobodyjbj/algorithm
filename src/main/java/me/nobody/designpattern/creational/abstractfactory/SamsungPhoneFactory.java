package me.nobody.designpattern.creational.abstractfactory;

public class SamsungPhoneFactory implements PhonePartsFactory {
    @Override
    public Camera createCamera() {
        return new SamsungCamera();
    }

    @Override
    public Display createDisplay() {
        return new SamsungDisplay();
    }
}
