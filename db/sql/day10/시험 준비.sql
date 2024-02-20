create user 'kim'@'localhost' identified by 'abc';

#kim 계정에 모든 DB에 접근하는 권한을 부여
grant all privileges on *.* to 'kim'@'localhost';

#kim 계정에 account DB에 접근하는 권한을 부여
grant all privileges on account.* to 'kim'@'localhost';

#kim 계정에 계정 생성 권한만 부여
grant create user on *.* to 'kim'@'localhost';


# 각 DB별 사용자 계정 권한을 조회하는 쿼리
# 모든 DB 권한을 갖는다면 조회되지 않는다.
select * from mysql.db;

# MySQL에서는 AND 연산자가 OR 연산자보다 우선 순위가 높다
# A or B and C와 (A or B) and C는 결과가 다르다
# A or (B and C) 와  (A and C) or (B and C)

# 제품명에 %가 포함된 제품을 조회하는 쿼리 : %를 문자로 인식하기 위해선 \를 붙여야함
select * from product where pd_title like '%\%%';

# 제품 가격순으로 순위를 추가해서 조회
select * from
(select row_number() over(order by pd_price desc) as "순위",product.* from product) as tmp where 순위 <= 3;

# 각 카테고리별 제품 가격 평균을 구하여라
select ct_title , floor(avg(pd_price)) from product join categori on ct_num = pd_ct_num group by pd_ct_num;

# 각 카테고리별 제품 평균가격이 6500원 이상인 카테고리를 조회
select ct_title , floor(avg(pd_price)) from product join categori on ct_num = pd_ct_num group by pd_ct_num
having floor(avg(pd_price)) >= 6500 ;