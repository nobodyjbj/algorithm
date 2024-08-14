## Git

### 자주 쓰는 명령어 

* git init : git 생성하기
* git clone git_path : 코드가져오기
* git checkout branch_name : 브랜치 선택하기
* git checkout -t remote_path/branch_name : 원격 브랜치 선택하기
* git branch branch_name : 브랜치 생성하기
* git branch -r : 원격 브랜치 목록보기
* git branch -a : 로컬 브랜치 목록보기
* git branch -m branch_name change_branch_name : 브랜치 이름 바꾸기
* git branch -d branch_name : 브랜치 삭제하기
* git push remote_name — delete branch_name : 원격 브랜치 삭제하기 ( git push origin — delete gh-pages )
* git add file_path : 수정한 코드 선택하기 ( git add * )
* git commit -m “commit_description” : 선택한 코드 설명 적기 ( git commit -m “내용”)
* git push romote_name branch_name : add하고 commit한 코드 git server에 보내기 (git push origin master)
* git pull : git서버에서 최신 코드 받아와 merge 하기
* git fetch : git서버에서 최신 코드 받아오기
* git reset — hard HEAD^ : commit한 이전 코드 취소하기
* git reset — soft HEAD^ : 코드는 살리고 commit만 취소하기
* git reset — merge : merge 취소하기
* git reset — hard HEAD && git pull : git 코드 강제로 모두 받아오기
* git config — global user.name “user_name ” : git 계정Name 변경하기
* git config — global user.email “user_email” : git 계정Mail변경하기
* git stash / git stash save “description” : 작업코드 임시저장하고 브랜치 바꾸기
* git stash pop : 마지막으로 임시저장한 작업코드 가져오기
* git branch — set-upstream-to=remote_path/branch_name : git pull no tracking info 에러해결

### git 용어 정리

#### repository

원격 저장소 (Remote Repository)
- 파일이 원격 저장소 전용 서버에서 관리되며 여러 사람이 함께 공유

로컬 저장소(Local Repository)
- 개인 PC에 파일이 저장되는 개인 저장소

로컬 저장소는 아래 3가지로 이루어진다.
- working directory : 실제 소스 코드
- index : stage 역할
- head : commit을 한 소스코드

#### branch

독립적인 개발공간을 위해 사용한다, 협업을 할 때 사용하게 되고 전체 공간중에서 작업자가 작업을 해야할 일부분의 공간을 분리하기위해 사용한다.
전체 공간과 작업자의 공간(branch)을 합쳐야하는게 그것을 merge 라고 한다. 

#### commit 

로컬 저장소에 변경된 내용을 기록한다.

#### push

로컬 저장소에서 변경된 내용을 원격 저장소에 업데이트 한다.

#### clone

로컬 / 원격 repository 를 다운로드한다.

#### fetch

main 이나 다른 branch 에서 작업한 내용이 내 로컬 repository 와 버전이 맞지 않을때 최신 버전으로 업데이트한다.

#### merge

branch 의 변경사항을 main에 반영, 혹은 다른 두 branch 끼리도 병합하려 한다면 merge 를 사용한다.

#### pull 

fetch + merge  
로컬 저장소의 버전이 원격저장소의 버전보다 낮은 경우, 온라인 저장소의 버전으로 로컬저장소를 업데이트 한다.

#### rebase

두 브랜치가 나뉘기 전인 공통 커밋으로 이동하고 나서 그 커밋부터 지금 Checkout 한 브랜치가 가리키는 커밋까지 diff를 차례로 만들어 어딘가에 임시로 저장해 놓는다. Rebase 할 branch 가 합칠 branch 가 가리키는 커밋을 가리키게 하고 아까 저장해 놓았던 변경사항을 차례대로 적용한다.  
원격저장소에 push 로 내보낸 커밋을 한 상태에서는 사용해서는 안된다.

#### diff

소스간에 비교할 때 사용하는 명령어, 변경점을 확인할 때 사용한다.

#### pull request

작업 후 commit을 했으니 이제 merge 를 해도 되는지 확인을 받는 활동을 말한다. 

#### Fork

다른 사람의 repository 에서 내가 어떤 부분을 수정하거나 추가 기능을 넣고 싶을 때 해당 저장소의 소스를 내 리모트 저장소에 복제하고 싶을때 사용한다.  
fork한 저장소는 원본과 연결되어 있다. 그러므로 변경을 한 후 반영도 가능하다. 이때, fetch 나 rebase 과정이 필요하다. 후에 변경사항을 적용하고 싶다면 fork 저장소에 pull request 하면 된다.