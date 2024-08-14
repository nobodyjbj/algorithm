## Oop concept

* 아래의 4가지는 Oop를 지탱하는 concept이며 특징이다.

### Abstraction
* 설계관점
* 전지적 작가시점, 1인칭 시점
* 내가 프로그래밍할 사물의 필요한 정확한 요소들을 추출한 후 클래스로 재구성 하는 것이라고 정의 할 수 있다.
* 소프트웨어 관점으로 **속성, 행위를 추출하는 것**(일반화)이다. ( 행위에 대한 규약만 정의 = 메서드 시그니처 )
* 개발적으로 
  * abstract class, abstract method, interface 가 있다.

### Polymorphism
* 언어적 다형성
  * 하나의 단어(명칭은 동일하나) 표현이 주변 환경이나 필요에 의해 의미가 다르게 전달되는 것
* 개발적으로
  * Override(상속관계), Overloading(매개변수, 형태가 다를 수 있다.), 다른 패키지에서 같은 이름의 Class

### Encapsulation
* class로 설계(속성과 행위를 겹합시켜 묶는 것)하는 것 자체가 Encapsulation이다.
* 내부의 구성을 모르게 하는 것 또는 내부의 구성을 몰라도 사용할 수 있는 것
* 필요한 것만 노출시키는 것(public signature = 반환형, 이름, 파라미터 속성등)
* 정보은닉 이라는 혜택을 얻을 수 있다.
* Access Modifier (private, protected, package, public)

### Inheritance
* 상위클래스의 Attribute와 Method를 물려받아 재정의 하여 확장하는 것
* 변경이 아닌 확장의 개념
* java에서 상속할때 extends(확장하다)라는 단어를 사용
* 상속관계는 결합도가 높다. ( 가장 결합도가 높은 것은 class 내부이다.)