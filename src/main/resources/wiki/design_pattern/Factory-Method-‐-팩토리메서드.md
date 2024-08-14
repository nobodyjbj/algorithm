## Factory Method ‐ 팩토리메서드

객체의 클래스를 선택하는 방법을 서브클래스에 위임하는 패턴이다.  
 * 객체의 생성을 한군데에서 관리할 수 있다.  
 * 확장할때 기존 코드의 변화가 없다. 클라이언트 소스에서도 인터페이스 기반으로 코드를 작성하게 되면 클라이언트 소스의 변경도 줄일 수 있다.
 * 패턴 구현에 의해 코드가 복잡해질 수 있다.

### 예제코드
[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/me/nobody/designpattern/creational/factorymethod) 

### Class Diagram
<img width="900" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/84d386f0-b474-4d93-a60f-fb5e877a4827">

### Java&Spring에서 사용된 팩토리메서드 패턴
* Java의 Calendar와 Java.lang의 NumberFormat 에서 [SimpleFactory](https://github.com/nobodyjbj/readme/blob/master/src/main/java/me/nobody/designpattern/creational/factorymethod/SimpleFactoryPattern.java) 패턴으로 구현되어 있는 것을 볼 수 있다.
* [Spring에서 BeanFactory](https://github.com/nobodyjbj/readme/blob/master/src/main/java/me/nobody/designpattern/creational/factorymethod/SpringBeanFactoryExample.java)가 팩토리패턴을 구현한 형태이다.

