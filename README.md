# 도서목록 관리 RESTFUL API 설계

> 도서 목록 관리를 위해 RESTful API 구현


## 1. 도서목록
![book list](https://user-images.githubusercontent.com/37195463/135093257-a3904c57-2628-463e-8d45-479a35555c96.png)

## 주요내용
+ 도서 데이터 조회, 추가, 삭제, 수정 기능 구현 및 JSON 타입으로 Response
+ API Swagger를 이용하여 URL 리스트를 문서로 자동화
+ 다양한 클라이언트 환경에서 통신을 할 수 있어야 하므로 이러한 멀티 플랫폼에 대한 지원을 위해 도서목록 관리 서비스를 RESTful API로 설계
+ HATEOAS를 통해 관련된 자원의 링크정보를 제공


## 사용 언어
> JAVA 8  
> HTML/CSS

## 사용 라이브러리 및 프레임워크
> Spring Boot 2.5.2  
> Spring Data JPA  
> MySQL  
> ThymeLeaf  
> Lombok  
> Hateoas  


## 2. 도서 등록
![도서 등록](https://user-images.githubusercontent.com/37195463/134950275-f42f56c9-a27f-46b1-b7a9-5ca7b3aa99d5.png)

## 3. 도서 상세정보
![도서 상세정보](https://user-images.githubusercontent.com/37195463/134950277-d7f61f23-6d2b-47bd-876c-742ce535b041.png)

## 4. 도서 검색
![도서 검색](https://user-images.githubusercontent.com/37195463/134950273-c15e85e4-f4ef-40a5-9e23-042b9c5bc427.png)

## 5. RESTful API
+ API Swagger를 이용하여 URL 리스트를 문서로 자동화

![RESTAPI1](https://user-images.githubusercontent.com/37195463/134950271-3fa0c993-945f-40b5-a356-19c2178fb4d3.png)

+ JSON 타입으로 Response

![RESTAPI2](https://user-images.githubusercontent.com/37195463/132295058-119fadf4-4682-43f2-80d7-10e258f13dd4.png)

## GET
> ResponseEntity 객체에 self 링크정보가 추가된 book 인스턴스와 HttpStatus.OK 를 담아 반환

![REST GET ONE](https://user-images.githubusercontent.com/37195463/134795714-d1b82496-cdfe-4c0c-a433-4896335db840.png) 

> ResponseEntity 객체의 body부분에 books 리스트의 CollectionModel이 담고 추가적으로 HttpStatus.OK 를 담아 반환

![REST GET LIST](https://user-images.githubusercontent.com/37195463/134795711-f566d2ac-15c9-4013-9c9c-11740e056c2b.png)
 

## POST
> ResponseEntity 객체에 self 링크정보가 추가된 newbook 인스턴스와 HttpStatus.CREATED 를 담아 반환

![REST POST](https://user-images.githubusercontent.com/37195463/134795710-f78ea155-1c4c-4289-8bdc-1ebd053ae0c2.png)
 

## PUT
> 수정 후 ResponseEntity 객체에 self 링크정보가 포함된 book 인스턴스와 HttpStatus.OK 를 담아 반환

![REST PUT](https://user-images.githubusercontent.com/37195463/135095317-aba03b72-772a-409e-aa18-667c729b9e80.png)

## DELETE
> 삭제 시 ResponseEntity 객체에 HttpStatus.OK 를 담아 반환

![REST DELETE](https://user-images.githubusercontent.com/37195463/135095322-d9184cbf-e04c-49ac-b62a-2a7d750b5ff7.png)
