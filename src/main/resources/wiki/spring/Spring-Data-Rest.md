## Spring Data Rest

REST API 를 쉽게 만드는 기술

### 특징

* **Repository 인터페이스 정의**만으로 **REST API** 제공
* Query Method : 메소드 선언으로 검색 API 지원
* Projection : 데이터 표현 방식을 다양하게 정의/표현 가능
* [HATEOAS](https://github.com/nobodyjbj/Algorithm/wiki/HATEOAS) : MetaData 표현 (Model, Link, Resource)


### Spring Data
![booting-spring-data-rest-13-638](https://user-images.githubusercontent.com/21189169/93303163-0ab86300-f836-11ea-8adb-ce57932f2e58.jpg)

### Spring Data Rest
![booting-spring-data-rest-15-638](https://user-images.githubusercontent.com/21189169/93303378-51a65880-f836-11ea-911a-8027daa5fd11.jpg)

### 예시

```java
@RepositoryRestResource
interface BoardRepository
      extends CrudRepository<Board, Long> {} 
```

* @RepositoryRestResource 는 REST API를 사용하겠다는 어노테이션
* Board, Long -> /boards/1
* CrudRepository 라는 메서드 명이 API가 된다.
* 이렇게 짧은 코드로 POST, PUT, PATCH, GET, DELETE 가 가능하게 된다.

조회를 할 수 있는 API 추가
```java
@RepositoryRestResource
interface BoardRepository
      extends CrudRepository<Board, Long> {

      @RestResource(path="status-title")
      List<Board> findByContentsTitleStartsWith(
                      @Param("title") String title);
}
```

* @RestResource 는 메서드를 REST API 리소스로 추가한다.
* /boards/search/starts-title?title=h 로 요청 할 수 있다.

### 장점

* 빠르게 REST API 개발 가능
* 확장이 쉽다.
* Spring Data의 기능을 사용하는 경우 프로젝트에 바로 설정 가능하다.

### 생각해야 할 점

* HATEOS 를 이해하고 사용해야 한다.
* ORM 대해 이해하고 사용해야 한다.

### 문제점

* 사용하기까지 학습해야 할 것들이 많다.
* spring에 종속적이다.
* service단의 존재가 애매하다.