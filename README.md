# JpaPagenationExample

## 게시글, 댓글 모델의 뼈대

Jpa와 mariadb를 이용하였음.

Entity <--> Dto 전환을 위해 Mapstruct 를 이용함

Page 구현은 Jpa의 Pageable 인터페이스를 이용함. 


PostMan을 통해 테스트 완료, 컨트롤러에서 Page<Post> 자체를 return 하면 postman으로 봤을때 response 객체의 구조를 파악하기 어려웠음. 
이를 해결하기 위해 Dto 로 바꾸는 코드가 추가됨.


## MapStruct 레퍼런스

https://mapstruct.org/

https://velog.io/@cham/Java-MapStruct-%EC%82%AC%EC%9A%A9%EB%B2%95

https://www.skyer9.pe.kr/wordpress/?p=1596

## Jpa Pageable 레퍼런스

https://cheese10yun.github.io/spring-jpa-best-12/

https://gunju-ko.github.io/spring/2018/05/01/Spring-Data-JPA-Paging.html

https://wonit.tistory.com/483
  
 주의사항 : Pageable 은 jwt에도 있음, `import org.springframework.data.domain.Pageable` 이걸 해야함.
