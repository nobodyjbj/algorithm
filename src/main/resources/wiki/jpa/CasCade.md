## 영속성 전이 (Cascade = CascadeType.xxx)

- 특정 엔티티를 영속 상태로 만들때 연관된 엔티티도 함께 영속 상태로 만들고 싶을때 사용한다.
- Entity의 상태 변화를 전파시키는 옵션이다.
- 영속성이 전이되면 상위 엔티티 저장시 하위 엔티티도 저장하게 된다.
- 기본값으로는 아무 것도 전이시키지 않는다.


### 종류
```
public enum CascadeType{
    ALL, //모두적용
    PERSIST, //영속
    MERGE, //병합
    REMOVE, //삭제
    REPRESH, //리프래쉬
    DETACH //준영속상태로 전환
}
```

### 사용해야 하는 경우
- 하나의 엔티티가 하위 엔티티들과 관계가 있을때 사용한다.
- 라이프 사이클이 같을때 사용한다.

### 사용하면 안되는 경우
- 하나의 하위 엔티티가 두개 이상의 상위 엔티티와 관계를 맺을때 사용하면 안된다.

### **CascadeType.ALL**
- 상위 엔터티에서 하위 엔터티로 모든 작업을 전파

### **CascadeType.PERSIST**
- 하위 엔티티까지 영속성 전달
- Person Entity를 저장하면 Address Entity도 저장

``` 
@Test 
void persist() { 
   Person person = new Person(); 
   Address address = new Address(); 
   address.setPerson(person); 
   person.setAddresses(Arrays.asList(address)); 
   session.persist(person); // persist 동작 수행 
   session.flush(); 
   session.clear(); 
}

// 결과
insert into Persion(...) // 상위 엔티티 저장
insert into Address(...) // 하위 엔티티도 저장
```

### CascadeType.MERGE
- 하위 엔티티까지 병합 작업을 지속
- Address와 Person 엔티티를 조회한 후 업데이트
- entityManager.clear()로 detech 상태로 만든다.
- 비영속 상태의 상위, 하위 Entity들을 변경한 후, 상위 Entity만 entityManager.merge(parent) 하면, 비영속 상태에서 변경사항이 적용되어 상위와 하위 둘다 update쿼리가 날라간다.

### **CasCadeType.REMOVE**
- 하위 엔티티까지 제거 작업을 지속
- 연결된 하위 엔티티까지 엔티티 제거

```
@Test 
void remove() { 
  int personId; 
  Person person = buildPerson("devender"); 
  Address address = buildAddress(person); 
  person.setAddresses(Arrays.asList(address)); 
  session.persist(person); 
  session.flush(); 
  personId = person.getId(); 
  session.clear(); 

  Person savedPersonEntity = session.find(Person.class, personId); 
  session.remove(savedPersonEntity); // remove 동작 수행 
  session.flush(); 

  // 결과
  delete from Address where id=? 
  delete from Person where id=?
}
```

### CascadeType.DETACH
- 엔터티를 영속성 컨텍스트에서 제거한다.
- DETACH 캐스캐이딩 타입은 자식 엔티티도 영속성 컨텍스트에서 제거된다.

### CascadeType.REFRESH
- 데이터베이스로부터 주어진 엔터티를 다시 읽어온다.
- 만약, 데이터베이스에서 영속상태 이후에 인스턴스를 변경하게되면, 나중에 변경을 취소해야된다.
- REFRASH연산자를 사용하면 데이터베이스에서 부모 엔티티가 리프레쉬되면 자식 엔티티 또한 다시 로드된다.

## 정리
- CASCADE 는 부모의 영속성 상태를 자식에게 전달할 때 사용한다.
부모를 저장할 때, 추가된 자식을 저장하거나 부모를 삭제할 때 연관된 자식을 삭제하는 것이다.
따라서 확실하게 자식을 관리하는 엔티티가 부모 하나일때만 사용해야 하며, 라이프 사이클이 같을 때 써야한다는 것이다.
만약에 자식 엔티티를 관리하는 또 다른 엔티티가 있는데 부모 엔티티가 삭제된다고 자식 엔티티도 삭제하면 또 다른 엔티티에서 사용하지 못하는 이슈가 발생하기 때문이다.

## 고아객체 (orphanRemoval = true)
- JPA 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제하는 기능을 제공한다. 이것을 고아(ORPHAN)객체 제거라 한다.
- **반드시 관계가 하나 맺어졌을때 사용해야 한다.**
- **특정 엔티티가 개인 소유일때만 사용해야 한다.**
- @OneToMany, @OneToOne만 가능 : 참조하는 쪽이 하나인 경우만 사용

## 영속성 전이 + 고아객체, 생명주기 (CascadeType.ALL + orphanRemoval=true)
- 스스로 생명주기를 관리하는 엔티티는 em.persist()로 영속화, em.remove()로 제거
  - JPA를 통해서 생명주기 관리
- 두 옵션을 모두 활성화하면 부모 엔티티를 통해서 자식 엔티티의 생명주기를 관리할 수 있다.
  - parent와 달리 child는 생명주기를 부모 엔티티가 관리
  - 생명주기를 부모가 관리하기 때문에 DAO나 Repository가 없어도 된다는 의미




