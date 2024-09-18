## Spring Cloud Communication

### Communication Types

- Synchronous HTTP Communication
  - 동기방식, 순차적으로 하나의 작업이 모두 완료되어야만 다음 작업을 진행 가능
  - 대표적으로, 라운드로빈
- Asynchronous communication over AMQP
  - 순차적으로 데이터를 동기화하는 것이 아니라 일단 연결된 서비스들에 메세지를 전달해줄 수 있는 방식

### Feign Web Service Client

- REST Call 을 추상화 한 Spring Cloud Netflix 라이브러리
- 사용방법
  - 호출하려는 HTTP Endpoint에 대한 Interface를 생성
  - @FeignClient 선언
- Load balanced 지원
