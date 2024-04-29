package me.nobody.designpattern.creational.factorymethod;

public class SimpleFactoryPattern {

    public Object createProduct(String name) {
        if (name.equals("Apple")) {
            return new IPhone();
        } else if (name.equals("Samsung")) {
            return new Galaxy();
        }

        throw new IllegalArgumentException();
    }
}
