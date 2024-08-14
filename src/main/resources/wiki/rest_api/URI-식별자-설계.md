## URI 식별자 설계

#### 참고 문헌 : REST API 디자인 규칙

### URI

REST API는 리소스를 나타낼 때 URI를 사용한다.

REST API설계자는 URI를 만들 때부터 REST API 리소스 모델을 클라이언트에게 전달할 수 있어야 한다.

> 식별자로 할 수 있는 유일한 일은 대상을 나타내는 것이다. 역참조를 할 때가 아니라면 다른 정보를 얻기 위해서 URI의 내용을 들여다 보지 말아야 한다. - 팀 버너스리 -

### URI 형태 (규칙)

`URI = scheme “ :// ” authority “ / ” path [“ ? ” query] [“ # ” fragment ]`

* 슬래시 구분자(/)는 계층 관계를 나타내는데 사용한다.
* URI 마지막 문자로 슬래스(/)를 포함하지 않는다.(마지막 /가 포함된 것과 포함되지 않은 것 두개 모두 유일한 식별자로 작용하기 때문에 명확한 표시가 필요하다.)
* 하이픈(-)은 URI 가독성을 높이는데 사용한다.
* 밑줄(_)은 URI에 사용하지 않는다. (밑줄과 혼동될 염려가 있다.)
* URI 경로에는 소무자가 적합하다.(RFC3986은 URI 스키마와 호스트를 제외하고 대소문자를 구별하도록 규정하기 때문)
* 파일 확장자는 URI에 포함시키지 않는다. (REST API는 파일을 표현하는 용도가 아니다.)

### URI 권한 설계

권한 규칙

* API를 제공하는 도메인은 일관성 있게 사용해야 한다.
  - http://api.example.restapi.org 와 같이 api라는 서브 도메인을 만들어야 한다.

* 개발자에게 제공되는 포탈의 경우 도메인 이름은 일관성 있게 만들어야 한다.
  - http://developer.example.restapi.org 와 같이 developer라는 이름의 서브 도메인을 만들어야 한다.

### 리소스 모델링

`http://api.books.restapi.org/kinds/it/restapi`

이 URI 디자인은 다음과 같은 자체 리소스 주소를 가진 URI가 있다는 것을 뜻한다.

http://api.books.restapi.org/kinds/it  
http://api.books.restapi.org/kinds  
http://api.books.restapi.org  

리소스 모델링은 API의 주요 개념을 확실하게 잡는 훈련과 같다. 이 과정은 마치 관계형 데이터베이스 스키마를 정의하기 위한 데이터 모델링이나, 객체 지향 시스템에서의 클래스 모델링과 유사하다. 고민이 많이 필요한 부분이고 해당 도메인에 대한 이해도가 높으면 모델링 하는데 도움이 많이 될 것이다. 

### 리소스 원형

`http://api.soccer.restapi.org/leagues(컬렉션)/seattle(도큐먼트)/teams(컬렉션)/trebuchet(도큐먼트)/players(컬렉션)/mike(도큐먼트)`

정확한 서버와 클라이언트의 통신을 위해서는 일관된 리소스를 설계하고 고민해야 한다.

#### 도큐먼트

도큐먼트 리소스는 단일 개념이다. 자식 리소스도 가질 수 있고, 다른 리소스 원형들의 기반 원형이 된다.

`
http://api.soccer.restapi.org/leagues/seattle
http://api.soccer.restapi.org/leagues/seattle/teams/trebuchet http://api.soccer.restapi.org/leagues/seattle/teams/trebuchet/players/mike
`

#### 컬렉션

컬렉션 리소스는 복수 개념이다. 서버에서 관리하는 리소스이다. 디렉터리라고 한다. 새로운 리소스를 제안해서 컬렉션에 포함 가능하다. 

`http://api.soccer.restapi.org/leagues    
http://api.soccer.restapi.org/leagues/seattle/teams
http://api.soccer.restapi.org/leagues/seattle/teams/trebuchet/players
`

#### 스토어

스토어 리소스는 클라이언트에서 관리하는 리소스 저장소다. API클라이언트가 리소스를 넣거나 빼는 것 , 지우는 것에 관여한다.

`PUT /users/1234/favorites/alonso`

#### 컨트롤러

컨트롤러 리소스는 절차적인 개념을 모델화한 것이다. 

`
POST /alerts/245743/resend
`

### URI 경로 디자인

슬래시(/)로 구분된 각 URI 경로 부분은 다양한 형태로 설계 가능하다. 

`{collection-c} / {store-s} / {document-d}`

URI 경로를 디자인할 수 있는 규칙들이 있다.

* 도큐먼트 이름으로는 단수 명사를 사용해야 한다.
* 컬렉션 이름으로는 복수 명사를 사용해야 한다.
* 스토어 이름으로는 복수 명사를 사용해야 한다.
* 컨트롤러 이름으로는 동사나 동사구를 사용해야 한다.
* 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.
* CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.

### URI Query 디자인

`URI = scheme "://" authority "/" path ["?" query]["#" fragment]`

URI 구성 요소인 쿼리는 유일한 리소스를 식별하는데 도움을 준다.

`http://api.college.restapi.org/students/morgan/send-sms` -- ①
`http://api.college.restapi.org/students/morgan/send-sms?text=hello` -- ②

① 은 sms 문자를 보내는 컨트롤러 리소스 URI
② 는 'hello' 라는 sms 문자를 보내는 컨트롤러 리소스 URI

* URI 쿼리 부분으로 컬렉션이나 스토어를 필터링할 수 있다.  
`
GET /users 
GET /users?role=admin
`

* URI 쿼리는 컬렉션이나 스토어의 결과를 페이지로 구분하여 나타내는데 사용한다.
`GET /users?pageSize=25&pageStartIndex=50 (50페이지부터 최대 75페이지까지만)`
