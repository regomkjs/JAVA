use shop;

# 제품을 추가하는 프로시저
# 제품 코드는 영문3자리(주어짐), 숫자3자리(같은 카테고리로 등록된 제품들 수를 이용)
# 주어지는 정보 : 제품 코드 영문3자리, 제품명, 내용, 가격, 카테고리명
# 프로시저 실행 결과 : 제품이 등록
select * from product;

drop procedure if exists insert_product;

delimiter //
create procedure insert_product(
	in _code char(3),
    in _title varchar(20),
    in _content longtext,
    in _price int,
    in _categori varchar(20)
)
begin
	declare _count int;
    declare _pd_code varchar(20);
    declare _pd_ct_num int;
    # _categori와 일치하는 등록된 제품 수를 찾아 +1을 한 후 변수에 저장
    set _count = (select count(*) + 1 from product join `categori` on ct_num = pd_ct_num where ct_title = _categori);
	# _code와 _count를 이용하여 _pd_code를 생성
    # _count가 3자리가 아니면 앞에 '0'을 붙여서 3자리로 만든 후 제품 코드를 생성
    set _pd_code = concat(_code, lpad(_count,3,'0'));
    # 제품의 카테고리 번호
    set _pd_ct_num = (select ct_num from categori where ct_title = _categori);
    if _pd_ct_num is not null then
		insert into product(pd_code, pd_title, pd_content, pd_price, pd_ct_num)
        values(_pd_code, _title, _content, _price, _pd_ct_num);
	end if;
    
end //
delimiter ;

show procedure status;

show create procedure insert_product;

# call insert_product('abc', '수정펜', '수정펜입니다', 3000, '기타');
# call insert_product('abc', '수정펜', '수정펜입니다', 3000, '없는카테고리');
# select count(*) + 1 from product join `categori` on ct_num = pd_ct_num where ct_title = "기타";
# select count(*) + 1 from product where pd_ct_num = (select ct_num from categori where ct_title = "기타");


# 제품을 주문하는 프로시저
drop procedure if exists insert_order;

delimiter //
create procedure insert_order(
	in _count int,
    in _id varchar(13),
    in _pd_code varchar(20)
)
begin
	declare _price int;
    declare _day datetime;
    declare _stat varchar(15);
    set _price = (select pd_price from product where pd_code = _pd_code)*_count;
    set _day = now();
    set _stat = "결제완료";
    
    if _pd_code is not null then
		insert into `order`(od_day, od_stat, od_count, od_price, od_user_ID, od_pd_code) 
        values(_day,_stat,_count,_price,_id,_pd_code);
	end if;
end //
delimiter ;

call insert_order(3,'qwe123','abc004');