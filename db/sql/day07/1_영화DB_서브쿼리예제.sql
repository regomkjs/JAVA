# 2월 9, 10일에 예매 가능한 영화 목록을 조회하는 쿼리
select distinct sh_date 일자, mo_title 영화 from `schedule` join movie on sh_mo_num = mo_num where sh_date between "2024-02-09" and "2024-02-10";

select distinct
	mo_title, sh_date
from
	(select 
		* 
	from 
        `schedule`
    where
		sh_date between "2024-02-09" and "2024-02-10") as sh
		join
	`movie` on sh_mo_num = mo_num;
    
    
    
# 영화관의 전체 좌석수와 전체 상영관 수를 현재 데이터를 기준으로 업데이트하는 쿼리
UPDATE `theater` 
SET 
    th_seat = (SELECT 
            COUNT(*)
        FROM
            `seat`
                JOIN
            screen ON se_sc_num = sc_num
        WHERE
            sc_th_num = 1),
    th_screen = (SELECT 
            COUNT(*)
        FROM
            `screen`
        WHERE
            sc_th_num = 1)
WHERE
    th_num = 1;


# 폴 킹 감독이 웡카 영화(1)에 감독으로 참여하는 쿼리
insert into `join` 
select 
	1, 
	`감독`, 
    1, 
	mp_num 
	from 
		`movie_person` 
			join 
		`character` on ch_num = mp_ch_num 
	where 
		ch_name = '폴 킹' and mp_role = '감독';

select mp_num from `movie_person` join `character` on ch_num = mp_ch_num where ch_name = '폴 킹' and mp_role = '감독';