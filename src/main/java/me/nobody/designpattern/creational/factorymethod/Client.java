package me.nobody.designpattern.creational.factorymethod;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();

        client.print(new SamsungFactory(), "S24");
        client.print(new AppleFactory(), "15Pro");
    }

    private void print(PhoneFactory phoneFactory, String name) {
        System.out.println(phoneFactory.orderPhone(name, "nobody.jbj@gmail.com"));
    }
}
