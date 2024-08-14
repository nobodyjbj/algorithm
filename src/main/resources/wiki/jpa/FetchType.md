## FetchType ?

- FetchType은 JPA가 하나의 Entity를 조회할 때, 연관관계에 있는 객체들을 어떻게 가져올 것인지를 나타내는 설정값이다.
- FetchType의 종류로는 Eager와 Lazy 두가지 전략이 있다.
  - Eager : 연관 관계에 있는 Entity 모두를 가져온다.
  - Lazy : 연관 관계에 있는 Entity를 가져오지 않고, getter로 접근할때 가져온다.

### 지연로딩
- 연관관계에 있는 Entity를 바로 조회하지 않고, getter로 실제 연관관계에 있는 Entity를 호출할 때 조회하는 방식

### 즉시 로딩
- 연관관계에 있는 Entity 모두를 한 번에 조회하는 방식

### JPQL이란 ?
- JPQL이란 플랫폼에 독립적인 객체지향 쿼리 언어
- 자바 코드에서 데이터베이스를 조회할 때 특정 SQL이나 저장 엔진에 종속되지 않게 도와준다.

### N+1 문제 ?
- JPQL이라는 객체지향 쿼리 언어가 실행되면서 SQL을 작성하는데, 이 과정에서 N+1쿼리 문제가 발생한다.
- QueryBuilder or QueryDSL을 사요하면 극복 가능하다.

#### 자주 발생하는 경우
- 두 개의 Entity가 1:N관계를 가지며 JPQL로 객체를 조회할때
  - EAGER 전략으로 데이터를 가져오는 경우
  - LAZY 전략으로 데이터를 가져온 이후에 가져온 데이터에서 하위 Entity를 다시 조회하는 경우

### FetchType은 실무에서 Lazy를 권장!
- 즉시 로딩을 사용하면 예상치 못한 SQL을 볼 수 있다.
  - 다른 개발자가 A Entity를 조회할때, D Entity가 조회될 것이라고는 생각하지 못한다.
- 즉시 로딩은 JPQL 사용시 N+1 문제를 유발한다.
  - JPQL롤 'select * from TABLE_A' 를 조회하면 연관관계에 있는 TABLE_D를 N+1형태로 조회한다.

### 연관관계별 fetch 기본 옵션
- @ManyToOne : EAGER
- @OneToOne : EAGER
- @ManyToMany : LAZY
- @OneToMany : LAZY

