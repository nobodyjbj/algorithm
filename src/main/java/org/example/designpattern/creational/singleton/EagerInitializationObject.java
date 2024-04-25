package org.example.designpattern.creational.singleton;

public class EagerInitializationObject {

    // instance 를 선언하여 미리 객체를 할당해준다.
    private static final EagerInitializationObject INSTANCE = new EagerInitializationObject();

    // new 를 사용해서 생성자를 사용하지 못하도록 private 생성자를 선언해준다.
    private EagerInitializationObject() {}

    // 단 하나의 객체만 생성하기 위한 static 한 메서드를 생성하여 제공한다.
    public static EagerInitializationObject getInstanceNotThreadSafety() {
        return INSTANCE;
    }

}
