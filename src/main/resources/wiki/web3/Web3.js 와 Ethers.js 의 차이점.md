### Web3.js와 Ethers.js를 배포한 회사

**Web3.js**는 원래 이더리움 재단(Ethereum Foundation)에서 개발되었다. 이후 현재는 **ChainSafe Systems**가 활발하게 개발을 관리하고 있습니다​ ([Documentation](https://docs.ethers.org/v4/index.html))​.

**Ethers.js**는 캐나다 소프트웨어 엔지니어 리처드 무어(Richard Moore)에 의해 개발되었다. Ethers.js는 독립적으로 유지 관리되고 있으며, Web3.js에 대한 가볍고 효율적인 대안으로 설계되었다.​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​
### Web3.js와 Ethers.js의 차이점
1. **크기와 성능**:
    - **Web3.js**: 큰 라이브러리로, 몇 메가바이트에 달할 수 있어 성능에 영향을 줄 수 있습니다.
    - **Ethers.js**: 경량 라이브러리로, 압축된 크기가 약 77-88KB에 불과해 대부분의 애플리케이션에서 더 나은 성능을 제공합니다​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​​ ([Documentation](https://docs.ethers.org/v4/index.html))​.
2. **모듈성**:
    - **Web3.js**: 제공자(provider)와 지갑(wallet) 기능이 통합되어 있어 덜 모듈화되어 있습니다.
    - **Ethers.js**: 지갑과 제공자 기능이 분리되어 있어 더 많은 유연성과 보안 관리가 가능합니다​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​.
3. **라이선스**:    
    - **Web3.js**: LGPL 라이선스를 사용하여, 수정 및 재배포에 제한이 있습니다.
    - **Ethers.js**: MIT 라이선스를 사용하여, 더 자유롭게 사용 및 수정이 가능합니다​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​.
4. **문서화와 사용성**:
    - **Web3.js**: 종합적인 문서를 가지고 있지만, 크기와 복잡성으로 인해 다루기 어려울 수 있습니다.
    - **Ethers.js**: 광범위한 문서와 단순성으로 인해 사용 및 프로젝트 통합이 더 쉽습니다​ ([Documentation](https://docs.ethers.org/v4/index.html))​​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​.
5. **인기와 커뮤니티 지원**:    
    - **Web3.js**: 역사적으로 더 인기가 많으며 GitHub에서 별(star)과 포크(fork)가 많지만, 최근에는 사용이 줄어드는 추세입니다.
    - **Ethers.js**: 빠르게 인기를 얻고 있으며, NPM에서 주간 다운로드 수가 더 많고 강력한 개발자 커뮤니티가 지원하고 있습니다​ ([101 Blockchains](https://101blockchains.com/web3-js-vs-ethers-js/))​.

요약하면, 두 라이브러리 모두 이더리움 블록체인과 상호작용하는 데 강력한 도구지만, Ethers.js는 더 현대적이고 경량이며 모듈화된 접근 방식을 제공하여 많은 새로운 프로젝트에서 선호되고 있습니다. 반면, Web3.js는 긴 역사와 넓은 기반의 레거시 지원을 가지고 있습니다.