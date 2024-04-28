package me.nobody.designpattern.creational.factorymethod;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Phone {

    private String name;

    private String logo;

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
