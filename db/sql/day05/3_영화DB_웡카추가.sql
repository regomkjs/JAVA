# 사용자가 아이디가 abc123, 비번이 asd123으로 회원가입 진행
# 사용자가 아이디가 qwe123, 비번이 qweqwe으로 회원가입 진행
insert into `member`
	values('abc123','asd123','user'),
		('qwe123','qweqwe','user');

# 관리자가 아이디 admin, 비번이 admin으로 회원가입을 진행
insert into `member`
	values('admin','admin','admin');
    
# CGV에서 영화 웡카를 관리자가 등록하려한다 이때 해야하는 쿼리를 순서대로 써보아라

# 연령등록
insert into `age`
	values("전체관람가"),("12세 이상 관람가"),("15세 이상 관람가"),("청소년 관람불가"),("제한관람가");

# 국가 등록
insert into `nation`
	values ("한국"), ('미국'),('영국') ,('일본'), ('중국');
    
# 장르 등록
insert into `genre`
	values('액션'),('범죄'),('SF'),("드라마"),("환타지"),("코미디"),("로맨스"),("스릴러"),("공포"),("멜로");
    
# 인물 등록
insert into `character`(ch_name, ch_birthday, ch_detail, ch_na_name)
	values ("폴 킹","1978-07-29","","미국"),
		("티모시 샬라메","1995-12-27","","미국"),
        ("칼라 레인","2009-04-20","","미국"),
        ("올리비아 콜맨","1974-01-30","","영국"),
        ("톰 데이비스","1979-04-27","","영국"),
        ("휴 그랜트","1960-09-09","","영국"),
        ("셀리 호킨스","1976-04-27","","영국");

select * from `character`;
# 영화인 등록
insert into `movie_person` (mp_role, mp_ch_num)
	values ("감독",1),("배우",2),("배우",3),("배우",4),("배우",5),("배우",6),("배우",7);
        
# 영화 등록
insert into `movie`(mo_title, mo_date, mo_content, mo_running, mo_ag_name)
	values("웡카","2024-01-31","세상에서 가장 달콤한 여정",116,"전체관람가");
    
# 영화제작국가 등록
insert into `production_nation`(pn_na_name, pn_mo_num)
	values("미국",1),("영국",1);
        
# 참여영화인 등록
insert into `join` (jo_casting, jo_mo_num, jo_mp_num) 
	values ("",1,1),("",1,2),("",1,3),("",1,4),("",1,5),("",1,6),("",1,7);
 
# 장르포함 등록
insert into `genre_include`(gi_ge_name, gi_mo_num) 
	values ("환타지",1), ("드라마",1);

# 영화파일 등록
insert into `movie_file`(mf_filename, mf_type, mf_mo_num)
	values("t1","트레일러",1),
		("t2","트레일러",1),
        ("t3","트레일러",1),
        ("s1","스틸컷",1),
        ("s2","스틸컷",1),
        ("s3","스틸컷",1),
        ("s4","스틸컷",1);
	
select  distinct ch_name as 이름, mp_role as 참여 from `movie`
			join `join` on jo_mo_num = mo_num
            join `movie_person` on jo_mp_num = mp_num
            join `character` on mp_ch_num = ch_num;

