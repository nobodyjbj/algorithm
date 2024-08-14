## Abstract Factory - 추상팩토리

연관성 있는 객체들이 여러개 존재할 경우 이것들을 묶어서 추상화(Generalization)하고, 추상화된 객체를 구현화 하는 생성패턴이다. 클라이언트에서 특정 객체를 사용할때 팩토리 클래스만을 참조하여 객체를 생성할 수 있다.   

### 예제 코드

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/me/nobody/designpattern/creational/abstractfactory)

### Class Diagram

![image](https://github.com/nobodyjbj/readme/assets/21189169/e2e9b124-ada1-4f19-81a1-7b757c0b05bc)

### 추상 팩토리 패턴과 팩토리 메소드 패턴의 차이점
1. 관점
  * 팩토리 메소드 패턴은 '팩토리를 구현하는 방법(inheritance)'에 초점을 둔다.
  * 추상 팩토리 패턴은 '팩토리 사용하는 방법(composition)'에 초점을 둔다.
2. 목적
  * 팩토리 메소드 패턴은 구체적인 객체 생성 과정을 하위 또는 구체적이 클래스로 옮기는 것이 목적이다.
  * 추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적이다.
 
### Java&Spring 에서 사용하는 팩터리 패턴
* Java
  * XPathFactory
  * TransFormerFactory
  * DocumentBuilderFactory
* Spring
  * [FactoryBean](https://github.com/nobodyjbj/readme/blob/master/src/main/java/me/nobody/designpattern/creational/abstractfactory/FactoryBeanExample.java)
