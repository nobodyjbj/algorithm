## Account
Ethereum의 상태는 어카운트(account)라고 하는 오브젝트들로 구성되어 있으며, 각 어카운트 오브젝트(object)에 20바이트의 주소와, 상태변화(state transaction)를 가지고 있다.

Account는 총 4가지(Nonce, Balance, StorageRoot, CodaHash) 정보로 구성되어 있다.

#### EOA
* Nonce : Account에서 전송된 트랜잭션 수
* Balance : Account가 소유한 잔고 정보로 wei단위로 표시
* StorageRoot : [[MPT(Merkle Patricia Tree)]]의 Root Hash
* CodeHash : 빈 문자열의 Hash 정보

#### CA
* Nonce : Account에서 전송된 Contract 수
* Balance : Account가 소유한 잔고 정보로 wei단위로 표시
* StorageRoot : [[MPT(Merkle Patricia Tree)]]의 Root Hash
* CodeHash : Account에 포함된 이더리움 버츄얼 머신(EVM) Code의 Hash

## EOA (Externally Owned Account)

외부 소유 어카운트로서 개인키에 의해 통제되는 계정정보이다.
* 개인키 정보를 가지고 있다.
* 그러므로 자체적 트렌젝션을 생성할 수 있다.
## CA (Contract Account)

컨트렉트 어카운트로서 컨트랙트 코드에 의해 통제되는 계정정보이다.
* 개인키 정보를 가지고 있지 않다.
* 자체적 트렌젝션을 생성할 수 없고, 타 계정으로 부터 받은 메시지에 대한 응답으로 내부 트랜젝션을 실행할 수 있다.

![image](https://github.com/nobodyjbj/readme/blob/master/src/main/resources/image/account_object1.png)

위이 그림과 같이 외부 소유 계정으로 부터 모든 상태 변환이 시작되며, 외부 소유 계정이 다른 외부 소유 계정에게 이더를 전송하기 위하여 트랜젝션을 생성하거나, 특정 계약을 수행하기 위해 컨트랙트 계정에게 트랜잭션을 발송하여 계약이 발동될 수 있다록 할 수 있는 것이다.

컨트랙트 계정은 이렇게 외부 소유 계정에 의해 전달받은 메시지에 대한 응답으로 자신의 컨트랙트를 수행하고, 수행하는 과정에서 또 다른 컨트랙트 계정에게 메시지를 전달할 수 있다.

## EOA 생성 과정

![image](https://github.com/nobodyjbj/readme/blob/master/src/main/resources/image/account_object2.png)

1. 지갑 프로그램(메타마스크, ~ 월렛 등등)을 통해 개인 키를 생성하는 과정은 랜덤한 256 bit 데이터를 생성하고, 생성된 데이터를 64자리의 Hex 열로 인코딩한 결과 값이다.
2. 개인키를 통해 ECDSA(타원곡선전자서명 아리고리즘)을 이용하여 공개키를 새성한다.
3. 생선된 공개키를 Kecak256 Hash 값으로 변환, 256bit의 바이너리 데이터가 생성된다. 생성된 바이너리 데이터의 앞쪽 96bit(12바이트) 데이터를 제거한 후 남아 있는 160it의 바이너리 데이터를 Hex값으로 인코딩한 결과값이 바로 Address 정보이다. (160bit를 16진수로 변환, 20byte의 데이터이며, 16진수로는 50개의 문자열을 표현할 수 있다.)

