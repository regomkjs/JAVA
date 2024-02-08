# 지역을 추가하는 쿼리(서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주)
insert into `region` 
	values ("서울"),("경기"),("인천"),("강원"),("대전/충청"),("대구"),("부산/울산"),("경상"),("광주/전라/제주");

# 극장을 추가하는 쿼리
# CGV강남, 서울특별시 강남구 역삼동, 좌석수 : 0, 상영관수 : 3, 서울
# CGV영등포, 서울특별시 영등포구 4가, 좌석수 : 0, 상영관수 : 4, 서울
insert into `theater`
	values (null,"CGV강남","서울특별시 강남구 역삼동",0,3,"서울"),
		(null,"CGV영등포","서울특별시 영등포구 4가",0,4,"서울");
        
# CGV강남에 상영관과 좌석을 추가하는 쿼리
# 1관 10좌석, 2관 12좌석, 3관 6좌석
# 1관 A1~A3, B1~B3, C1~C4
# 2관 A1~A4, B1~B4, C1~C4
# 3관 A1~A2, B1~B2, C1~C2
insert into screen
	values(null,1,10,1),(null,2,12,1),(null,3,6,1);
    
insert into seat (se_name, se_sc_num) values
("A1",1),("A2",1),("A3",1),
("B1",1),("B2",1),("B3",1),
("C1",1),("C2",1),("C3",1),("C4",1),

("A1",2),("A2",2),("A3",2),("A4",2),
("B1",2),("B2",2),("B3",2),("B4",2),
("C1",2),("C2",2),("C3",2),("C4",2),

("A1",3),("A2",3),
("B1",3),("B2",3),
("C1",3),("C2",3);
/*
서브 쿼리를 이용하여 CGV강남에 등록된 좌석수를 계산해서 영화관 전체 좌석수에 업데이트 하는 쿼리
	- 서브 쿼리로 A테이블을 업데이트 할 떄, 서브쿼리에 A테이블을 단순 이용하면 업데이트가 되지 않음
	- 이럴 때, A테이블이 아닌 A테이블을 조회한 결과를 이용하면 가능 
		- 서브쿼리가 select count(*) from A일 때, A 대신
		  select count(*) from (select * from A) as 임시이름
          을 이용해야 한다.
*/  
update `theater` 
set 
	th_seat = (select
			count(*) 
		from 
			`seat` 
				join 
			screen on se_sc_num = sc_num 
				join 
			(select 
				* 
			from 
				theater) as th on sc_th_num = th_num
		where 
			th_name = "CGV강남") 
where 
	th_name = "CGV강남";


# CGV영등포에 상영관과 좌석을 추가하는 쿼리
# 1관 14좌석, 2관 16좌석, 3관 10좌석, 4관 25좌석
# 1관 A1~A3, B1~B3, C1~C4, D1~D4
# 2관 A1~A4, B1~B4, C1~C4, D1~D4
# 3관 A1~A2, B1~B2, C1~C2, D1~D2, E1~E2
# 4관 A1~A5, B1~B5, C1~C5, D1~D5, E1~E5

insert into screen
	values(null,1,14,2),(null,2,16,2),(null,3,10,2),(null,4,25,2);

insert into seat (se_name, se_sc_num) values
("A1",4),("A2",4),("A3",4),
("B1",4),("B2",4),("B3",4),
("C1",4),("C2",4),("C3",4),("C4",4),
("D1",4),("D2",4),("D3",4),("D4",4),

("A1",5),("A2",5),("A3",5),("A4",5),
("B1",5),("B2",5),("B3",5),("B4",5),
("C1",5),("C2",5),("C3",5),("C4",5),
("D1",5),("D2",5),("D3",5),("D4",5),

("A1",6),("A2",6),
("B1",6),("B2",6),
("C1",6),("C2",6),
("D1",6),("D2",6),
("E1",6),("E2",6),

("A1",7),("A2",7),("A3",7),("A4",7),("A5",7),
("B1",7),("B2",7),("B3",7),("B4",7),("B5",7),
("C1",7),("C2",7),("C3",7),("C4",7),("C5",7),
("D1",7),("D2",7),("D3",7),("D4",7),("D5",7),
("E1",7),("E2",7),("E3",7),("E4",7),("E5",7);

update `theater` 
set 
	th_seat = (select
			count(*) 
		from 
			`seat` 
				join 
			screen on se_sc_num = sc_num 
				join 
			(select * from theater) as th on sc_th_num = th_num
		where 
			th_name = "CGV영등포") 
where 
	th_name = "CGV영등포";

# 상영을 추가
# CGV강남 1관 상영
# 웡카 - 2월 9일 10:30, 13:00, 15:30, 18:10, 20:30 
# 2관
# 웡카 - 2월 9일 11:30, 14:00, 16:30, 19:10, 21:30 
# 3관
# 웡카 - 2월 9일 12:20, 14:30, 17:30, 19:50

insert into `schedule` (sh_date, sh_time, sh_morning, sc_num, mo_num) 
values
("2024-02-09","10:30",1,1,1),("2024-02-09","13:00",0,1,1),
("2024-02-09","15:30",0,1,1),("2024-02-09","18:10",0,1,1),
("2024-02-09","20:30",0,1,1),

("2024-02-09","11:30",1,2,1),("2024-02-09","14:00",0,2,1),
("2024-02-09","16:30",0,2,1),("2024-02-09","19:10",0,2,1),
("2024-02-09","21:30",0,2,1),

("2024-02-09","12:20",0,3,1),("2024-02-09","14:30",0,3,1),
("2024-02-09","17:30",0,3,1),("2024-02-09","19:50",0,3,1);

select * from member;

insert into `price` values(null, '성인', 14000),(null, '청소년', 10000),(null, '성인조조', 11200), (null, '청소년조조', 8000);

# abc123 회원이 CGV강남 1상영관 10:30 영화를 성인2명, A1,A2를 예매
insert into `ticketing` values (null,2,0,22400,'abc123',1);

insert into `ticketing_seat` values(null, 1,1), (null, 2,1);