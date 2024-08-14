## Aptos keyless 용어 정리

- **OpenID Connect (OIDC)**: 신원 인증 프로토콜로, 연합된 신원 확인을 가능하게 합니다. 예를 들어, 사용자가 "구글로 로그인" 과정을 거칠 때 사용된다.
- **Identity Provider (IdP)**: OIDC를 통해 사용자의 신원을 인증하는 신뢰할 수 있는 기관입니다. 지원 예시로는 Google이 있다.
- **JSON Web Token (JWT)**: 클라이언트와 서버 간에 보안 정보를 공유하기 위해 사용되는 공개 표준이다. 각 JWT는 인코딩된 JSON 객체를 포함하고 있으며, 클레임 세트를 포함한다. JWT는 암호화 알고리즘을 사용하여 서명되며, 이를 통해 토큰이 발행된 후 변경되지 않았음을 보장한다.
    - **iss**: OIDC 제공자를 식별하는 지표이다. 예: [https://accounts.google.com](https://accounts.google.com)
    - **aud**: 사용자가 로그인하는 애플리케이션의 OAuth client_id이다. 예: Notion.so
    - **sub**: OIDC 제공자가 사용자를 식별하는 데 사용하는 식별자이다. 이는 특정 client_id에 특화된 식별자일 수 있다. 또는 여러 client_id 간에 공유되는 식별자일 수 있다 (예: Facebook의 OIDC는 이 기능이 있다.)
    - **email**: 일부 제공자는 사용자의 이메일을 필드로 공개할 수 있다. 예: Google
    - **email_verified**: 제공자가 사용자가 이 이메일 주소의 소유자임을 확인했는지를 나타내는 필드이다.
    - **nonce**: 애플리케이션이 OIDC 제공자에게 서명하도록 요청하는 임의의 데이터이다.
    - **iat**: JWT가 발행된 시간을 나타낸다.
- **Ephemeral Key Pair**: Aptos Keyless 계정의 트랜잭션을 서명하는 데 사용되는 임시 공개/개인 키 쌍이다. 공개 키와 만료 날짜는 nonce 필드를 통해 JWT 토큰에 커밋된다.
- **Keyless Account**: 사용자의 OIDC 계정(e.g., alice@gmail.com)과 연관된 애플리케이션의 OAuth client_id(e.g., Notion.so)에서 직접 파생된 블록체인 계정이다. 사용자는 OIDC 흐름을 통해 인증한다.
- **JSON Web Key (JWK)**: OIDC 제공자의 암호화 공개 키이다. 이 공개 키는 클라이언트 애플리케이션이 OIDC 제공자가 발행한 JWT의 서명을 검증하는 데 사용된다. 이렇게 하면 클라이언트 애플리케이션은 토큰의 진위 여부를 확인하고 변조되지 않았음을 보장할 수 있다.
- **client_id**: 애플리케이션이 IdP에 등록할 때 받는 OAuth 식별자이다. 이 값은 사용자 주소 파생에 사용된다.
- **redirect_uri**: 사용자가 성공적으로 인증된 후 호출되는 콜백 핸들러의 URI이다. 이는 IdP에 등록해야 한다.

##  dApp에서 사용자에 대한 keyless account 도출

사용자가 dApp에서 Google로 로그인 후에 keyless account blockchain address 를 도출하고, 다른 사용자에게 자산을 transfer 방법을 살펴본다.
##### EPK 생성
사용자가 만료 날짜가 있는 임시 공개 키(EPK)와 관련된 임시 비밀 키(ESK)를 생성한다.
dApp은 EPK를 저장하고, 사용자는 ESK를 브라우저의 로컬 저장소나 WebAuthn 패스키와 같은 신뢰할 수 있는 곳에 안전하게 저장한다.
##### EPK Commit
dApp은 EPK를 H(epk,ρ)으로 반영한다. 여기서 ρ는 숨겨진 요소이다. 
사용자가 "Google로 로그인" 버튼을 클릭하면 dApp은 사용자를 Google 로그인 페이지로 리디렉션한다.
URL의 nonce 파라미터에 EPK 반영한다. 이를 통해 Google은 EPK를 볼 수 없으며, 사용자의 트랜잭션 활동이 보호됩니다.

##### Step 3 : 
##### Step 4 : 
##### Step 5 : 
















---

첫번째 작업(백업)

## 시나리오
### Google의 Passkey, JWK, OIDC 및 ZKP를 사용한 블록체인 인증 로직
다음은 Google의 Passkey, JWK, OIDC 및 ZKP를 사용한 블록체인 인증 로직이다. 이 로직은 Aptos의 Pepper 서비스를 참고하여 설계되었다.
### 1. Passkey 생성 및 관리
**Passkey 생성**:
1. **계정 생성 요청**: 사용자가 계정 생성을 요청한다.
2. **공개 키와 개인 키 쌍 생성**: 클라이언트(사용자 기기)에서 공개 키와 개인 키 쌍을 생성한다.
3. **공개 키 저장**: 생성된 공개 키를 서버로 전송하고, 서버는 이를 JWK(JSON Web Key) 형식으로 저장한다. 개인 키는 사용자의 기기에 안전하게 저장된다.
4. **계정 생성 완료**: 클라이언트가 사용자에게 계정 생성 완료를 알린다.

**Passkey 반환 형태 예시**:
```json
{
  "id": "user@example.com",
  "rawId": "MDEyMzQ1Njc4OTAxMjM0NQ",
  "type": "public-key",
  "response": {
    "clientDataJSON": "eyJjaGFsbGVuZ2UiOiAiU29tZSBDaGFsbGVuZ2UiLCAiY2xpZW50RW5jb2RpbmdNYW5kYXRvcnkiOiAiZm9vLmJhci5jb20iLCAidHlwZSI6ICJ3ZWJhYXV0aG4uY3JlYXRlIn0",
    "attestationObject": "o2NmbX...."
  }
}

```
### 2. 사용자 인증
**인증 과정**:
1. **로그인 요청**: 사용자가 로그인 요청을 한다.
2. **인증 요청**: 클라이언트가 서버에 인증 요청을 보낸다.
3. **챌린지 생성**: 서버는 챌린지를 생성하여 클라이언트로 전송한다.
4. **챌린지 서명**: 클라이언트는 개인 키로 챌린지에 서명하고, 서명된 챌린지를 서버로 전송한다.
5. **공개 키 요청 및 반환**: 서버는 JWK 저장소에서 공개 키를 가져와 서명을 검증한다.
6. **서명 검증**: 서명이 유효하면 서버는 인증 토큰을 발급한다.
7. **로그인 성공**: 클라이언트가 사용자에게 로그인 성공을 알린다.

**JWK 반환 형태 예시**:
```json
{
  "keys": [
    {
      "kty": "RSA",
      "use": "sig",
      "kid": "1b94c",
      "alg": "RS256",
      "n": "0vx7agoebGcQS...",
      "e": "AQAB"
    }
  ]
}
```
### 3. OIDC를 통한 인증
OIDC는 ID 토큰, 액세스 토큰, 리프레시 토큰을 발급하여 사용자 인증 및 권한 부여를 수행한다.

**OIDC 토큰 응답 예시**:
```json
{
  "access_token": "ya29.a0AfH6SMAISY...",
  "expires_in": 3599,
  "refresh_token": "1//0gLbv-...",
  "scope": "https://www.googleapis.com/auth/userinfo.email openid",
  "token_type": "Bearer",
  "id_token": "eyJhbGciOiJSUzI1NiIsImtpZCI6ImNpZCIsInR5cCI6IkpXVCJ9..."
}
```
### 4. ZKP(Zero-Knowledge Proof)를 통한 추가 보안
ZKP는 사용자의 개인 정보를 노출하지 않고도 특정 정보를 증명할 수 있는 기술이다. ZKP는 블록체인 네트워크에서 온체인으로 구현될 수 있으며, 온체인으로 구현하는 것이 일반적이다. 이렇게 하면 ZKP 증명을 블록체인에 기록하여 검증의 투명성과 불변성을 보장할 수 있다.

**ZKP 활용**:
1. **ZKP 요청**: 사용자가 ZKP 요청을 한다.
2. **ZKP 증명 생성**: 클라이언트는 ZKP 증명을 생성하여 서버에 전송한다.
3. **ZKP 검증 요청**: 서버는 블록체인 네트워크를 통해 ZKP 증명을 검증한다.
4. **ZKP 검증 결과 반환**: 블록체인이 검증 결과를 서버에 반환한다.
5. **ZKP 검증 완료**: 서버가 검증 결과를 클라이언트에 전송하고, 클라이언트가 사용자에게 검증 완료를 알린다.
#### ZKP 예시
```javascript
const zkp = require('zkp-library');

// 사용자 자격 증명 데이터
const userCredentials = {
  age: 30,
  residence: "Seoul, Korea",
  incomeLevel: "High"
};

// ZKP 증명 생성
function generateProof(userCredentials) {
  const proof = zkp.generateProof(userCredentials);
  return proof;
}

// ZKP 검증 요청
function verifyProof(proof, publicData) {
  const isValid = zkp.verifyProof(proof, publicData);
  return isValid;
}

// 사용자 시나리오
const proof = generateProof(userCredentials);

// 서버 검증
const publicData = "relevant_public_data";
const isValid = verifyProof(proof, publicData);

if (isValid) {
  console.log('ZKP 검증 성공');
} else {
  console.log('ZKP 검증 실패');
}

```
### 종합 로직
1. **Passkey 생성 및 관리**: 사용자가 계정 생성을 요청하면, 공개 키와 개인 키 쌍이 생성되고, 공개 키는 서버에 JWK 형식으로 저장된다.
2. **사용자 인증**: 사용자가 로그인 요청을 하면, 서버는 챌린지를 생성하고, 클라이언트는 이를 개인 키로 서명한 후 서버로 전송하여 인증을 완료한다.
3. **OIDC 토큰 발급**: 서버는 인증이 완료되면 ID 토큰, 액세스 토큰, 리프레시 토큰을 발급한다. ID 토큰은 사용자의 신원을 확인하고, 액세스 토큰은 보호된 리소스에 접근하며, 리프레시 토큰은 액세스 토큰을 갱신하는 데 사용된다.
4. **ZKP 검증**: 사용자가 추가적인 보안을 위해 ZKP 요청을 하면, 클라이언트는 ZKP 증명을 생성하여 서버에 전송하고, 서버는 이를 블록체인 네트워크를 통해 온체인으로 검증한다.

참고 : 
- [WebAuthn 공식 문서 (W3C)](https://www.w3.org/TR/webauthn-2/)
- FIDO Alliance: WebAuthn
- [MDN Web Docs: Web Authentication API](https://developer.mozilla.org/en-US/docs/Web/API/Web_Authentication_API)
- OIDC 공식 문서
- [Zero-Knowledge Proofs 개요](https://en.wikipedia.org/wiki/Zero-knowledge_proof)

### 시퀀스 다이어그램
![[Pasted image 20240605142430.png]]

## 서명
### Google Passkey와 개인 키 관리

Google Passkey는 FIDO2 표준을 기반으로 하며, 개인 키는 다음과 같은 방식으로 관리된다:

1. **보안 영역**: 개인 키는 기기의 보안 영역(예: Secure Enclave, TPM 등)에 저장된다. 이 영역은 매우 높은 보안성을 제공하며, 운영체제나 애플리케이션에서 직접 접근할 수 없다.
2. **비대칭 암호화**: Passkey는 비대칭 암호화를 사용하여 키 쌍(공개 키와 개인 키)을 생성한다. 개인 키는 보안 영역에 안전하게 저장되고, 공개 키는 서버에 등록된다.
3. **서명 요청**: 애플리케이션은 Passkey를 통해 서명 요청을 할 수 있으며, 이 경우 개인 키를 사용하여 서명 작업이 보안 영역 내에서 수행된다. 서명 결과만 애플리케이션에 반환된다.

### 개인 키 접근의 제한

Passkey 시스템의 설계 원칙에 따라, 개인 키는 다음과 같은 이유로 직접 접근이 불가능하다:
1. **보안 강화**: 개인 키가 노출되면 큰 보안 위험이 발생할 수 있으므로, 이러한 키는 보안 영역 내에서만 사용되고 외부로 노출되지 않는다.
   
2. **사용자 경험**: 사용자에게 개인 키를 직접 관리하도록 요구하지 않음으로써 보안성을 유지하면서도 사용자 경험을 간소화한다.

### 공개키 접근의 방법
1. 계정 인증 (OIDC 사용)
	- **OIDC 인증**: 사용자가 Google 계정으로 로그인하면 OIDC를 통해 ID 토큰과 액세스 토큰을 발급받습니다.
	- **서명 검증**: ID 토큰과 액세스 토큰의 서명을 검증하여 사용자의 신원을 확인합니다. JWK를 사용하여 서명을 검증합니다.

2. 블록체인 트랜잭션 생성 (Passkey 사용)
	* ***트랜잭션 생성**: 사용자가 블록체인 트랜잭션을 생성할 때, 트랜잭션 데이터를 작성합니다.
	- **Passkey 서명**: 사용자의 기기에서 Passkey를 사용하여 트랜잭션 데이터를 서명합니다. Passkey는 개인 키를 사용하여 서명을 생성하며, 이 서명은 해당 트랜잭션의 무결성과 출처를 보장합니다.
	- **트랜잭션 전송**: 서명된 트랜잭션 데이터를 블록체인 네트워크에 전송합니다.

### 대안: 서명 요청

Passkey를 사용하여 개인 키를 직접 가져오는 대신, 다음과 같은 절차를 통해 서명 작업을 수행할 수 있다:
1. **트랜잭션 데이터 준비**: 서명할 데이터를 준비한다.
2. **Passkey 서명 요청**: FIDO2 API를 통해 Passkey에 서명 요청을 보낸다.
	1. 서명을 할때 공개키를 사용하는데, 공개키는 ID토큰으로 get 할 수 있음
3. **서명 결과 수신**: Passkey는 보안 영역에서 개인 키로 서명 작업을 수행하고, 서명된 데이터를 반환한다.

### 예시 코드

FIDO2 API를 사용하여 Passkey를 통해 서명 요청을 수행하는 예시 코드:

```javascript
async function signTransaction(transactionData) {
  // FIDO2 서명 요청
  const publicKeyCredentialRequestOptions = {
    challenge: new Uint8Array(32),
    allowCredentials: [{
      type: 'public-key',
      id: new Uint8Array(credentialId)
    }],
    timeout: 60000,
    userVerification: 'preferred'
  };

  const assertion = await navigator.credentials.get({ publicKey: publicKeyCredentialRequestOptions });
  
  // 서명된 데이터를 반환
  return assertion.response.signature;
}

// 트랜잭션 데이터 예시
const transactionData = {
  from: "0xSenderAddress",
  to: "0xReceiverAddress",
  value: 100,
  gas: 21000,
  data: "zkp_result_data"
};

// 서명 요청
signTransaction(transactionData).then(signedData => {
  console.log('Signed transaction data:', signedData);
});

```

### 요약
- Google Passkey는 개인 키를 보안 영역에 저장하여 안전하게 관리한다.
- Passkey를 통해 개인 키를 직접 가져올 수는 없으며, 대신 서명 요청을 통해 필요한 작업을 수행할 수 있다.
- FIDO2 API를 사용하여 Passkey에 서명 요청을 보낸 후, 서명된 데이터를 받아서 트랜잭션에 사용할 수 있다.

이러한 방식으로 Passkey의 보안성과 사용자 편의성을 유지하면서 필요한 작업을 수행할 수 있다.

