use community;
# 공지 커뮤니티 1페이지에 등록된 게시글 목록을 조회하는 쿼리
select * from `board` join community on co_num = bo_co_num where co_name = "공지" order by bo_num desc limit 0,10; 

# 3번 게시글을 상세조회하는 쿼리
update `board` set bo_view = bo_view + 1 where bo_num = 3; 
select * from `board` where bo_num = 3;

# abc123회원이 3번 게시글에 확인했습니다 라고 댓글을 달았을 때 쿼리
insert into `comment` values(null,3,'abc123','확인했습니다');

# 3번 게시글에 등록된 댓글 1페이지를 조회하는 쿼리
select * from `comment` where cm_bo_num = 3 order by cm_num desc limit 0,5;

# 신고 사유 등록
insert into report_type values('욕설'),('허위사실유포'), ('광고'),('음란'),('커뮤니티에 맞지 않음'),('기타');

# admin이 1번 댓글을 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_target)
values('admin','기타','comment','',1);

# 관리자가 신고내역을 조회
select * from report where rp_state = '신고접수';

# 관리자가 1번 신고내역을 '신고반려'로 처리
update `report` set rp_state = '신고반려' where rp_num = 1;

# abc123회원이 1번 게시글을 '기타', '내용없음' 으로 신고 
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_target)
values('abc123','기타','board','내용없음',1);
# qwe123회원이 1번 게시글을 '기타', '내용없음' 으로 신고 
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_target)
values('qwe123','기타','board','내용없음',1);
# admin 관리자가 1번 게시글을 '기타', '내용없음' 으로 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_target)
values('admin','기타','board','내용없음',1);
# 관리자가 1번 게시글 신고 내역을 모두 '신고처리'로 처리
update `report` set rp_state = "신고처리" 
where rp_table = 'board' and rp_target = 1 and rp_state = '신고접수';

# 신고처리된 게시글의 신고수를 수정 
update 
	board 
set 
	bo_report_count = (select 
			count(*) 
		from 
			`report` 
        where 
			rp_target = 1 
            and rp_table = 'board' 
            and rp_state = '신고처리') 
where 
	bo_num = 1;

# qwe123회원이 회원을 탈퇴
-- delete from `report` where rp_me_id = 'qwe123';
-- delete from `recommend` where re_me_id = 'qwe123';
-- delete from `comment` where cm_me_id = 'qwe123';
-- delete from `file` where fi_bo_num = (select bo_num from board where bo_me_id = 'qwe123');
-- delete from `board` where bo_me_id = 'qwe123';
-- delete from `member` where me_id = 'qwe123';
update `member` set me_ms_state = "탈퇴" where me_id = 'qwe123';

# 3번 신고된 게시글을 삭제하고 작성자를 기간정지
# 1번 게시글을 삭제하기 위해 1번 게시글에 달린 댓글들을 삭제
delete from `comment` where cm_bo_num = 1;
# 1번 게시글을 삭제하기 위해 1번 게시글을 추천한 추천 정보를 삭제
delete from `recommend` where re_bo_num = 1;
# 1번 게시글 작성자 상태 변경, 게시글삭제
update `member` set me_ms_state = '기간 정지' where me_id = (select bo_me_id from board where bo_num = 1);
delete from `board` where bo_num = 1;
# 상태에 따른 정지
update `member` set me_stop = date_add(now(), interval 1 month) where me_ms_state = '기간 정지' and me_stop is null;