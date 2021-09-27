## 도서목록 관리 RESTFUL API 설계

> 도서 목록 관리를 위해  RESTful API 구현

+ 도서 데이터 조회, 추가, 삭제, 수정 기능 구현
+ API Swagger를 이용하여 URL 리스트를 문서로 자동화
+ 다양한 클라이언트 환경에서 통신을 할 수 있어야 하므로 이러한 멀티 플랫폼에 대한 지원을 위해 도서목록 관리 서비스를 RESTful API로 설계
+ HATEOAS를 통해 관련된 자원의 링크정보를 제공


### 사용 언어
+ JAVA 8
+ HTML/CSS

### 사용 라이브러리 및 프레임워크
+ Spring Boot 2.5.2
+ Spring Data JPA
+ MySQL
+ ThymeLeaf
+ Lombok
+ Hateoas


## 1. 도서목록
![book list](https://user-images.githubusercontent.com/37195463/133755482-38c9ba86-b0a1-45f6-bd4b-3cccd753a3b7.png)

## 2. 도서 등록
![도서 등록](https://user-images.githubusercontent.com/37195463/134794972-eaee9c36-0720-40ab-bbef-1154737f8ca6.png)

## 3. 도서 상세정보
![도서 상세정보](https://user-images.githubusercontent.com/37195463/134794971-afd7123d-0bae-4117-8cbe-3f82b970cee7.png)

## 4. 도서 검색
![도서 검색](https://user-images.githubusercontent.com/37195463/134794973-21e1e325-2dd8-42f7-8f02-d890c956d885.png)

## 5. RESTful API
![RESTAPI1](https://user-images.githubusercontent.com/37195463/132295056-57c696c3-6596-4b95-88db-a3264de064e2.png)
![RESTAPI2](https://user-images.githubusercontent.com/37195463/132295058-119fadf4-4682-43f2-80d7-10e258f13dd4.png)

## GET
![REST GET ONE](https://user-images.githubusercontent.com/37195463/134795714-d1b82496-cdfe-4c0c-a433-4896335db840.png) 
![REST GET LIST](https://user-images.githubusercontent.com/37195463/134795711-f566d2ac-15c9-4013-9c9c-11740e056c2b.png)
 

## POST
![REST POST](https://user-images.githubusercontent.com/37195463/134795710-f78ea155-1c4c-4289-8bdc-1ebd053ae0c2.png)
 

## PUT & DELETE
> ResponseEntity 객체에 도서 데이터와 HttpStatus상태 그리고 링크정보를 담아 반환

![REST PUT DELETE](https://user-images.githubusercontent.com/37195463/134795713-b96d924d-5887-4d89-8571-cda3ddd30392.png) 
