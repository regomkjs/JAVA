/*
여러줄 주석
*/
# 데이터베이스 삭제 (있으면)
drop database if exists test;
# drop schema if exists `test`;

# 데이터베이스 추가 (없으면)
create database if not exists test;
# create schema if not exists `test`;


/*
zerofill
	- 앞에 0으로 채울 때 사용 
    - 5자리 숫자로 정한 경우, 1을 저장했을 때 나머지 4자리에 0으로 채워짐

unique 
	- 컬럼의 값들이 중복되면 안되는 경우 unique를 지정
    - 대학생의 주민번호
    
not null 
	- 비어 있으면 안되는 경우를 의미
    
primary key
	- 기본키
    - 제약조건으로 설정할 수도 있지만 컬럼명 옆에 지정할 수 있음
    - not null + unique 로 지정된 것과 같은 효과
    
auto_increment
	- 정수형 속성에 지정 가능, 기본키에만 추가할 수 있다.
    - 데이터를 추가할 때 기본키 값을 넣어주지 않으면 자동으로 1씩 증가되어 추가
*/ 

use test;

# 테이블 삭제 
drop table if exists `member`;
# 테이블 생성
create table if not exists `member`(
	ID varchar(13) primary key,
    PW varchar(15) not null,
    email varchar(30) not null unique
);

desc `member`;

drop table if exists board;
create table if not exists board(
	num int auto_increment,
    title varchar(50) not null,
    content longtext not null,
    `view` int not null default 0,
    writer varchar(13) not null,
    primary key(num),
    foreign key(writer) references `member`(ID)
);

desc board;

# member 테이블에 가입일 컬럼을 추가
alter table `member` add `date` datetime not null;
# member 테이블에 가입일을 의미하는 date를 reg_date로 변경
alter table `member` change `date` `reg_date` datetime not null;
# member 테이블에 불필요한 컬럼 count를 추가
alter table `member` add `count` int not null;
#  member 테이블에 불필요한 컬럼 count를 삭제
alter table `member` drop `count`;