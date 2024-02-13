# 카테고리별 등록된 제품 수를 조회하는 쿼리
select ct_title ,count(ct_num) from `product` left join product on pd_ct_num = ct_num group by ct_num;