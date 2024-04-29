package me.nobody.designpattern.creational.abstractfactory;

public class PhoneInventory {
    public static void main(String[] args) {
        DefaultPhoneFactory applePhoneFactory = new PhoneFactory(new ApplePhoneFactory());
        Phone iphone = applePhoneFactory.createPhone();
        System.out.println(iphone.getCamera());
        System.out.println(iphone.getDisplay());

        DefaultPhoneFactory samsungPhoneFactory = new PhoneFactory(new SamsungPhoneFactory());
        Phone galaxy = samsungPhoneFactory.createPhone();
        System.out.println(galaxy.getCamera());
        System.out.println(galaxy.getDisplay());
    }
}
