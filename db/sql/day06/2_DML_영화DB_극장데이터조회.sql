# CGV강남 1상영관에 등록된 좌석을 조회하는 쿼리
select 
	se_name as "등록된 좌석" 
from 
	`seat` 
		join 
	screen on se_sc_num = sc_num 
		join 
	theater on sc_th_num = th_num
where 
	th_name = "CGV강남" and sc_name = 1;

# CGV강남에 등록된 좌석을 조회하는 쿼리
select 
	sc_name as "상영관" ,se_name as "등록된 좌석" 
from 
	`seat` 
		join 
	screen on se_sc_num = sc_num 
		join 
	theater on sc_th_num = th_num
where 
	th_name = "CGV강남";
    
# CGV강남에 등록된 좌석수를 조회하는 쿼리
select
	count(*) 
from 
	`seat` 
		join 
	screen on se_sc_num = sc_num 
		join 
	(select * from theater) as th on sc_th_num = th_num
where 
	th_name = "CGV강남";
    
# 웡카를 상영중인 영화관을 조회하는 쿼리
SELECT DISTINCT
    mo_title AS '영화', th_name AS '상영극장'
FROM
    `theater`
        JOIN
    `screen` ON sc_th_num = th_num
        JOIN
    `schedule` ON sh_sc_num = sc_num
        JOIN
    `movie` ON sh_mo_num = mo_num
WHERE
    mo_title = '웡카';
    
# CGV강남 1상영관에 웡카 상영 시간을 조회하는 쿼리
select 
	mo_title as "영화", th_name as '극장' ,sc_name as '상영관', sh_date as '상영일',sh_time as '상영 시작시간' 
from 
	`schedule` 
		join 
	`screen` on sh_sc_num = sc_num 
		join 
	`theater` on sc_th_num = th_num
		join
	`movie` on mo_num = sh_mo_num
where 
	th_name = "CGV강남" 
		and 
	sc_name = 1
		and
	mo_title = "웡카";
    
# CGV강남 1상영관에 있는 좌석들을 조회하는 쿼리
select 
	se_name as "좌석" 
from 
	`seat` 
		join 
	screen on se_sc_num = sc_num 
		join 
	theater on sc_th_num = th_num
where 
	th_name = "CGV강남" and sc_name = 1;

# 2월9일 10:30분 CGV강남 1상영관에서 상영하는 웡카를 예매한 좌석들을 조회
select 
	th_name as '극장' , sc_name as '상영관' , sh_date as '상영일', sh_time as '시간' ,mo_title as '영화' , se_name as '예매한 좌석' 
from 
	`ticketing_seat` 
		join 
	`seat` on ts_se_num = se_num 
		join 
	screen on sc_num = se_sc_num
		join 
	`schedule` on sh_sc_num = sc_num 
		join 
	theater on th_num = sc_th_num 
		join 
	movie on mo_num = sh_mo_num
where 
	sh_date = "2024-02-09" and sh_time = "10:30" 
		and th_name = "CGV강남" and sc_name = "1" 
        and mo_title = "웡카"  and se_num = ts_se_num;

# 2월9일 10:30분 CGV강남 1상영관에서 상영하는 웡카 예매 가능한 좌석을 조회하는 쿼리
select 
	th_name as '극장' , sc_name as '상영관' , sh_date as '상영일', sh_time as '시간' ,mo_title as '영화' , se_name as "예매 가능 좌석" 
from 
	`seat` 
		join 
	screen on se_sc_num = sc_num 
		join 
	theater on sc_th_num = th_num
		join
	`schedule` on sh_sc_num = sc_num
		join
	`movie` on sh_mo_num = mo_num
		left join
	`ticketing_seat` on ts_se_num = se_num
where 
	th_name = "CGV강남" 
		and 
	sc_name = 1 
        and 
	sh_date = '2024-02-09' 
        and 
	sh_time = '10:30'
		and
	se_num not in (select ts_se_num from ticketing_seat);

# 1번 스케쥴에서 좌석들 예약 상태를 확인하는 쿼리
select 
	se_name as '좌석', ts_ti_num as "예약번호"
from 
	`schedule` 
		join
	ticketing on ti_sh_num = sh_num
		join
	screen on sc_num = sh_sc_num
		join
	seat on se_sc_num = sc_num
		left join
	ticketing_seat on ts_se_num = se_num
where 
	sh_num = 1;

/* 선생님 코드*/    
SELECT 
    *
FROM
    `seat`
        JOIN
    `screen` ON sc_num = se_sc_num
        JOIN
    `schedule` ON sh_sc_num = sc_num
        LEFT JOIN
	(SELECT 
		*
	FROM
		ticketing_seat
			JOIN 
		ticketing ON ti_num = ts_ti_num
	WHERE
		ti_sh_num = 1) AS t ON ts_se_num = se_num
WHERE
    sh_num = 1;
    
# abc123회원이 예매한 영화 목록을 조회하는 쿼리
select * from `movie` 
join `schedule` on sh_mo_num = mo_num
join `ticketing` on ti_sh_num = sh_num
where
	ti_me_id = 'abc123';
    
# 1번 상영(웡카, CGV강남 1상영관 10:30 스켸쥴)이 예매된 수량을 조회
select sum(ti_adult) + sum(ti_teenager) as '예매수량 'from ticketing where ti_sh_num = 1;

# 폴 킹이 감독으로 연출한 영화를 조회하는 쿼리 
SELECT 
    mo_title AS '감독 참여작'
FROM
    movie
        JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
		JOIN
    `character` ON mp_ch_num = ch_num
WHERE
    ch_name = '폴 킹' AND mp_role = '감독';

# 장르별 등록된 영화 개수
SELECT 
    *
FROM
    `genre`
        LEFT JOIN
    genre_include ON gi_ge_name = ge_name;

SELECT 
    ge_name, COUNT(gi_mo_num)
FROM
    `genre_include`
        RIGHT JOIN
    `genre` ON ge_name = gi_ge_name
GROUP BY ge_name;

# 환타지로 등록된 모든 영화를 조회하는 쿼리
SELECT 
    *
FROM
    `movie`
        JOIN
    genre_include ON gi_mo_num = mo_num
WHERE
    gi_ge_name = '환타지';
    
# 개봉 예정인 영화를 조회하는 쿼리 
select * from `movie` where mo_date > now();   
    
# 상영 예정인 영화를 조회하는 쿼리
select distinct mo_title as '상영 예정작' from `schedule` join `movie` on sh_mo_num = mo_num
where sh_date > now();

# 전체 관람가 영화를 조회하는 쿼리
select * from `movie` where mo_ag_name = "전체관람가";

# 영화 제목에 카를 포함하는 영화를 조회하는 쿼리
select * from `movie` where mo_title like '%카%';