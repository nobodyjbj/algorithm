## Spring Transaction

Spring Data Jpa가 제공하는 Repository의 모든 메소드에는 기본적은 @Transactional이 적용되어 있다.

### @Transactional

* Runtime Exception, Error 발생 했을때 Rollback
* 기본 값은 readOnly가 true
* 메서드에서 가장 가까운 설정이 우선이다.
* 메서드에 설정이 되어 있지 않으면 클래스에 적용 되어 있는 값이 기본이다.

### readOnly

* 해당 트랜젝션이 readOnly인지 아닌지 나타내는 값이다.
* 데이터를 변경하는 오퍼레이션이 없으면 true값을 주는 것이 좋다.

### Isolation

여러개의 트랜젝션이 동시에 접근했을때 어떻게 처리 할 것인지에 대한 설정이다. 설정 값에 따라 동작이 달라진다.

* DEFAULT : 기본값  
* READ_UNCOMMITTED 
  * 각 트랜잭션에서의 변경 내용이 COMMIT이나 ROLLBACK 여부에 상관 없이 다른 트랜잭션에서 값을 읽을 수 있다.
  * 정합성에 문제가 많은 격리 수준이기 때문에 사용하지 않는 것을 권장한다.
  * DIRTY READ현상 발생 : 트랜잭션이 작업이 완료되지 않았는데도 다른 트랜잭션에서 볼 수 있게 되는 현상
* READ_COMMITTED
  * RDB에서 대부분 기본적으로 사용되고 있는 격리 수준이다.
  * Dirty Read와 같은 현상은 발생하지 않는다.
  * 실제 테이블 값을 가져오는 것이 아니라 Undo 영역에 백업된 레코드에서 값을 가져온다.  
* REPEATABLE_READ
  * MySQL에서는 트랜잭션마다 트랜잭션 ID를 부여하여 트랜잭션 ID보다 작은 트랜잭션 번호에서 변경한 것만 읽게 된다.
  * Undo 공간에 백업해두고 실제 레코드 값을 변경한다.
  * 백업된 데이터는 불필요하다고 판단하는 시점에 주기적으로 삭제한다.
  * Undo에 백업된 레코드가 많아지면 MySQL 서버의 처리 성능이 떨어질 수 있다.
  * 이러한 변경방식은 MVCC(Multi Version Concurrency Control)라고 부른다.
  * PHANTOM READ :다른 트랜잭션에서 수행한 변경 작업에 의해 레코드가 보였다가 안 보였다가 하는 현상, 이를 방지하기 위해서는 쓰기 잠금을 걸어야 한다.
* SERIALIZABLE 
  * 가장 단순한 격리 수준이지만 가장 엄격한 격리 수준
  * 성능 측면에서는 동시 처리성능이 가장 낮다.
  * SERIALIZABLE에서는 PHANTOM READ가 발생하지 않는다. 데이터베이스에서 거의 사용되지 않는다.

### Propagation

트랜젝션을 어떻게 전파시킬 것인지 설정하는 값이다. 기존의 트랜젝션을 이어서 설정 될 것인지 새로운 설정을 적용할 것인지 설정할 수 있다.

* REQUIRED : 부모 트랜잭션 내에서 실행하며 부모 트랜잭션이 없을 경우 새로운 트랜잭션을 생성
* REQUIRES_NEW : 부모 트랜잭션을 무시하고 무조건 새로운 트랜잭션이 생성
* SUPPORT : 부모 트랜잭션 내에서 실행하며 부모 트랜잭션이 없을 경우 nontransactionally로 실행
* MANDATORY : 부모 트랜잭션 내에서 실행되며 부모 트랜잭션이 없을 경우 예외가 발생
* NOT_SUPPORT : nontransactionally로 실행하며 부모 트랜잭션 내에서 실행될 경우 일시 정지
* NEVER : nontransactionally로 실행되며 부모 트랜잭션이 존재한다면 예외가 발생
* NESTED : 해당 메서드가 부모 트랜잭션에서 진행될 경우 별개로 커밋되거나 롤백될 수 있음. 둘러싼 트랜잭션이 없을 경우 REQUIRED와 동일하게 작동

