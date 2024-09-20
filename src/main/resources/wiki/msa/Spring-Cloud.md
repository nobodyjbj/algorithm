## Spring Cloud

독립적으로 서비스를 개발하기 위한 마이크로 서비스 아키텍처를 위한 프레임워크이다.
스프링 클라우드는 환경 설정 관리, 서비스 검색, 회복성 처리, 라우팅, 프록시 등등 빠르게 어플리케이션을 개발하는데 목적이 있다.  
Spring Cloud 공식 홈페이지 : https://spring.io/projects/spring-cloud

### 스프링 클라우드 메인 프로젝트
- **Spring Cloud Config**
- **Spring cloud Netflix**
- Spring Cloud Bus
- Spring Cloud Cloudfoundry
- Spring Cloud Open Service Broker
- Spring Cloud Cluster
- Spring Cloud Consul
- **Spring Cloud Security**
- **Spring Cloud Sleuth**
- Spring Cloud Data Flow
- Spring Cloud Stream
- Spring Cloud Stream App Starters
- Spring Cloud Task
- Spring Cloud Task App Starters
- Spring Cloud Zookeeper
- Spring Cloud Connectors
- **Spring Cloud Starters**
- Spring Cloud CLI
- Spring Cloud Contract
- **Spring Cloud Gateway**
- **Spring Cloud OpenFeign**
- Spring Cloud Pipelines
- Spring Cloud Function

### Spring Cloud 개발에 필요한 구성

- Centralized configuration management
  - 환경 설정 관리를 위함
  - Spring Cloud Config Server
- Location transparency
  - 서비스의 등록과 위치정보 확인, 검색등의 서비스를 위함
  - Naming Server(Eureka)
- Load Distribution(Load Balancing)
  - 서버에 들어온 요청 정보를 분산하기 위한 용도로 로드밸런싱, 게이트웨이 기능을 위함
  - Ribbon(Client Side), Spring Cloud Gateway
- Easier REST Clients
  - 각각의 마이크로 서비스들이 통신하기 위함
  - Feign Client
- Visibility and monitoring
  - 시각화와 모니터링을 위함
  - Zipkin Distributed Tracing, Netflix API Gateway
- Fault Tolerance
  - 장애 발생경우 복구하기 위한 회복석 패턴이라는 것을 위함
  - Hystrix 