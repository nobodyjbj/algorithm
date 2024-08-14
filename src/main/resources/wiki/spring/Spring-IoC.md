## Spring IoC

###  IoC(Inversion Of Conrol)

'제어의 역전' 이라고 해석할 수 있으며, 개발자가 직접 객체간의 의존성을 관리하는 대신 Spring IoC Container 에게 객체의 생성 및 관리를 하도록 위임하기 위한 방법이다.  
이를 통해 개발자는 객체 생성, 라이프 사이클(생명주기), 의존송 주입에 대한 직접적인 처리가 필요 없으며, Spring이 이러한 처리를 대신 수행한다.  

### Spring IoC 개념

#### Bean
* Spring IoC Container가 관리하는 객체를 말한다. 
* 객체는 POJO(Plane Old Java Object)로 정의되며, Spring이 생성 및 관리를 한다.  
* Bean 생성
  * Singleton Resgistry: [Singleton Pattern](https://github.com/nobodyjbj/readme/wiki/Singleton-%E2%80%90-%EC%8B%B1%EA%B8%80%ED%86%A4)의 단점을 보완하기 위해 나온 것이 Spring의 Singleton Registry이다.  
Spring IoC Container가 싱글톤 레지스트리의 역할을 하여 빈을 싱글톤으로 관리한다.  
private 생성자로 객체의 생성을 막는 방법이 아니라 일반 자바 클래스(private, static 등의 처리가 없는 클래스)를 싱글톤으로 활용할 수 있도록 지원한다.  
생성, 관계설정, 사용에 대한 제어권이 Spring IoC Container 에게 있기 때문에 일반 자바 클래스도 싱글톤으로 관리될 수 있다.  
객체지향적 설계와 디자인 패턴 적용이 가능하다.  
  * Singleton 방식을 사용하는 이유?
    * Spring을 사용하는 서비스는 대부분 서버환경이다. 서버는 대부분 수많은 객체를 포함하고 있으며, 이 과정을 요청에 의해 처리하여 사용자에게 서비스를 제공하게 된다.  
      만약, 요청 1개에 5개의 오브젝트가 관여한다고 했을때 Singleton을 사용하지 않는다면, 1000명의 사용자가 해당 기능을 동시에 요청 한다면 5000개의 오브젝트를 만들었다가 다시 제거해야 한다. 이러한 객체의 생성과 제거에 대한 오버헤드를 해결하기 위한 방법으로 싱클톤 방식을 사용한다.

#### BeanFactory
* Bean을 생성하고 의존관계를 설정하는 기능을 담당하는 기본적인 IoC **Container**이자 **클래스**를 말한다.

#### Application Context
* BeanFactory를 구현하고 있고, BeanFactory의 확장된 버전이라고 생각하면 된다.
* Environment: 프로파일을 설정하고 어떤 프로파일을 사용할지 설정할 수 있으며, 소스 설정 및 프로퍼티 값을 가져오게 하는 **클래스**이다.
* MessageSource: 메세지에 대한 국제화를 제공하는 **인터페이스**이다. (18n 참고)

#### Bean Loading
* BeanFactory: Lazy-loading 방식
  * 메서드나 클래스가 Baen 로딩 요청을 받는 시점에 인스턴스를 만들고 로딩하는 방식이다. (Bean을 조회할 때 생성)
* ApplicationContext: Pre-loading 방식
  * 모든 Bean 들과 설정 파일들이 ApplicationContext에 의해 로드 요청이 될 때 인스턴스로 만들어지고 로드된다. (Application이 실행될 때 생)

#### DI(Dependency Injection: 의존성 주입)
* IoC를 구현하는 디자인 패턴이라고 할 수 있다.
* 의존 관계를 외부에서 결정하고 주입하는 것이 **'의존성 주입'** 이다.  
* 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다.  
그러기 위해서는 인터페이스만 의존하고 있어야 한다.  
런타임 시점의 의존관계는 Container 나 Factory(Creator) 같은 제3의 존재가 결정한다.  
의존관계는 사용할 오브젝트에 대한 레퍼런스를 외부에서 제공(주입)해줌으로써 만들어진다.  
* 구현 방법  
  * 생성자를 이용: Constructor Injection
  ```
    public class A {
      private B b;
    
      public A(B b) {
        this.b = b;
      }
    }
  ```
  * SetterMethod를 이용: Setter Injection
  ```
    public class A {
      private B b;
    
      public void setB(B b) {
        this.b = b;
      }
    }
  ```
  * 인터페이스를 이용: Interface Injection
  ```
    public interface BInjection {
      void inject(B b);
    }

    public A implements BInjection {
      private B b;
    
      @Override
      public void inject(B b) {
        this.b = b;
      }
    }
  ```
  * Spring 에서는 어노테이션을 활용하여 Constructor, Setter, Interface 주입할 수 있는 기법들이 있다.  
    대표적으로 @Autowired, @Qualifier, @Inject, @Resource가 있고, final 키워드와 생성자를 쉽게 생성할 수 있는 @RequiredArgsConstructor 은 어노테이션으로 주입할 수 있다.

#### Bean Scope
* Singleton: Default Scope, Spring IoC Container 의 시작과 종료까지 유지되는 가장 넓은 범위를 말한다.
* Property Type: 매 번 새로운 Bean 을 정의해서 사용한다.
* Spring Web
  * request: Web 요청이 들어오고 나갈 때까지 유지되는 Scope 이다.
  * session: Web 세션이 생성되고 종료될 때까지 유지되는 Scope 이다.
  * application: Web 의 ServletContext와 같은 범위로 유지되는 Scope 이다.
  * websocket: Web의 Websocket 과 동일한 생명주기를 갖는 Scope 이다.

#### Component Scanning
Spring 서버를 실행할 때 @Component 어노테이션 이 붙은 모든 클래스를 찾아서 Spring IoC 컨테이너에 객체를 저장하는 액션을 말한다. 이 때 저장된 객체를 Bean이라고 부른다.  
Spring에서는 @Component, @Repository, @Service, @Controller, @RestController, @Configuration, @Bean등의 어노테이션을 자주 사용한다.
실제 Scanning은 BeanFactoryPostProcessor 라는 인터페이스의 구현체인 ConfigurationClassPostProcessor에 의해 Bean 을 등록하게 된다.  
* BeanFactoryPostProcessor는 다른 Bean들이 생성되기 이전에 실행되며, 이 Bean을 수행하여 ComponentScanning을 수행한다.
* @ComponentScan 어노테이션을 활용하여 스캔 범위를 지정할 수도 있다.