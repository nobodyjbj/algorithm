### 개념

#### 사용자가 원하는 정보
- 사용자의 질문과 관련있는 데이터
	- 관련성을 파악하기 위해 vector를 활용
		- 단어 또는 문장의 유사도를 파악해서 관련성을 측정함
- vector를 생성하는 방법
	- Embedding 모델을 활용해서 vector 생성
	- 문장의 비슷한 단어가 자주 붙어있는 것을 학습
	- [Embedding Proejcter](https://projector.tensorflow.org/)
### Vector Database
- Embedding 모델을 활용해 생성된 vector를 저장
	- vector 와 metadata도 함께 저장
	- 메타데이터는 문서의 이름, 페이지번호 등을 함께 저장(할루시네이션 이슈를 대비해서 같이 저장), 답변의 퀄리티가 상승
	- Chuncking, 문서를 나눠서 저장하는 방법
### Vector Database의 종류
- Chroma
	- 인메모리 벡터 데이터 베이스
	- 스터디 혹인 PoC 개발에 용이함
	- https://docs.trychroma.com/guides/embeddings
- Pinecone
	- 클라우스 기반의 벡터 데이터 베이스
	- AWS에서 올라가는 것이 기본으로 되어 있음
	- RDB개념의 데이터 베이스를 파인콘에서는 인덱스라고 부름
	- 사용서비스, 개발에 용이함
- 그외
	- https://python.langchain.com/v0.2/docs/integrations/vectorstores/
	- 엄청 많다. 회사 또는 개인이 정한 서비스를 사용하면 됨
### Vector를 대상으로 유사도 검색
- 사용자의 질문과 가장 비슷한 문서를 가져오는 것 - Retrieval
- 가져온 문서를 prompt를 통해 LLM에 제공 - Augmented
- LLM은 prompt를 활용해 답변 생성 - Generation

❗️한국말 Embedding 은 Upstage Embedding이 더 뛰어나다.
