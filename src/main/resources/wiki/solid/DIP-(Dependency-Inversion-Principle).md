## DIP (Dependency Inversion Principle)

### 의존관계 역전 원칙

* 정말 중요한 개념이고 10년차는 되어야 잘~ 사용할 수 있다.
* 구현체(concrete)에 의존하지 말고 추상(abstract)에 의존하라.
* SpringFramework의 IOC(Inversion of control) 의 기반이 되는 개념
* 하나의 공통(속성, 행위)되는 인터페이스를 추출(일반화)하고 다이렉트로 참조하는 것을 추상으로 연결한다.
  의존당하던 클래스를 의존 하게 만든다.