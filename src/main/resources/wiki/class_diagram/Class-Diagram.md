## ClassDiagram

### 클래스 다이어그램의 구성  

#### 클래스(Class)
클래스는 사각형으로 표현되며, 클래스의 이름이 포함된다.

#### 속성(Attributes) 
클래스의 상태를 나타낸다.  
예를 들어, 사람 클래스의 속성으로는 이름, 나이 등이 있을 수 있다.   
이러한 속성은 클래스 다이어그램에서 클래스 이름 아래에 나열됩니다.  

#### 메서드(Methods)
클래스가 수행하는 작업을 정의한다. 
예를 들어, 자동차 클래스의 메서드로는 악셀, 브레이크등의 행위에 관한 것들이 있을 수 있다.  
메서드는 클래스 다이어그램에서 클래스의 속성 아래에 나열된다.

#### 관계(Relationships)
클래스 간의 관계를 나타냅니다. 일반적으로 상속, 연관, 의존, 집합 등의 관계가 있습니다.   
이러한 관계는 화살표로 표현되며, 각 화살표에는 관계의 성격을 나타내는 표기가 있다.  
관계에 대한 표기는 아래에 자세하게 다룬다.

#### 인터페이스(Interfaces)
클래스나 컴포넌트가 제공하는 기능을 정의한다.  
인터페이스는 클래스 다이어그램에서 클래스와 유사하게 표현되지만, 이탤릭체로 표시되거나 인터페이스 이름 위에 <<interface>>와 같은 표시가 붙는다.

### 클래스 다이어그램의 관계 표기 방법

![image](https://github.com/nobodyjbj/readme/assets/21189169/83ac429e-fe15-4de8-86b4-cf2b230ad1e5)  


#### Generalization, Inheritance : 일반화, 상속관계

상위 클래스와 하위 클래스의 상속관계를 말한다.
실선과 색칠된 화살표로 표기한다.

<img width="459" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/0b9357d0-2840-419a-a050-92807e719279">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/inheritance)  


#### Realization, Implementation : 구현
interface 를 오버라이드하여 실제 기능을 구현하는 관계를 말한다.  
점선과 색칠된 화살표로 표기한다.  

<img width="197" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/9644329d-7794-444b-ba64-1c96c100be7d">  

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/realization)  


#### Dependency : 의존

Dependency(의존성)는 한 클래스가 다른 클래스를 사용하는 것을 의미한다.  
즉, 한 클래스의 변경이 다른 클래스에 영향을 줄 수 있다는 것을 나타낸다.  
메서드 호출, 인스턴스 생성 등의 형태이다.
예를 들어, 클래스 A가 클래스 B를 사용하고 있다면, 클래스 A는 클래스 B에 의존성이 있고, 이것은 클래스 A의 인스턴스가 생성될 때 클래스 B의 인스턴스가 필요하거나, 클래스 A의 메서드에서 클래스 B의 메서드를 호출한다는 것을 의미한다.

<img width="293" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/e61125b2-325e-4ec0-8f6e-f0a40a0a4529">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/dependency)  


#### Association : 연관
한 클래스의 인스턴스가 다른 클래스의 인스턴스를 참조할 수 있다는 것을 의미한다.
Association은 일반적으로 직선으로 나타내며, 양 끝에 화살표가 없다. 양쪽 끝에 이름이나 다중성 등의 추가 정보를 표시할 수 있.
예를 들어, "학생" 클래스와 "강의" 클래스 간의 관계는 Association으로 표현될 수 있다. 학생은 여러 강의를 수강할 수 있고, 각 강의는 여러 학생을 가질 수 있다.  
(intelliJ Diagram 에서는 모두 Association 에 대한 표기를 화살표와 마름모로 표기된다.)   

<img width="523" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/c7998c95-573a-46d5-877e-ca84c9ecabb1">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/assosiation)  


#### Directed Association : 방향성이 있는 연관

한 클래스에서 다른 클래스로의 방향성이 있는 관계를 나타낸다. 관계가 단방향이라는 것을 의미한다.  
화살표를 사용하여 관계의 방향을 나타낸다.  
(intelliJ Diagram 에서는 모두 Association 에 대한 표기를 화살표와 마름모로 표기된다.)  

<img width="313" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/24a39197-11d1-4dec-8ac4-5da5618ba5d3">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/directedassociation)  


#### Aggregation : 집합

Association의 특수한 관계이다.  
"has-a" 관계를 나타낸다. 한 클래스가 다른 클래스의 일부를 가질 수는 있지만 독립적인 관계라고 할 수 있다.  
직선 또는 화살표 빈 마름모로 표기한다.  
(intelliJ Diagram 에서는 모두 Association 에 대한 표기를 화살표와 마름모로 표기된다.)  

<img width="265" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/13c849d6-f1c0-4a27-83b9-89b75c4b9024">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/assosiation)  


#### Composition : 합성

Aggregation의 한 형태로, 한 클래스가 다른 클래스의 일부를 가지며, 독립적인 관계라고 할 수 없다.   
예를 들면, 자동차에 엔진은 떨어질 수 없느 관계다. 이런 관계를 Composition 관계라고 할 수 있다.  
직선 또는 화살표와 채워진 마름모로 표현된다.  
(intelliJ Diagram 에서는 모두 Association 에 대한 표기를 화살표와 마름모로 표기된다.)  

<img width="270" alt="image" src="https://github.com/nobodyjbj/readme/assets/21189169/1589eb08-a863-4229-989d-dbc33410b631">

[code](https://github.com/nobodyjbj/readme/tree/master/src/main/java/org/example/classdiagram/composition)
