use community;

# 회원 상태 추가
insert into member_state values("이용 중"),("기간 정지"),("영구 정지"),("탈퇴");

# 아이디 : abc123, 비번 : abc123 이메일 : abc123@kh.co.kr
# 아이디 : qwe123, 비번 : qwe123 이메일 : qwe123@kh.co.kr
# 아이디 : admin, 비번 : admin 이메일 : admin@kh.co.kr
insert into `member` (me_id, me_ms_state, me_pw,me_email,me_authority) 
values ('abc123', '이용 중' ,'abc123', 'abc123@kh.co.kr', 'user'),
('qwe123', '이용 중' ,'qwe123', 'qwe123@kh.co.kr', 'user'),
('admin', '이용 중' ,'admin', 'admin@kh.co.kr', 'admin');

# 관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)
insert into `community`(co_name) values('공지');
insert into `community`(co_name) values('자유');
insert into `community`(co_name) values('토론');
insert into `community`(co_name) values('공부');

# abc123회원이 자유 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 테스트, 내용 : 테스트 입니다. 첨부파일 : 없음
insert into `board`(bo_co_num, bo_me_id,bo_title,bo_content)
values(2,'abc123','테스트','테스트 입니다.');

insert into `board`(bo_co_num, bo_me_id,bo_title,bo_content)
select co_num,'abc123','테스트','테스트 입니다.' from community where co_name = '자유';

# admin 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항 , 내용 : 공지사항 입니다. 첨부파일 : 공지사항1.jpg
# 첨부파일은 서버업로드 되면 현재 날자를 기준으로 폴더를 생성해서 업로드 함
# 업로드된 첨부파일은 /2024/02/14/파일명으로 저장
insert into `board`(bo_co_num, bo_me_id,bo_title,bo_content)
values(1,"admin","공지사항","공지사항 입니다.");

insert into `file`(fi_bo_num, fi_name, fi_ori_name)
values(3,'/2024/02/14/공지사항1.jpg','공지사항1.jpg');

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리
select co_name 커뮤니티, board.* from `board` join `community` on co_num = bo_co_num where co_name = '공지';
# 공지 커뮤니티에 등록된 게시글중 1페이지에 해당하는 게시글을 조회하는 쿼리
select co_name 커뮤니티, board.* from `board` join `community` on co_num = bo_co_num where co_name = '공지' order by bo_num desc limit 0,10 ;
# 3번 게시글을 상세조회 했을 때 실행되는 쿼리
update `board` set bo_view = bo_view + 1 where bo_num = 3;
select * from `board` where bo_num = 3;

# 게시글 목록에서 abc123 아이디를 클릭했을 때 실행되는 쿼리
select board.* from `board` join `member` on bo_me_id = me_id where me_id = "abc123" order by bo_num desc limit 0,10 ; 

# qwe123회원이 1번 게시글의 추천 버튼을 클릭 했을 때 실행되는 쿼리
select count(*) from `recommned` where re_me_id = 'qwe123' and re_bo_num = 1;
update `recommned` set re_state = if(re_state = 0, 1, 0) where re_me_id = 'qwe123' and re_bo_num = 1;
insert into `recommend`(re_me_id, re_bo_num, re_state) values ('qwe123','1',1);


# 아이디와 게시글이 주어졌을 때 추천을 추가하거나 수정하는 프로시저
drop procedure if exists board_recommend;

delimiter //
create procedure board_recommend(
	in _id varchar(13),
    in _bo_num int,
    in _state int # 1이면 추천, -1이면 비추천
)
begin
	declare _num int;
	set _num = (select re_num from `recommend` where re_me_id = _id and re_bo_num = _bo_num);
    if _num is null then
		insert into `recommend`(re_me_id, re_bo_num, re_state) values (_id, _bo_num, _state);
    elseif (select re_state from `recommend` where re_num = _num) = _state then
		update `recommend` set re_state = 0 where re_me_id = _id and re_bo_num = _bo_num;
	else
		update `recommend` set re_state = _state where re_me_id = _id and re_bo_num = _bo_num;
	end if;
end //
delimiter ;

call board_recommend('abc123', 1, 1);
select * from recommend;