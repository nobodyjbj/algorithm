## 목차

- [JVM이란 무엇인가?](#JVM이란-무엇인가)
- [컴파일 하는 방법](#컴파일-하는-방법)
- [실행하는 방법](#실행하는-방법)
- [바이트코드란 무엇인가?](#바이트코드란-무엇인가)
- [JIT 컴파일이란 무엇이며 어떻게 동작하는가?](#JIT-컴파일이란-무엇이며-어떻게-동작하는가)
- [JVM 구성 요소](#JVM-구성-요소)
- [JDK와 JRE의 차이](#JDK와-JRE의-차이)

## JVM이란 무엇인가?

![image](https://user-images.githubusercontent.com/21189169/123650643-b848b000-d865-11eb-911b-0b6d18d8dda2.png)

Credit: http://www.tcpschool.com/java/java_intro_programming

- 자바 가상머신은 컴퓨터가 자바 프로그램을 실행할 수 있도록 도와준다.
- .class 코드(바이트코드)를 실행시켜주는 자바 가상머신이다. 
- 자바 가상머신이라는 것은 운영체제(OS)가 다르더라도 자바 가상머신만 설치되어 있다면, 프로그램을 추가 조건 없이 실행 가능하도록 하는 것이다.
- 단, 자바 가상머신은 운영체제(OS)에 종속적이며 각 운영체제에 맞는 자바 가상머신을 설치해야 한다.

## 컴파일 하는 방법
- javac 는 jdk안에 포함되어 있다.
- java9 버전부터는 JRE가 없어지고 JDk(Java Develpment Kit) 안에 포함된다.
- java 다운로드 경로 -> /home/bin 으로 이동
- Hello.class 파일 생성
``` 
> ./javac Hello.java

```
 
## 실행하는 방법
- java 다운로드 경로 -> /home/bin 으로 이동
```
> java Hello
```

## 바이트코드란 무엇인가?
- 자바 바이트코드는 자바 가성머신(JVM)이 이해할 수 있는 언어로 변환된 자바 소스 코드를 의미한다.
- 자바 바이트코드의 확장자는 .class 이다.
- 자바 바이트코드는 자바 가상머신만 설치되어 으면, 어떤 운영체제에서라도 실행이 가능하다.

## JIT 컴파일이란 무엇이며 어떻게 동작하는가?
- JVM 이 바이트코드를 기계어로 interpret(해석) 할 때, 반복되는 내용은 컴파일해서 사용한다. 이 과정을 JIT 컴파일링이라고 한다.

## JVM 구성 요소

![image](https://user-images.githubusercontent.com/21189169/123657482-c994bb00-d86b-11eb-9892-3a53bc84c458.png)

Credit: JavaWorld/ IDG

![image](https://user-images.githubusercontent.com/21189169/156366310-18bafe69-0978-4139-91c0-5e4a4690c688.png)

Credit: 인프런/ whiteship 의 [더 자바, 코드를 조작하는 다양한 방법]

메모리

- 힙(Heap)
  - 객체를 저장한다. 공유자원이다.

- 메서드(method)
  - 클래스 수준의 정보(클래스 이름, 부모 클래스 이름, 메소드, 변수) 저장한다. 공유 자원이다.

- 스택(Stack)
  - 쓰레드내에서만 공유한다.
  - 쓰레드마다 런타임 스택을 만들고, 그 안에 메소드 호출을 스택 프레임이라 부르는 블럭을 쌓는다. 쓰레드를 종료하면 런타임 스택도 사라진다.
  - 에러로그에 메서드들이 쌓이는 것을 볼 수 있는데, 런타임 스택에 쌓인 메서드들이 보이는 것이다.

- PC(Program Counter) 레지스터 
  - 쓰레드내에서만 공유한다. 
  - 현재 어느 위치를 호출하고 있는지 가르키는 역할을 한다. -> 쓰레드 마다 현재 실행하고 있는 스택 프레임을 가리키는 포인터가 생성된다.

- 네이티브 메소드 스택

- 더 알고싶다면, https://javapapers.com/core-java/java-jvm-run-time-data-areas/#Program_Counter_PC_Register
  
JNI(Java Native Interface)
  - 자바에서 C, C++, 어셈블리로 작성된 함수를 사용할 수 있는 방법을 제공한다.
  - native 키워드를 사용한 메소드 호출
  - 실제 구현된 메서드를 *네이티브 메소드 라이브러리* 라고 하고 JNI를 통해서 사용해야 한다.
  - 더 알고싶다면, https://medium.com/@bschlining/a-simple-java-native-interface-jni-example-in-java-and-scala-68fdafe76f5f  

실행엔진

- 자바 인터프리터(interpreter)
  - 자바 컴파일러에 의해 변환된 바이트 코드(.class)를 읽고 해석하는 역할을 한다.
  - 바이트 코드를 한줄씩 ***한줄씩 네이티브 코드(기계어)로 바꿔서 실행*** 한다.

- JIT 컴파일러(Just-In-Time compiler)
  - 프로그램이 실행중(런타임)중에 바이트코드를 네이티프 코드(기계어)로 컴파일러를 말한다. 동적 번역(dynamic translation)이라고도 불리는 이 기법은 프로그램의 실행속도를 높이기 위해 개발되었다.
  - 동적 번역인 이유는 JIT컴파일러를 사용하는 JVM은 내부적으로 해당 메서드가 얼마나 자주 수행되는지 체크하고 일정 정도를 넘을때만 컴파을 수행하기 때문이다.

- 가비지 컬렉터(garbage collector)
  - 메모리 관리 기법 중의 하나로, 프로그램이 동적으로 할당했던 메모리 영역 중에서 필요 없게 된 영역을 해제하는 기능이다.
  - 더이상 참조하지 않는 객체를 모아서 정리한다.
  - JVM에서는 GC에 의해 Unreachable 오브젝트를 우선적으로 메모리에서 제거하여 메모리 공간을 확보한다.
  - Mark And Sweep 이라고도 한다. JVM의 가비지 컬렉터가 스택의 모든 변수를 스캔하면서 각가 어떤 오브젝트를 레퍼런스하고 있는지 찾는 과정이 Mark이다. 그리고 Mark되어 있지 않는 모든 오브젝트들을 힙에서 제거하는 과정이 Sweep 이다.
  - GC는 레퍼런스 되고 있지 않는 오브젝트(grabage)를 수집하여 제거할 것 같지만, 실제로는 레퍼런스되고 있는 오브젝트를 Mark하고 그 외의 것들을 힙에서 제거하는 방식으로 동작한다. 

클래스 로더(class loader)
- 확장자가 .class 클래스 파일(바이트 코드)의 위치를 찾아 그것을 JVM이 운영체제로 부터 할당받은 메모리 영역인 Runtime Data Area에 올려놓는 과정을 뜻한다. 
- 확장 클래스 로더(Extenstion Class Loader)는 $JAVA_HOME/jre/lib/ext 경로에 위치해 있는 자바의 확장 클래스들을 로딩하는 역할을 한다. 
- 시스템 클래스 로더(System Class Loader)는 $CLASSPATH에 설정된 경로를 탐색하여 그곳에 있는 클래스들을 로딩하는 역할을 한다. .class 확장자 파일을 로딩한다.

- 과정
  - 로딩
    - 클래스 로더가 .class 파일을 읽고 그 내용에 따라 적절한 바이너리 데이터를 만들고 **메소드 영역**에 저장
    - 이때 메소드 영역에 저장하는 데이터는 FQCN, 클래스, 인터페이스, 이늄, 메소드와 변수
    - 로딩이 끝나면 해당 클래스 타입의 Class 객체를 생성하여 Heqp 영역에 저장
  - 링크
    - Verify, Prepare, Resolve(optional) 세 단꼐로 나눠진다.
    - Preparation : 클래스 변수(static 변수)와 기본값에 필요한 메모리
    - Resolve : 심볼릭 메모리 레퍼런스를 메소드 영역에 있는 실제 레퍼런스로 교체한다.

  - 초기화
    - Static 변수에 값을 할당한다. (static 블럭이 있다면 이때 실행된다.)
- 클래스 로더는 계층 구조로 이뤄져 있으며 기본적으로 세가지 클로스 로더가 제공된다.
  - 부트 스트랩 클래스 로더 : JAVA_HOME/lib에 있는 코어 자바 API를 제공한다. 최상위 우선순위를 가진 클래스 로더
  - 플랫폼 클래스 로더 : JAVA/lib/ext 폴더 또는 java.ext.dirs 시스템 변수에 해당하는 위치에 있는 클래스를 읽는다.
  - 애플리케이션 클래스 로드 : 애플리케이션 클래스패스(애플리케이션 실행할 땐 주는 -classpath 옵션 또는 java.class.path 환경 변수의 값에 해당하는 위치_에서 클래스를 읽는다.


## JDK와 JRE의 차이

![image](https://user-images.githubusercontent.com/21189169/123658218-796a2880-d86c-11eb-9a99-e70430c016fa.png)

Credit: https://www.oracle.com

JRE(Java Runtime Environment) 란?
- 이름에서 알 수 있듯이 환경이다. 컴파일된 자바 프로그램을 실행시킬 수 있는 자바 환경을 의미한다.
- .class파일을 생성할 수는 없다.
- 하지만 이클립스에서 JRE 만 설치해도 컴파일이 되는 경우가 있는데, 이 것은 툴에서 기본적으로 컴파일을 제공하기 때문이다.
  
JDK(Java Development Kit) 란?
- JDK에는 javac(컴파일러)가 존재하며 javac로 .class파일을 생성할 수 있다.
- JDK는 Java를 사용하기 위해 필요한 모든 기능을 갖춘 SDK(Software Development Kit)이다.
- JRE에 있는 모든 것뿐만 아니라 javac, jdb, javadoc과 같은 도구도 있다. 즉, 프로그램을 생성하고 컴파일 할 수 있다.

java9 버전부터 JRE가 출시되지 않는다. JDK만으로도 자바프로그램을 실행시키고 개발할 수 있는 환경이 제공된다.

