## Spring Data Jpa ( 인터페이스 분석 )

####Spring Data Jpa 를 사용할 때 형모양

```java
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
```

#### 궁금한 점,

* SmapleRepository, JpaRepository 구현체가 없다.
* @Repository 어노테이션이 없이 JpaRepository만 상속받아도 Bean으로 등록된다.

#### 어떻게 동작하는가?

* com.sun.proxy.$Proxy.xx$ : 로딩 시점에서 Jpa관련 인터페이스가 있다면 Spring Data Jpa가 구현체를 만들어 injection을 해주게 된다.
* SpringBoot 가 아니라면 @EnableJpaRepositories 가 있다. 열어보면,   
  @Import(JpaRepositoriesRegistrar.class)가 있고 JpaRepository 를 Bean으로 등록해주는 역할을 한다.  
  JpaRepositoriesRegistrar의 최상위를 보게되면 ImportBeanDefinitionRegistrar 가 있다.  BeanDefinition 을 정의할 수 있는 특수 형태의 interface 이며, Bean 을 프로그래밍을 통해 등록을 할 수 있게 해준다. SpringFramework 의 기능이다.  
  
예제 코드를 보면 쉽게 이해 할 수 있다.

```java
public class SampleRegistrar implements ImportBeanDefinitionRegistrar {
  @Override
  public void registrarBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinition beanDefinition) {
    GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    beanDefinition.setBeanClass(Smaple.class);
    beanDefinition.getPropertyValues().add("name", "example");
    
    registry.registerBeanDefinition("sample", beanDefinition);
  }
}
```

@Import(SampleRegistrar.class) 로 포함시켜주면 Sample 클래스를 사용할 때 annotation 을 이용해서 Bean 을 주입하지 않아도, 인터페이스만 상속받아도 Bean 으로 주입을 받을 수 있다.

