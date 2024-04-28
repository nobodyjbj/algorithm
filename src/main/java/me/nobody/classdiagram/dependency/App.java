package me.nobody.classdiagram.dependency;

public class App {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Service service = new Service(logger); // Service 클래스에 Logger 클래스의 인스턴스 전달

        service.doSomething();
    }
}
