## Zipkin

### Zipkin?
![img_12.png](img_12.png)
- http://zipkin.io
- 트위터에서 사용하는 분산 환경의 Timing 데이터 수집, 추적 시스템(Open Source)
- Google Drapper 에서 발전하였으며, 분산환경에서의 시스템 병목 현상 파악
- 다운로드 & 실행
    ```shell
    $ > curl -sSl https://zipkin.io/quickstart.sh | bash -s
    $ > java -jar zipkin.jar
    ```
  -  http://127.0.0.1:9411/ 접속 

### 주요기능 

- 분산 추적: 서비스 호출에 대한 타임라인을 생성하여 각 서비스가 요청을 처리하는데 걸린 시간을 추적.
- 병목현상 파악: 어느 서비스에서 요청 처리 시간이 오래 걸리는지, 혹은 실패한 서비스가 있는지 확인.
- 추적 메타데이터 관리: 요청의 세부사항 (trace ID, span ID, 시작 및 종료 시간 등)을 기록하여 상세한 분석이 가능.
- 모니터링 및 문제 해결: 시스템 성능을 실시간으로 모니터링하고, 발생한 문제의 원인을 빠르게 파악하는 데 도움.

### 구성

- Collector, Query Service, Database WebUI
- Span (스팬)
    - 하나의 요청에 사용되는 작업의 단위
    - 64 bit unique ID
    - Trace 내에서 하나의 서비스 호출을 나타냄, 시작 및 종료 시간, 호출된 서비스 및 결과 등을 포함
- Trace (추적)
  - 트리 구조로 이뤄진 Span 셋
  - 하나의 요청에 대한 같은 Trace ID 발급
  - 하나의 트랜잭션이나 요청 흐름을 나타내며, 각 서비스 간의 호출을 포함
- Annotations (주석): 특정 시점에 발생한 이벤트를 기록.
- Service Names (서비스 이름): 호출이 발생한 서비스의 이름.

### Spring Cloud Sleuth

- 어플리캐이션을 Zipkin과 연동, 로그파일 또는 스트리밍 데이터를 Zipkin에 전달하는 역할
- 요청 값에 따른 Trace ID, Span ID 부여
- Trace 와 Span Ids 를 로그에 추가 가능
  - servlet filter
  - feign client
  - scheduled actions
  - message channels

### SpringBoot3 변경사항

- Micrometer Tracing: Spring Cloud Sleuth는 더 이상 최신 버전에서 사용되지 않고, Micrometer Tracing을 통해 Zipkin과 Brave를 사용하여 추적 관리
- Sampling: 요청 추적의 샘플링 비율을 management.tracing.sampling.probability 로 설정
- Zipkin 설정: Zipkin에 요청을 보낼 서버의 엔드포인트 URL을 management.zipkin.endpoint로 지정, 기본적으로 Zipkin은 localhost:9411에서 실행
- build.gradle
  ```groovy
  implementation 'io.micrometer:micrometer-observation'
  implementation 'io.micrometer:micrometer-tracing-bridge-brave'
  implementation 'io.zipkin.brave:brave-instrumentation-spring-web'
  implementation 'io.zipkin.reporter2:zipkin-reporter-brave'
  ```
- yml  
  ```yml
  #example
  management:
    tracing:
      sampling:
        probability: 1.0  # 모든 트래픽을 추적 (0.1로 설정하면 10%만 추적)
    zipkin:
      enabled: true
      endpoint: http://localhost:9411/api/v2/spans  # Zipkin 서버 URL
  ```