package me.nobody.designpattern.creational.abstractfactory;

public class PhoneFactory implements DefaultPhoneFactory {
    private final PhonePartsFactory phonePartsFactory;

    public PhoneFactory(PhonePartsFactory phonePartsFactory) {
        this.phonePartsFactory = phonePartsFactory;
    }

    @Override
    public Phone createPhone() {
        Phone phone = new IPhone();
        phone.setCamera(phonePartsFactory.createCamera());
        phone.setDisplay(phonePartsFactory.createDisplay());
        return phone;
    }
}
