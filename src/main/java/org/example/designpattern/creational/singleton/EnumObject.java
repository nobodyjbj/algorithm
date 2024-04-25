package org.example.designpattern.creational.singleton;

// 리플렉션에도 안전한 방법, 자바에서는 Enum 을 리플렉션 new 로 만들 수 없다.
// Enum 클래스는 serializable 을 구현하고 있기때문에 직렬화 역직렬화에도 안전하다.
// 단점으로 미리 만들어지고, 상속이 불가하다.
public enum EnumObject {
    INSTANCE;
}