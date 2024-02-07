# 영화 웡카의 기본 정보를 검색하는 쿼리
select * from `movie` where mo_title = "웡카";

# 영화 웡카에 출연한 배우 및 감독
select 
	mo_title as 출연작, mp_role as 역할, ch_name as 이름 
from 
	`join` 
		join 
	`movie` on mo_num = jo_mo_num
		join 
	`movie_person` on mp_num = jo_mp_num
		join 
	`character` on mp_ch_num = ch_num
 where
	mo_title = "웡카";