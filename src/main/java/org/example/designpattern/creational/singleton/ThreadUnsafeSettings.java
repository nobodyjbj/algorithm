package org.example.designpattern.creational.singleton;

public class ThreadUnsafeSettings {

    private static ThreadUnsafeSettings instance;

    // new 를 사용해서 생성자를 사용하지 못하도록 private 생성자를 선언해준다.
    private ThreadUnsafeSettings() {}

    // 단 하나의 객체만 생성하기 위한 static 한 메서드를 생성하여 제공한다.
    // 하지만 이 방법은 스레드 세이프(thread safe) 하지 않다.
    public static ThreadUnsafeSettings getInstanceNotThreadSafety() {
        if (instance != null) {
            instance = new ThreadUnsafeSettings();
        }

        return instance;
    }

}
