## Singleton ‐ 싱글톤 패턴

어떤 시스템 혹은 프로그램에서 여러개의 인스턴스가 여러개 일 때 문제가 생길수 있는 경우에 사용할 수 있는 패턴이다.  
유일한 단 하나의 인스턴스를 보장하도록 하는 패턴이다.  
그러기 위해서 인스턴스가 단 하나만 만들어 제공할 수 있어야 한다.   


### 예제 코드
[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/designpattern/creational/singleton)

### Class Diagram
<img width="300" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/8f088078-b18e-480f-a8c3-79bd2ea5b941">

### Singleton의 문제점
* 객체지향과 맞지 않다.  
  Singleton은 전역상태를 만들 수 있기 때문에 객체지향 관점에서 바람직하지 않은 구조이다.  
  또 한, private 생성자를 갖고 있기 때문에 상속에 제한이 있다.  
  static 필드와 메서드를 사용하기 때문에 다형성같은 객체지향의 특징이 적용되지 않는다.  
  클라이언트가 Concrete Class에 의존하므로 DIP 위반이다.  
  클라이언트가 Concrete Class에 의존하므로 OCP 또 한 위반할 가능성이 높다.
    
* 테스트가 어렵다.  
  Singleton은 만들어지는 방식이 제한적이기 때문에 테스트에서 사용될 때 mock 오브젝트 등으로 대체하기가 힘들다.  
  Mockito는 정적 메서드를 mock할 수 없기 때문에 가짜(mock)를 주입하기 어렵다. 대신 static 메소드를 mocking할 수 있는 PowerMock같은 도구를 사용하면 가능해진다.  

**이러한 문제점들을 해결하기 위한 Singleton Container가 Srping IoC의 [Singleton Registry](https://github.com/nobodyjbj/readme/wiki/Spring-IoC) 라는 것이 있다.**

### Singleton의 주의점
* 싱글톤 패턴을 사용 할 때, 주의할 점은 객체의 상태를 유지(stateful)하는 설계를 반드시 피해야 한다.  
  싱글톤 방식은 객체 인스턴스를 하나만 생성하고 공유하여 사용한다. 따라서 여러 클라이언트가 하나의 객체를 공유하게 된다.   
  이때 무상태(stateless)가 아니라면, 하나의 객체가 갖는 상태를 여러 클라이언트가 공유하는 결과가 생긴다.  
* 하나의 객체만 공유하기때문에 상태가 공유될 수 있으므로 의존적인 필드가 있으면 안된다.
* 특정 클라이언트가 값을 바꿀 수 있는 필드가 있으면 안된다.
* 가급정 수정은 불가하고 읽기만 가능해야 한다.