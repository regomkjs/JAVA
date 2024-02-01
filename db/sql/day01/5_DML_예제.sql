/*
테이블 명만 쓰는 것과 DB명.테이블명을 쓰는 것의 차이
- 테이블명만 쓰는 경우는 내가 작업하려는 DB가 선택됐을 때
- DB명.테이블명은 현재 선택된 DB와 상관없이 작업할 수 있다
*/

# insert into `test`.`member`() values();

use test;
# 테이블에 등록된 컬럼 순서에 상관 없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨
insert into `member`(ID,PW, email,reg_date) values("abc","def","abc@naver.com",now());
insert into `member`(PW,ID,reg_date, email) values("abc123","def123",now(),"abc123@naver.com");
# 속성명을 생략한 대신, 테이블에 등록된 컬럼 순서대로 값들을 넣어주어야 함
insert into member values("123","456","123@gmail.com",now());
# now()를 이용해 날짜를 문자열에 저장하면 날짜가 문자열로 변환되어 문제가 없음

# 날짜형태가 아닌 문자열을 datetime에 저장하려 하면 에러 발생
# insert into member values("123","456",now(),"123@gmail.com");

# 날짜형태인 문자열을 넣으면 정상 동작
insert into member values("12341","456124",now(),"2024-01-01 03:03:03");


# 아이디가 12341인 회원의 이메일을 12341@naver.com으로 수정하는 쿼리
update 
	`member` 
set 
	email = "12341@naver.com" 
where 
	ID = "12341"; 
    
# 아이디가 abc인 회원의 비번을 IDabc, 이메일을 IDabc@naver.com으로 수정하라	
update
	`member`
set
	PW = "IDabc",
    email = "IDabc@naver.com"
where
	ID = "abc";


# 아이디가 abc인 회원의 정보를 삭제하는 쿼리
delete
from
	`member`
where
	ID = "abc";
    
    
# member 테이블을 조회
select ID, PW, email, reg_date from member;