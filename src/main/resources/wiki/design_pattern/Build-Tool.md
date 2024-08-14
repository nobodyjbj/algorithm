# Build Tool

우리는 IDE활용하여 프로젝트를 생성한다.  
Maven, Gradle 프로젝트를 생성하면 기본적으로 빌드툴이 세팅되어 프로젝트가 생성되는데 사용하다 보면 기계적으로 clean, build, compile 등의 행위를 하게 된다. 자동화의 장점이자 아쉬운점은 내가 굳이 내부의 시스템을 알지 않아도 사용이 가능하다는 것이다. 하지만 개발자인 나는 빌드툴이 어떤 역할을 하고 있고 Lifecycle(clean, build, compile 등의 행위)을 클릭하면 어떤 동작을 하는지 알아본다.

## 우선, 컴파일 이란?

· [JVM](https://github.com/nobodyjbj/algorithm/wiki/JVM) 을 참고!

## 빌드(Build) 란?

build(짓다)라는 의미로 소스코드를 실행할 수 있는 소프트웨어로 만드는 것을 말한다.
소스 코드 컴파일, 테스트, 정적분석 등을 하여 실행가능한 소프트웨어로 만들어 준다.

## 빌드툴(Build Tool) 이란?

소스코드에서 소프트웨어 생성을 자동화 하기 위한 프로그램이다.  
빌드 툴의 역할은 ~

- 종속성 다운로드(외부 라이브러리를 자동으로 다운로드 및 업데이트)
- 소스코드를 바이너리 코드로 컴파일
- 바이너리 코드를 패키징
- 테스트 실행
- 배포파일 생성

## Lifecycle 이란?

빌드 툴에서 미리 정해져 있는 빌드 순서를 **Lifecycle**이라고 한다.  
이러한 순서들이 각각 어떤 의미를 가지고 있는지 현재 Java진영에서 가장 많이 사용하고 있는 Maven과 Gradle의 Lifecycle을 정리한다.  

### 수행 단계(Phase)와 명령어(Command)

#### [Maven](https://maven.apache.org/) 

![image](https://user-images.githubusercontent.com/21189169/167572478-05b6e67a-05f2-4eab-993a-534f5d2e2c0c.png)

##### 수행 단계(Phase)

1. Validate : 프로젝트 구조가 올바른지 확인한다. 예를 들어 모든 종속성(라이브러리)가 잘 다운로드 되었고 적용하는데 문제가 없는지 확인하는 절차이다.
2. Compile : 소스 코드를 컴파일하고 .java 파일을 .class파일로 변한하며 /class 폴더에 저장한다.
3. Test : 프로젝트 내의 단위테스트를 진행한다.
4. Package : 컴파일된 코드를 JAR or WAR과 같이 배포가능한 형식으로 패키징한다.
5. Integration test : 프로젝트에 대한 통합테스트를 싱행한다.
6. Verify : 프로젝트가 유효하고 품질 표준을 충족하는지 확인하기 위한 검사를 실행한다.
7. Install : 패키지된 코드를 로컬 Maven 저장소에 설치한다.
8. Deploy : 패기지된 코드를 원격 Maven 저장소에 복사하여 공유한다.

Maven은 순차적으로 명령을 실행한다. 여기서 n단계를 실행하면 1단계부터 n-1단계까지의 모든 단계가 실행된다.

명령어(Command)

- mvn clean : 프로젝트를 정리하고 이전 빌드에서 생성된 모든 파일을 제거한다.
- mvn compile: 프로젝트의 소스 코드를 컴파일한다.
- mvn test-compile: 테스트 코드를 컴파일한다.
- mvn test: 프로젝트에 대한 테스트를 한다.
- mvn package: 프로젝트에 대한 JAR 또는 WAR 파일을 생성하여 배포 가능한 형식으로 변환한다.
- mvn install: 패키지된 JAR/WAR 파일을 로컬 리포지토리에 배포한다.
- mvn deploy: 프로젝트를 컴파일, 테스트 실행 및 빌드한 후 패키지된 JAR/WAR 파일을 원격 저장소에 복사한다.

일반적으로 위의 명령어 중에 하나를 실행할 때 이전 빌드에서 생성된 대상 폴더가 제거되도록 mvn clean 단계가 추가된다.

### [Gradle](https://gradle.org/)

####

####

####
