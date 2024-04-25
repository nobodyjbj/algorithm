package org.example.designpattern.creational.singleton;

public class SyncronizedSettings {

    // new 를 사용해서 생성자를 사용하지 못하도록 private 생성자를 선언해준다.
    private static SyncronizedSettings instance;

    private SyncronizedSettings() {}

    // synchronized 라는 키워드를 사용하여 이 메서드에 한번에 하나의 스레드만 들어올 수 있게 처리할 수 있다.
    // 다만, 동기화 처리하는 작업때문에 성능의 약간의 불이득이 생길 수 있다.
    public static synchronized SyncronizedSettings getInstanceSynchronized() {
        if (instance != null) {
            instance = new SyncronizedSettings();
        }

        return instance;
    }

}
