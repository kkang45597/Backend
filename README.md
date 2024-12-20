# 게시판 만들기 프로젝트 (Backend)
프론트엔드 React와 스프링부트 백엔드를 활용한 게시판 프로젝트입니다.<br>
기능 구현에 약 3주간의 시간이 소요되었습니다.</br></br>

[[ <b>구동에 필요한 프론트엔드</b> ]](https://github.com/kkang45597/Frontend)
## ▶ 1. 소개 및 기능

### 소개
HRD-NET에서 받은 교육을 기반으로 타인의 도움을 받지 않고 처음으로 제작한 프로젝트입니다. <br>
게시판을 직접 제작해보면서, React의 동작 방식과 효율적인 데이터 처리 변환 등과 같은 문제를 스스로 하며 해결책을 찾았습니다.
***

### 구현된 기능
<b>1. 회원 기능</b>
- 로그인 및 로그아웃
- 회원 가입 (JWT 사용)

<b>2. 게시판 기능</b>
- 모든 게시글 표시
- 게시물 작성
- 게시물 수정
- 게시글 삭제
  
<b>3. 댓글 기능</b>
- 댓글 작성
***

### 미구현된 기능
<b>1. 게시판 기능</b>
- 게시물에 파일 첨부
- 게시물에 태그 첨부

<b>3. 댓글 기능</b>
- 댓글 삭제
***

## ▶ 2. 구조 및 설계
### 기능 구현에 사용한 데이터베이스 목록 
#### ▼ User
<img src="./image/User.png" width=1000px /><br>
#### ▼ Profile
<img src="./image/Profile.png" width=1000px /><br>
#### ▼ Post
<img src="./image/Post.png" width=1000px /><br>
#### ▼ Tag
<img src="./image/Tag.png" width=1000px /><br>
#### ▼ PostTag
<img src="./image/Post Tag.png" width=1000px /><br>
#### ▼ Comment
<img src="./image/Comment.png" width=1000px /><br>
#### ▼ Token
<img src="./image/Token.png" width=1000px /><br>
***

### 기능 구현에 사용한 API 목록 
#### ▼ LoginController
API 이름 | URL | 요청 방식 | 설명
---------|---------|---------|---------
login | /logins | POST | User DB에서 가입된 유저가 맞는지 확인합니다.<br>아이디가 없거나 패스워드 불일치하면 alert 실패 메시지를 전송합니다.<br>일치하면 쿠키에 저장된 토큰과 일치하는지 확인합니다.<br>Token DB에 해댱 유저의 토큰이 없거나 불일치하면 새로운 토큰을 발급합니다.<br>UserId와 UserKey를 세션에 저장합니다.
loginNoticeBoard | /users | GET | 세션에 저장된 유저 아이디를 가져와 브라우저의 로컬스토리지에 적재합니다.
logoutNoticeBoard | /user/logout | POST | 쿠키의 JSESSIONID를 제거하고 세션을 종료합니다.

#### ▼ RegisterController
API 이름 | URL | 요청 방식 | 설명
---------|---------|---------|---------
registerMailSendAlert | /users/{email}/{id} | GET | User DB에 해당하는 아이디와 이메일이 있는지 확인합니다. 아이디나 이메일이 있는 경우엔 alert 실패 메시지를 전송합니다.
registerMailSend | /mail/send | POST | 받은 이메일로 UUID로 생성한 인증번호를 전송합니다. 전송된 UUID는 세션에 저장됩니다.
registerMailCheck | /mail/check | POST | 인증번호가 세션에 저장된 인증번호와 일치하는지 확인합니다. 인증에 성공하면 쿠키의 JSESSIONID를 제거하고 세션을 종료합니다.
registers | /registers | POST | User DB와 Profile DB에 유저 정보를 저장합니다.

#### ▼ RegisterController
API 이름 | URL | 요청 방식 | 설명
---------|---------|---------|---------
loadPostList | /posts | GET | 세션에 저장된 UserKey를 사용해 Post DB에서 삭제되지 않은 게시물들을 가져옵니다. 비공개 게시물은 해당 유저가 로그인한 상태이면 가져옵니다. 
loadPostCount | /posts/count | GET | 페이징 기능을 위해 모든 게시물의 갯수를 가져옵니다.
uploadPost | /posts | POST | 받은 데이터를 Post, Tag, PostTag DB에 저장합니다. 게시물 업로드에 사용됩니다.
editPost | /posts/{postId} | PUT | 받은 데이터를 Post, Tag, PostTag DB에 저장합니다. 게시물 수정에 사용됩니다.
LoadPostDetail | /posts/{postId} | GET | 게시물의 상세 정보를 Post, Tag, PostTag DB에서 가져옵니다.
updatePostView| /posts/views/{postId} | PATCH | 해당 게시물의 조회수를 1 증가시키도록 Post DB를 업데이트 합니다.
postComment | /comments/{postId} | GET | 게시물에 표시될 식제되지 않은 댓글 목록을 Comment DB에서 가져옵니다.
deletePost | /posts/{postId} | DELETE | 해당 게시물이 더이상 보이지 않도록 Post DB에서 해당 게시물의 is_delete를 N으로 변경합니다.
addComment | /comments | POST | 받은 데이터를 Comment DB에 저장합니다.

## ▶ 4. 기술 스택
기술 | 버전
---------|---------
Spring Boot | 3.3.5
mysql-connector-java | 8.0.30
spring-boot-starter-data-redis | 2.7.7
querydsl-jpa | 5.0.0
querydsl-apt | 5.0.0
jakarta.annotation-api |
jakarta.persistence-api |
jjwt | 0.9.1
spring-cloud-starter-aws | 2.2.6.RELEASE
spring-boot-starter-mail | 3.2.1

## ▶ 5. 실행 화면
#### ▼ 시작 화면
<img src="./image/noticelist.png" width=1000px /><br>
#### ▼ 로그인 성공
<img src="./image/login sucess.png" width=1000px /><br>
#### ▼ 로그인 실패 (해당 아이디 없음)
<img src="./image/login fail, id.png" width=1000px /><br>
#### ▼ 로그인 실패 (비밀번호 불일치)
<img src="./image/login fail, password.png" width=1000px /><br>
#### ▼ 계정 생성 성공
<img src="./image/register sucess send email.png" width=1000px /><br>
#### ▼ 계정 생성 실패 (사용중인 아이디)
<img src="./image/register fail. id.png" width=1000px /><br>
#### ▼ 계정 생성 실패 (사용중인 이메일)
<img src="./image/register fail, email.png" width=1000px /><br>
#### ▼ 도착한 인증번호 이메일
<img src="./image/register email.png" width=1000px /><br>
#### ▼ 인증번호 일치
<img src="./image/register sucess correct.png" width=1000px /><br>
#### ▼ 인증번호 불일치
<img src="./image/register fail not correct.png" width=1000px /><br>
#### ▼ 글작성
<img src="./image/newpost before.png" width=1000px /><br>
#### ▼ 글작성 성공
<img src="./image/newpost after.png" width=1000px /><br>
#### ▼ 글작성 실패 (제목 없음)
<img src="./image/newpost fail, title.png" width=1000px /><br>
#### ▼ 글작성 실패 (본문 없음)
<img src="./image/newpost fail, content.png" width=1000px /><br>
#### ▼ 댓글 작성
<img src="./image/comment before.png" width=1000px /><br>
#### ▼ 댓글 작성 성공
<img src="./image/comment after.png" width=1000px /><br>
#### ▼ 글수정 (댓글 막기)
<img src="./image/edit block comment before.png" width=1000px /><br>
#### ▼ 댓글이 막힌 게시물
<img src="./image/edit block comment after.png" width=1000px /><br>
#### ▼ 글수정 (비밀글 설정)
<img src="./image/edit private before.png" width=1000px /><br>
#### ▼ 해당 유저가 작성한 글이 아니면 보이지 않음
<img src="./image/edit private after.png" width=1000px /><br>
