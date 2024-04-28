package me.nobody.designpattern.creational.singleton;

public class ThreadUnsafeObject {

    // 단 하나의 인스턴스를 담을 변수를 선언한다.
    private static ThreadUnsafeObject instance;

    // new 를 사용해서 생성자를 사용하지 못하도록 private 생성자를 선언해준다.
    private ThreadUnsafeObject() {}

    // 단 하나의 객체만 생성하기 위한 static 한 메서드를 생성하여 제공한다.
    // 하지만 이 방법은 스레드 세이프(thread safe) 하지 않다.
    public static ThreadUnsafeObject getInstanceNotThreadSafety() {
        if (instance != null) {
            instance = new ThreadUnsafeObject();
        }

        return instance;
    }

}
