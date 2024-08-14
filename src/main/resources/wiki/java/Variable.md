## 목차

- [프리미티브 타입 종류와 값의 범위 그리고 기본 값](#프리미티브-타입-종류와-값의-범위-그리고-기본-값)
- [프리미티브 타입과 레버런스 타입](#프리미티브-타입과-레버런스-타입)
- [리터럴](#리터럴)
- [변수 선언 및 초기화하는 방법](#변수-선언-및-초기화하는-방법)
- [변수의 스코프와 라이프타임](#변수의-스코프와-라이프타임)
- [타입 변환과 캐스팅 그리고 타입 프로모션](#타입-변환과-캐스팅-그리고-타입-프로모션)
- [1차 및 2차 배열 선언하기](#1차-및-2차-배열-선언하기)
- [타입 추론과 var](#타입-추론과-var)

## 프리미티브 타입 종류와 값의 범위 그리고 기본 값

### Primitive Type

<img width="1077" alt="스크린샷 2021-06-30 오전 12 22 05" src="https://user-images.githubusercontent.com/21189169/123824728-43df4100-d939-11eb-8cf0-8760933f268c.png">

- unisigned int (22 억 표현하기)
  ```
  int unsigned = 2200000000; // 컴파일 에러
  System.out.println(unsiged + 100000000);
  // result : error -> integer number to large
  ```
  ```
  int unsigned = 2100000000; // 컴파일 에러
  System.out.println(unsiged + 100000000);
  // result : error -> integer number to large
  ```
  ```
  int unsigned = Integer.parseUnsignedInt("2200000000"); // 오버플로우
  System.out.println(unsiged);
  // result : -2094967296
  ```
  ```
  int unsigned = Integer.parseUnsignedInt("2200000000"); // 오버플로우
  System.out.println(Integer.toUnsignedString(unsigned));
  // result : 2200000000
  ```
  - 결론은 BigInteger를 사용하자.

## 프리미티브 타입과 레버런스 타입

- **Primitive type**
  - byte, short, signed/unsigned int, signed/unsigned long, float, double, boolean, char
  - not object
  - 값 저장
  - JVM메모리 영역 중 Stack에 저장
  - 초기화 값은 자동으로 0이된다.

- **Reference type**
  - class, interface, enum, array, String type
  - 주소 저장
  - JVM메모리 영역 중 Heap에 저장
  - Primitive type 을 Reference type으로 바꾸는 타입을 wrpper class라고 한다.
  - 초기화 값은 자동으로 null이 된다.

## 리터럴

- 변수나 상수에 저장되는 값 자체를 의미한다. 변하지 않는 데이터를 의미한다.
- Primitive 타입과 Reference Type 에서는 String 리터럴이 존재한다.
- 얘들 들면,
  ```
  int a = 10 // 10이 리터럴이다.
  ```

### 정수 리터럴

- 정수를 표현하는 방법은 여러가지가 있다. 일반적으로 사용하는 10진법 부터 2진법 8진법 과 같은 방법이 있고 자바에서는 다양한 진법을 지원한다.
- 10진수 26을 다양한 리터럴로 표현해보자.
  ```
  int decimal = 26;	     // 일반적인 형태 10진법
  int ocatal = 032;        // 제일 앞에 0 이 붙으면 8진법 
  int heaxaDecimal = 0x1a; // 0x가 붙으면 16진법 
  int binary = 0b11010;    // 0b가 붙으면 2진법 
  ``` 

### 실수 리터럴

- 실수 타입의 리터럴은 기본적으로 double 타입이고, float 타입으로 표현하려면 f를 명시적으로 붙여야한다.
  ```
  double a = 0.1;    // 0.1
  double b = 1E-1;   // 0.1
  float c = 0.1f;    // 0.1
  ```

### 문자 리터럴

- 문자는 작은따옴표(')안에 표현할 수 있다
  ```
  char a = 'a';    // a 
  ```

또 한, 특수문자를 위한 리터럴들도 있다.

특수문자 리터럴 | 의미 |
:----------:|:----|
 '\b' | 백스페이스(back space)
 '\t' | 탭(tab)
 '\n' | 라인피드(line feed)
 '\f' | 폼피드(form feed)
 '\r' | 캐리지 리턴(carriage return)
 '\"' | 이중 인용 부호(double quote)
 '\'' | 단일 인용 부하(single quote)
 '\\' | 백슬래시(backslash)

### 문자열 리터럴

- 문자열은 큰따옴표(")안에 표현할 수 있다.
  ```
  String a = "abc";    // abc, 데이터가 Heap 공간의 String constant pool에 저장
  String b = "abc";    // abc가 String constant pool에 있기때문에 그대로 참조한다. 즉 abc는 1개만 존재한다.
  String c = new String("abc");  // 이 형태는 리터럴이 아니다. heap에 독립적인 객체 생성
  ```

### boolean 리터럴

- true, false로 표현할 수 있다.
  ```
  boolean a = true;
  boolean b = false; 
  ```

## 변수 선언 및 초기화하는 방법

### 변수 선언
  ```
  Long var1; // [타입] [변수 이름];
  ```

### Java 의 변수 이름 규칙

- 첫 번째 글자는 문자이거나 '',' '이어야 하고 숫자는 허용하지 않는다.
- 첫 문자는 영어 소문자로 시작하고, 다른 단어가 붙을 경우에는 첫 문자를 대문자로 한다.
- 문자 수(변수 이름의 길이)의 제한이 없다.
- 예약어를 사용할 수 없다.

### 예약어

분류 | 예약어 
:---|---------------------------------
기본 데이터 타입 | boolean, byte, char, shor, int, long, float, double
접근 지정자 | private, protected, public, package
클래스와 관련된 것 | class, abstract, interface, extends, implements, enum
객체와 관련된 것 | new, instanceof, this, super, null
메소드와 관련된 것 | void, return
제어문과 관련된 것 | if, else, switch, case, default, for, do, while, break, continue 
논리 값 | true, false
예외 처리와 관련된 것 | try, catch, finally, throws
기타 | import, synchronized, transient, volatile, native, final, static, strictfp, assert

### 멤버번수와 지역번수

  ```
  public class Example {
    int var1;         // 멤버변수, 전역변수
    double var2;      // 멤버변수, 전역변수
    String var3 = ""; // 멤버변수, 전역변수

    void test() {
      int var1;         // 지역변수
      double var2;      // 지역변수
      String var3 = ""; // 지역변수
    }
  }
  ```

### 초기화

- 명시적 초기화

  ```
  int a = 0; // [변수타입] [변수 이름] = [초기화 값];
  ```

- 생성자 초기화
  ```
  Example example = new Example();
  example.var1 = 1;
  example.var2 = '1.2';
  example.var3 = "test";

  // 매개변수를 받는 생성자가 있다면 아래의 형태로도 초기화가 가능하다.
  Example example = new Example(1, 1.2,"test");
  ```

- 블록 초기화
  ```
  public class Example {
    int var1 = 10;         
    static int var2 = 20;

    { 
      var1 = 11; // 일반 초기화 블록
    }
    
    static { 
      var2 = 21; // 정적 초기화 블록
    }
  }
  ```

#### 명시적 초기화

## 변수의 스코프와 라이프타임

### Scope? LifeTime?

- 변수의 스코프란 해당 변수를 사용할 수 있는 영역범위를 뜻하고 라이프타임은 해당 변수가 메모리에 언제까지 살아있느지를 의미한다. 변수의 경우 scope 에 따라 Instance Variables, Class Variables, Local Variables 로 나눌 수 있다.

### Instance Variables

- 클래스 안에서 선언되어있고, 어떠한 method나 block안에서 선언되지 않은 변수
- scope - static method를 제외한 클래스 전체
- lifetime - 클래스를 인스턴스화한 객체가 메모리에서 사라질 때 까지

### Class Variables

- 클래스 안에서 선언되어있고, 어떠한 메서드나 블럭안에서 선언되지 않았으며 static 키워드가 포함되어 선언된 변수
- scope - 클래스 전체
- lifetime - 프로그램 종료시 까지

### Local Variables

- 인스턴스 변수, 클래스 변수가 아닌 모든 변수
- scope - 변수가 선언된 block 내부
- lifetime - control 이 변수가 선언된 block 내부에 있는 동안

  ```
  public class scope_and_lifetime {
      int num1, num2;          //Instance Variables
      static int result;       //Class Variable
      int add(int a, int b) {  //Local Variables
          num1 = a;
          num2 = b;
          return a+b;
      }
  }
  ```

## 타입 변환과 캐스팅 그리고 타입 프로모션

### Type casting?

- 타입캐스팅이란 크기가 더 큰 자료형을 크기가 더 작은 자료형에 대입하는 것을 의미한다. 예를들어 int(4byte)타입의 데이터를 byte(1byte) 타입에 대입하는 경우가 있을 수 있겠다. 물론, 데이터 크기가 더 크기 때문에 변환과정에서 데이터의 손실이나 변형이 올 수도 있다.

  ```
  int a = 10;     
  byte b = (byte)a;
  System.out.println(b); //  -> 10
  // byte 는 -256~255까지 표현할 수 있음으로 타입캐스팅을 했음에도 데이터 변형이나 손실은 오지 않았다) 
	
  int a = 10000;     
  byte b = (byte)a;
  System.out.println(b); //  -> 16
  // 표현범위를 벗어나는 값을 강제로 타입캐스팅해 데이터에 변형이 생겼다) 
  ```

### Type promotion?

- 타입캐스팅과 반대로 크기가 더 작은 자료형을 더 큰 자료형에 대입하는 것을 의미한다. 예를들어 byte(1byte)타입의 데이터를 int(4byte) 타입에 대입하는 경우이다. 그리고 이 경우에는 데이터 손실이나, 변형이 오지 않음으로 캐스팅할 때 처럼 명시적으로 적지 않아도 자동으로 변환이 가능하다.

  ```
  byte a = 10;
  int b = a;
  System.out.println(b); //  -> 10
  ```

위와 같은 타입변환은 프리미티브 타입뿐만 아니라 레퍼런스 타입에서도 가능하다. 그런데 레퍼런스 타입에도 크기라는 개념으로 캐스팅과 프로모션을 구분지어 생각하면 햇갈릴 수 있다. 부모클래스로의 타입변환은 자동적으로 가능하지만 자식클래스로의 타입변환은 타입캐스팅이 필요하다. 조금만 생각해보면 당연한 이유인데, 자식클래스는 부모클래스의 필드나 메소드를 물려받음으로 자식클래스타입의 객체를 부모클래스타입으로 바꾼다고 해서 데이터의 손실이나 변형이 일어나진 않기 때문이다.

## 1차 및 2차 배열 선언하기

### 배열이란? (Array)

- 배열은 원시타입이나, 참조타입으로 구성된 특별한 객체 이다. 
- 배열에 담기는 값들은 배열의 타입에 의해서 결정이 되고, 배열의 넘버링, 즉 사이즈는 0부터 시작되고, 배열에 들어가는 데이터로 사이즈가 결정된다. (배열에 들어가는 원소의 수가, 배열의 수) 또한 배열을 생성할 때, 명시적으로 배열의 사이즈를 정해줄 수 있다.
- 배열의 원소로 들어가는 타입은 대부분 자바에서 유효한 (valid 한) 타입으로 들어가고, 배열의 타입도 포함 가능하다. Java 는 배열안에 배열을 만드는 ‘다차원’의 배열의 종류도 지원한다. 

### 배열 타입(Array Type)

- 배열 유형은 자바 클래스와 마찬가지로 참조(Reference) 타입이다. 그래서  배열은 클래스의 인스턴스와 마찬가지로 객체이다. 클래스랑 다르게, 배열의 타입은 굳이 정의할 필요없이, 간단하게 원소 타입 뒤에 대괄호 ‘[ ]’를 사용한다.

  ```
  int i;            // 원시 타입
  int[] ints;       // int 배열 타입
  int[][] twoDInts; 
  String[] feilds;
  ```

### 배열 타입은 클래스가 아니다.

- 배열의 인스턴스들은 Obejcts(객체)이다. 배열은 ‘java.lang.Objects’ 에 상속 받는다. 그래서 배열은 ‘Cloneable interface’ (객체 자신의 메모리를 복사하는 Object의 인터페이스)를 implement 받는다. 그리고 CloneNotSupportedException 을 따로 throw로 예외처리를 해주지않고도 완벽하게 보장하는 clone() 메소드를 오버라이딩 하나다.

### 배열의 선언

  ```
  String[] fields = new String[5];       // 5개의 원소를 가질 수 있는 배열 선언
  int[] ints = new int[10];              // 10개의 원소를 가질 수 있는 배열 선언
  char[][] towDFields = new char[5][10]; // char[10] 배열 원소를 5개 가지는 배열 선언
  ```

### 초기값

 타입 | 초기값 
:---:|:----:
int | 0
float, double | 0.0
char | /u0000
boolean | false
Reference Type | null

### 값 초기화

- 배열을 초기화 하기 위해서는 원소 값이랑 일치하는 선에서 대괄호 [ ] 뒤에 중괄호(curly braces) { } 를 넣어서 값들을 집어 넣으면 가능하게 된다. 

  ```
  String[] greetings = new String[]{"Hello", "Hi", "안녕"};
  ```

## 타입 추론과 var

### 타입추론?

- 타입추론, var 는 Java10 부터 지원한다.
- 타입 추론은 Java 자체적으로 어떤 타입인지 예측하고, 그것을 사용하는 것을 말한다. 마치 자바스크립트 또는 파이썬같은 동적 타입 언어와 비슷한 형태이다.
- Java8에서 타입 추론(Type Interface)은 대표적으로 제네릭에서 사용된다.

### var 를 활용할만한 상황

#### foreach

- for(Person person : personList) 문에서 변수 선언할 때 var로 쓰면 편하다.
  
  ```
  for (var person : personList) {
      // ...
  }
  ```

- 이렇게 작성하면 IDE 에서는 var 키워드를 Person 클래스로 인식할 수 있는 기회가 주어지게 되고, 컴파일할 때도 var 키워드를 Person 으로 변환하게 될 것이다. 타이핑이 정말 간결해진다. Object 타입으로 미리 단정지을 필요도 없다.

#### 람다 (Java 11)

- LTS인 자바 11은 람다 인자에도 var를 넣게 해주는데, 이게 왜 중요하냐면, 일반 람다의 경우 파라미터 어노테이션을 못 집어넣는다. 만약 어노테이션을 넣고 싶으면 따로 메소드로 빼던가, 익명 클래스로 정의해야 했었다.
하지만 자바 8부터 람다 인자는 타입 추론의 기초였던 게, 자바 11부터는 타입 추론의 유연성을 추가했다.

  ```
  Consumer<Person> personConsumer = (@Nonnull var person) -> {
    // @Nonnull 어노테이션에 의해 person에 널체크부터 하겠지?
  }
  ```

- 어노테이션 프로세싱과 어노테이션의 장점만 생각해도 이건 유연성이 증대되는 효과가 있다.

#### 익명 클래스

- 익명 클래스에서 var를 사용하면 편하다.
 
  ```
  var supply = new Supplier<String>() {
    @Override
    public String get() {
        // ...
    }
  }
  ```

- 익명 클래스는 정의가 거대하고, 유추가 쉽다. 그리고 선언한 다음에 변수가 바뀌는 일도 없다.

  ```
  var supply = () => {
    // ...
  };
  ```

- 람다에서는 사용 불가능하다. 왜냐하면 람다를 등록할 인터페이스가 모호하기 때문이다. 같은 람다라도 예를 들어 Supplier<T> 클래스가 있고 Callable<T> 클래스가 있다. 물론 미묘한 차이점이라면 throws Exception 유무지만, 만약 Supplier<T> 와 같은 람다를 가진 인터페이스가 있다면, 타입을 유추할 수 없기때문에 컴파일 오류가 난다.

