use shop;
show tables;

# 아이디가 admin이고 비번이 admin, 이메일이 admin@gmail.com, 번호가 010-0000-0000 인 회원 가입
insert into `user`( user_ID, user_pw, user_email, user_phone) 
	values ("admin","admin","admin@gmail.com","010-0000-0000");

# user admin의 권한을 관리자인 3등급으로 변경
UPDATE `user` 
SET 
    user_level = 3
WHERE
    user_ID = 'admin';
    
# 카테고리 기타인 스타벅스 텀블러 등록 
# 코드: abc001, 제품명: 텀블러, 가격 : 20000, 내용 : 스타벅스 텀블러, 분류: 기타
insert into `categori`(ct_title) values("기타");
select * from `categori`;

insert into `product`(pd_code, pd_title, pd_content,pd_price,pd_ct_num)
	values("abc001","텀블러","스타벅스 텀블러입니다.",20000,1);
select * from `product`;

# 분류 추가
# 분류 : 전자제품, 의류, 식품, 자동차
insert into `categori` values(null,"전자제품"), (null,"의류"), (null,"식품"), (null,"자동차");

# 제품 추가
# 코드 : abc002, 제품명 : 볼펜, 내용 : 모나미 볼펜, 가격: 1000, 카테고리 : 기타
# 코드 : abc003, 제품명 : 지우개, 내용 : 잘지워지는 지우개, 가격: 500, 카테고리 : 기타
# 코드 : elc001, 제품명 : 마우스, 내용 : 무선 마우스, 가격: 10000, 카테고리 : 전자제품
# 코드 : elc002, 제품명 : 키보드, 내용 : 기계식 키보드, 가격: 50000, 카테고리 : 전자제품
# 코드 : clo001, 제품명 : 모자, 내용 : 좋은 모자, 가격: 10000, 카테고리 : 의류
# 코드 : clo002, 제품명 : 셔츠, 내용 : 구김없는 셔츠, 가격: 50000, 카테고리 : 의류
# 코드 : foo001, 제품명 : 만두, 내용 : 고기만두, 가격: 10000, 카테고리 : 식품
# 코드 : foo002, 제품명 : 라면, 내용 : 맛있는 라면, 가격: 3000, 카테고리 : 식품
# 코드 : car001, 제품명 : 320i, 내용 : BMW 320i, 가격: 40000000, 카테고리 : 자동차
# 코드 : car002, 제품명 : G80, 내용 : 제네시스 G80, 가격: 70000000, 카테고리 : 자동차

insert into `product` 
	values("abc002","볼펜","모나미 볼펜",1000,1),
		("abc003","지우개","잘지워지는 지우개",500,1),
        ("elc001","마우스","무선 마우스",10000,2),
        ("elc002","키보드","기계식 키보드",50000,2),
        ("clo001","모자","좋은 모자",10000,3),
        ("clo002","셔츠","구김없는 셔츠",50000,3),
        ("foo001","만두","고기만두",10000,4),
        ("foo002","라면","맛있는 라면",3000,4),
        ("car001","320i","BMW 320i",40000000,5),
        ("car002","G80","제네시스 G80",70000000,5);

update `product` set pd_title = "방향제" , pd_content = "향기 좋음", pd_price = 5000 where pd_code = "car001";
update `product` set pd_title = "준대형 세단" where pd_code = "car002";
delete from `product` where pd_code = "car002";

# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.com
# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.com
insert into `user`(user_ID, user_pw, user_email, user_phone)
	values ("abc123", "abc123", "abc123@kh.com" , "010-1234-5678"),
		("qwe123", "qwe123", "qwe123@kh.com", "010-9876-5432");

update `user` set user_phone = "010-1234-5678" where user_ID = "abc123";
update `user` set user_phone = "010-9876-5432" where user_ID = "qwe123";
select * from `user`;

# abc123회원이 마우스를 장바구니에 2개 담았을 때 실행되는 쿼리
insert into cart (cr_count, cr_user_ID, cr_pd_code) 
	values (2,"abc123","elc001");
select * from `cart`;

# abc123회원이 마우스를 장바구니에 3개 담았을 때 실행되는 쿼리
update `cart` set cr_count = 3 where cr_user_ID = "abc123" and cr_pd_code = "elc001";
# abc123회원이 키보드를 장바구니에 1개 담았을 때 실행되는 쿼리
insert into `cart`(cr_count, cr_user_ID, cr_pd_code) values(1,"abc123","elc002");

# abc123회원이 장바구니에 담긴 모든 제품을 구매했을 때 실행되는 쿼리
insert into `order`(od_day, od_stat, od_count, od_price, od_user_ID, od_pd_code) 
	values(now(),"결제완료",3,30000,"abc123","elc001"),
		(now(),"결제완료",1,50000,"abc123","elc002");
delete from `cart` where cr_user_ID = "abc123";

select * from `cart`;
select * from `order`;