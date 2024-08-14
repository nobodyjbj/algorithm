## HATEOAS ( Hypermedia As The Engine Of Application State ) 

참고 블로그 : [REST의 영광을 향한 단계들](https://jinson.tistory.com/190)

- Rest Api는 '클라이언트가 어떤 형식의 데이터를 서버에 요청하면 서버에서 응답 값을 [지정된 형식](https://github.com/nobodyjbj/Algorithm/wiki/RestApi-Intro)에 맞춰서 보내주는 것' 이다.

- Hateoas는 Hypermedia As The Engine Of Application State의 약자로 Rest 아키텍처의 한 구성요소이다. 
- Hateoas의 역할은 HTTP응답에 들어갈 Resouce와 Links를 제공하는 것이다.

![image](https://user-images.githubusercontent.com/21189169/123895211-6e151b00-d99a-11eb-8ca7-cdca07eb3b3e.png)

- Links에 들어가는 정보는 현재 Link의 Resource와 관계 Link 정보인 REL정보와 자신의 Link정보  Self가 들어가 있다.

REST API 응답 데이터
```json
{
  "name": "jun"
}
```

HATEOAS 응답 데이터
```json
{
  _embedded: {
    users: [
      {
        "name": "jun",
        "links": {
          {
            "rel": "self",
            "href": "http://localhost:8080/users/1"
          },
          {
            "rel": "delete",
            "href": "http://localhost:8080/user/delete"
          },
          {
            "rel": "update",
            "href": "http://localhost:8080/users/update"
          }
       }
    ]
},
links: {
  self: {
    "href": "http://localhost:8080/users
  }
}
```
