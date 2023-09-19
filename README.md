# 🧑🏻‍💻 spring_mysql_inflearn

### 🧑🏻‍🏫 프로젝트 소개

학교 과제에서 php로 만든 인프런 클론 코딩을 spring, springboot, jpa, mysql을 사용해 다시 만들기.

지금까지 공부했던 spring, jpa 기술을 직접 사용해보며 이해하는 것이 주요 목적. 사실상 CRUD 연습일수도 있지만 여러 기술을 사용해 볼 것이다.

### 🔨 주요 기능

- 회원 가입
- 로그인
- 세션 유지
- 강의 목록 조회
- 강의 수강 신청 (중복 수강 신청 감지)
- 개인 정보 수정
- 수강 정보 조회
- 로그아웃
- 추가 예정..

### 🔭 계획

매우 거칠게 기능만 완성시킨 후 인강, 책, 구글링을 통해 리팩토링 및 기능 추가를 할 것 이다.

우당탕탕 코딩하여 디렉토리 정리조차 되지 않았다. 가독성 역시 0,,, 조금씩 고쳐나가며 그
과정들을 [블로그](https://te-ho.tistory.com/category/Mini_Tiny_Project/inflearn_clone%3F)에 기록할 예정이다.

### 🧬 기본 구조

<img width="993" alt="image" src="https://github.com/Te-H0/spring_mysql_inflearn/assets/54144849/5c5e5769-669e-41c8-b15c-e6dcd7577f76">
php로 개발할 때는 Category와 Course가 다대다 양방향이였지만 지금은 다대일 양방향이다. 추후 다대다 관계를 풀어서 엔티티를 추가 할 예정이다. 또한 질문 게시판, 댓글 기능들을 추가할 경우 엔티티는 더 수정될 계획이다.


---

### 🗣️ 수정 일지

- 23-07-02 ~ 23-07-12
    - [베타 버전 완성](https://te-ho.tistory.com/53)
- 23-07-14
    - [@Column(nullable = false)를 @NotNull로 수정](https://te-ho.tistory.com/54)
- 23-07-20
    - [필요없는 @Transactional 제거](https://te-ho.tistory.com/59)
- 23-07-25
    - [Repository에서 직접 사용하던 메서드 Servcie에서 사용하도록 바꾸기.](https://te-ho.tistory.com/62)

    - TempController에 임시로 작성했던 코드들 모듈화하여 기능에 맞는 Controller로 옮기기.

    - DB에서 데이터 꺼냈을 때 null일 경우 체크하는 과정 작성 후 error 페이지로 이동하기 완료.
- 23-07-27
    - [Course와 Category가 다대일 관계여서 course가 1개의 카테고리밖에 갖을 수 없던 문제 @ManyToMany와 @JoinTable 사용해 다대다로 변경.](https://te-ho.tistory.com/66)
    - (23-08-10) 다대다 관계에서 List<> 👉 Set<> 으로 변경하여 복합키 생성, 카테고리 중복 방지 가능.
- 23-07-28
    - findAllByXXXContaing이용해서 일부분 입력해도 검색 가능하게 수정. ex) spring으로 검색해야 나오던 결과들 sp만 입력해도 검색 가능.
- 23-08-17
    - [타임리프 th:object, th:field 사용하여 form 수정.](https://te-ho.tistory.com/67)
- 23-09-04
    - [Bean Validation, BindingResult, messages 사용하여 검증 사용.](https://te-ho.tistory.com/69)
- 23-09-18 ~ 23-09-19
    - 로그인 시 없는 정보일 경우 global error 처리
    - @SessionAttribute 사용, Interceptor 사용하여 로그인 인증 -> 반복되던 코드 제거

<!--
# h1
## h2 (여기까지만 밑줄 생김)
### h3
#### h4
##### h5
###### h6

줄바꿈 엔터 두번

1. 인덱싱
2. 그냥 이렇게

- 이거 는 그냥 점으로 목록

구분선 -나 * 3개이상이면 다됨 띄어쓰기 있어도 돼
---, -- - --- ---, ***, *** ** 

__쓸거__, **쓸거** bold 두껍게
_쓸거-, *쓸거* 이텔릭체
~~쓸거~~ 취소선

코드블럭
    int a = 0; (들여쓰기 4칸)
코드 블럭 강조하기
``` java

  int a = 0;
```

링크 걸기 그냥 주소 적어 설명에는 <>안에 적으라했는데 그냥 하면돼
[이거맞냐](www.naver.com) 이건 글자에 링크걸기

이미지
![대체 텍스트(alternative text)를 입력하세요!](http://www.gstatic.com/webp/gallery/5.jpg "링크 설명(title)을 작성하세요.") 
-->
