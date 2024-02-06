# abc123 회원이 주문 내역을 확인하는 쿼리
select * from `order` where od_user_ID = "abc123";

# 기타에 포함된 모든 제품을 조회하는 쿼리
select * from `product` where pd_ct_num = 1;

# 분류가 기타, 자동차, 의류에 포함된 모든 제품을 조회하는 쿼리
select * from `product` where pd_ct_num = 1 or pd_ct_num = 3 or pd_ct_num = 5;
select * from `product` where pd_ct_num in (1, 3, 5);

# 등뢱된 제품들의 케테고리 번호를 조회하는 쿼리
select distinct pd_ct_num from `product`;

# 가격이 높은 순으로 제품을 정렬하는 쿼리
select * from `product` order by pd_price desc, pd_ct_num;

# 제품 페이지에서 1페이지에 있는 제품을 조회
select * from `product` limit 0,2;

# 2페이지에 있는 제품을 조회하는 쿼리
# 2(컨텐츠 개수) * (2(현재 페이지) - 1) = 시작 번지
select * from `product` limit 2, 2;

# 카테고리별 등록된 제품의 개수를 조회
select pd_ct_num as "카테고리 번호", count(pd_ct_num) as "제품수" from `product` group by pd_ct_num;

# 카테고리별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
select pd_ct_num, count(pd_ct_num) from `product` group by pd_ct_num  having count(pd_ct_num) >= 2;

# abc123 회원이 지금까지 주문한 총 금액을 조회하는 쿼리
select 
	od_user_ID as "구매자", sum(od_count) as "주문한 물건 개수" ,sum(od_price) as "총 금액" 
from 
	`order` 
where 
	od_user_ID = "abc123" and od_stat not in ("반품", "환불")
group by 
	od_user_ID;

# 제품별 판매된 개수를 조회하는 쿼리
select 
	od_pd_code as "제품코드", sum(od_count) as "판매 개수"
from
	`order`
where
	od_stat not in ("반품", "환불")
group by
	od_pd_codeidentify;

# 제품별 카테고리 명을 조회하기 위한 inner join 쿼리
select
	product.* , ct_title
from
	`categori`
join
	`product`
on  # product의 외래키를 categori의 기본키와 연결
	# 속성명이 다르면 테이블명을 생략할 수 있다
	pd_ct_num = ct_num;

# 기타로 등록된 제품들을 조회하는 쿼리
select * from `product` join `categori` on pd_ct_num = ct_num where ct_title = "기타";

# abc123회원이 주문한 제품 목록을 조회하는 쿼리
SELECT 
    *
FROM
    `order`
        JOIN
    `user` ON user_ID = od_user_ID
WHERE
    od_user_ID = 'abc123'
        AND od_stat NOT IN ('환불' , '반품');

# 각 제품별 판매된 개수
# 판매된 제품에 한해서
select pd_title as "제품명", sum(od_count) as "판매 수량" from `order` join `product` on pd_code = od_pd_code where od_stat not in ("환불","반품") group by pd_code;

# 모든 제품중에
select 
	pd_title as "제품명", ifnull(sum(od_count), 0) as "판매 수량" 
from 
	`product` 
		left join 
	`order` on pd_code = od_pd_code 
where 
	od_stat not in ("환불","반품") or od_stat is null 
group by 
	pd_code;
    
    
select 
	pd_title as "제품명", ifnull(sum(od_count), 0) as "판매 수량" 
from 
	`order`
		right join 
	`product`  on pd_code = od_pd_code 
where 
	od_stat not in ("환불","반품") or od_stat is null 
group by 
	pd_code;    


# 2024-02-06 수업 내용
# 모든 제품을 조회하는 쿼리
select * from product;

# 모든 카테고리를 조회하는 쿼리
select * from categori;

# 제품별 카테고리를 조회하는 쿼리. 
select 
	ct_title as "분류" , pd_title as "제품명" 
from 
	product 
		join 
	categori on ct_num = pd_ct_num;

# 기타 카테고리에 포함된 모든 제품을 조회
select 
	ct_title 카테고리 , pd_title 제품명, pd_content 내용, pd_price 가격 
from 
	product 
		join 
	categori on ct_num = pd_ct_num 
where 
	ct_title in ("기타");

# abc123회원이 주문한 제품 목록을 조회
SELECT 
    user_ID 회원, pd_title 제품명, od_stat 상태
FROM
    `order`
        JOIN
    `user` ON od_user_ID = user_ID
        JOIN
    product ON od_pd_code = pd_code
WHERE
    user_ID = 'abc123';

# 제품별 판매수량을 조회하는 쿼리
select 
	pd_title 제품명, ifnull(sum(od_count),0) 판매수량 
from 
	product 
		left join 
	`order` on od_pd_code = pd_code 
where od_stat not in("환불","반품") or od_stat is null
group by 
	pd_code;
    
# 인기 제품 조회. 인기 제품은 누적 판매량을 기준으로 상위 5개 제품
select 
	pd_title as '제품명', ifnull(sum(od_count),0) as '판매수량' 
from 
	product 
		left join 
	`order` on od_pd_code = pd_code 
where od_stat not in("환불","반품") or od_stat is null

group by 
	pd_code
order by 판매수량 desc, pd_price asc
limit 0,5;


# 가격이 제일 비싼 제품을 조회
select * from product order by pd_price desc limit 0,1;

select pd_title, ifnull(sum(od_count), 0) from `order` right join product on od_pd_code = pd_code group by pd_code having ifnull(sum(od_count), 0) >= 1;