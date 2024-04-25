package org.example.designpattern.creational.singleton;

public class DoubleCheckLockingObject {

    private static volatile DoubleCheckLockingObject instance;

    // new 를 사용해서 생성자를 사용하지 못하도록 private 생성자를 선언해준다.
    private DoubleCheckLockingObject() {}

    public static DoubleCheckLockingObject getInstanceNotThreadSafety() {
        if (instance == null) {
            synchronized (DoubleCheckLockingObject.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockingObject();
                }
            }
        }

        return instance;
    }

}
