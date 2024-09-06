## Spring Cloud Bus

### Spring Cloud Config?

- 분산 시스템의 노드(Micro Service)를 경량 메시지 브로커(RabbitMQ)와 연결
- 상태 및 구성에 대한 변경 사항을 연결된 노드에게 전달(Broadcast)
- AMQP(Advanced Message Queuing Protocol)
  - 메시지 지향 미들웨어를 위한 개방형 표준 응용 계층 프로토콜
  - 메시지 지향, 큐잉, 라우팅(P2P, Publisher-Subscriber), 신뢰성, 보안
  - Erlang(스웨덴 프로그래밍 언어), RabbitMQ 에서 사용
- Kafka 프로젝트
  - Apache Software Foundation 이 Scalar 언어로 개발한 오플ㄴ 소스 메시지 브로커 프로젝트
  - 분산현 스트리밍 플랫폼
  - 대용량의 데이터 처리 가능한 메시징 시스템

### RabbitMQ vs Kafka

#### RabbitMQ
- 메시지 브로커
- 초당 20+ 메시지를 소비자에게 전달
- 메시지 전달 보장, 시스템 간 메시지 전달
- 브로커, 소비자 중심

#### Kafka
- 초당 100k+ 대량 이벤츠 처리
- Pub/Sub, Topic 메시지 전달
- Ack를 기다리지 않고 전달 가능
  - ack(acknowledgment)는 프로듀서가 전송한 메시지가 브로커에 성공적으로 수신되었음을 나타내는 신호
- 생산자 중심
