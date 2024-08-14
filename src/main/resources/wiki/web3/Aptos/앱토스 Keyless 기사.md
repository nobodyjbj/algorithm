
### 심리스한 사용자 경험을 위해 Keyless Accounts를 제안

원문 기사 : https://xangle.io/research/detail/2024
Aptos keyles DOC : https://aptos.dev/guides/keyless-accounts/

![](https://resource.xangle.io/images/content/common/-3afff340-db78-4f31-bb5c-cf12c74f57e1.jpg)

출처: Github(Aptos Foundation)

블록체인에서 사용성을 저해하는 주된 요소는 개인 키 기반의 계정 관리다. 계정 보호의 유일한 방법은 개인 키를 보호하는 것으로 도난 및 분실의 모든 책임을 사용자가 떠안게 된다. 이 문제를 해결하기 위해, Web3Auth와 같이 소셜 로그인을 활용한 신원 인증으로 개인 키를 관리하는 커스터디 서비스가 존재한다. 이러한 서비스는 사용성 면에서 큰 이점이 있지만, 중앙화된 주체를 신뢰해야 한다는 문제가 있다. Aptos는 이 문제를 극복하기 위해 온체인 상에서 keyless 계정을 생성하는 AIP-61을 제안했다. 이 방식은 니모닉이나 개인키 대신 소셜 서비스 계정 정보를 사용하여 계정을 생성하도록 설계되었다. 소셜 계정을 이용해 계정을 만들 경우 발생할 수 있는 프라이버시 문제를 해결하기 위해, Aptos는 사용자의 이메일 주소를 온체인 상에서 밸리데이터와 유저를 포함한 누구에게도 제공하지 않으며, 사용자의 블록체인 주소와 관련된 트랜잭션 정보를 소셜 로그인 서비스 제공자에게도 공개하지 않는다고 제안한다. Keyless account는 Web2 계정을 Web3에서도 사용할 수 있도록 지원하여 사용자 경험을 크게 향상시킬 것으로 예상된다. 현재 구글 계정을 통한 로그인을 지원하고 있으며, 추후 OpenID Connect(OIDC) 표준을 지원하여 다양한 SNS를 통한 계정 생성을 지원할 예정이다.

 [[AIP-61-Keyless account]] : 니모닉이나 개인키 대신 소셜 서비스 계정 정보를 사용하여 계정을 생성하도록 설계
