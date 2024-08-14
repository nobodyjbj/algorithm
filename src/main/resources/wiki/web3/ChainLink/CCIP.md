
## What is Chainlink CCIP?

Chainlink CCIP는 dApps이나 web3기업에게 크로스체인에 대한 인터페이스를 제공한다. CCIP를 사용하여 데이터, 토큰등을 체인간에 전송할 수 있게 해준다.

크로스체인의 고유한 위험을 고려하여 CCIP는 보안 우선 사고 방식으로 구축된다. 

![[Pasted image 20240516144153.png]]

## Chainlink CCIP core capabilities

Chainlink CCIP 는 세가지를 지원한다.
1. Arbitary Messaging : 데이터를 다른 블록체인의 스마트 컨트렉트에 전송하는 기능
2. Token Transfet : 토큰을 다른 블록체인의 스마트 컨트렉트 또는 EOA(Externally Owned Account)에 전송하는 기능
3. Programmable Token Transfer : 하나의 트랜젝션 내에서 토큰과 데이터를 동시에 전송할 수 있는 기능

| CCIP capability             | What is sent    | Type of receiving account supported                                                                        |
| --------------------------- | --------------- | ---------------------------------------------------------------------------------------------------------- |
| Arbitrary Messaging         | Data            | Smart contracts only. EOAs on EVM blockchains cannot receive messages.                                     |
| Token Transfer              | Tokens          | Smart contracts and EOAs                                                                                   |
| Programmable Token Transfer | Data and tokens | Smart contracts only. <br>If you send data and transfer tokens to an EOA, only tokens will be transferred. |

[CCIP Support netowrks](https://docs.chain.link/ccip/supported-networks/)

