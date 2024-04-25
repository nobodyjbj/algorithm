package org.example.designpattern.creational.singleton;

public class StaticInnerClassObject {

    // 멀티스레드 환경에서도 안전하고 lazy 로딩도 가능한 방법 (권장)
    private StaticInnerClassObject() {}

    private static final class InstanceHolder {
        private static final StaticInnerClassObject instance = new StaticInnerClassObject();
    }

    public static StaticInnerClassObject getInstanceNotThreadSafety() {
        return InstanceHolder.instance;
    }

}
