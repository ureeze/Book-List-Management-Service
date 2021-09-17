## 도서목록 관리 RESTFUL API 설계

![RESTAPI1](https://user-images.githubusercontent.com/37195463/132295056-57c696c3-6596-4b95-88db-a3264de064e2.png)
![RESTAPI2](https://user-images.githubusercontent.com/37195463/132295058-119fadf4-4682-43f2-80d7-10e258f13dd4.png)
![book list](https://user-images.githubusercontent.com/37195463/133755482-38c9ba86-b0a1-45f6-bd4b-3cccd753a3b7.png)


### 도서 목록 관리를 위해  RESTful API 구현

+ 도서 데이터 조회, 추가, 삭제, 수정 기능 구현
+ API Swagger를 이용하여 URL 리스트를 문서로 자동화
+ 다양한 클라이언트 환경에서 통신을 할 수 있어야 했기에 이러한 멀티 플랫폼에 대한 지원을 위해 도서목록 관리 서비스를 RESTful API로 설계
+ HATEOAS를 통해 관련된 자원의 링크정보를 제공


### 사용언어
+ HTML/CSS
+ JAVA 8

### 사용 라이브러리 및 프레임워크
+ Spring Boot 2.5.2
+ Spring Data JPA
+ MySQL
+ ThymeLeaf
+ Lombok
+ Hateoas
