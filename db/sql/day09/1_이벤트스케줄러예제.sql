# 1초마다 기간이 지난 인증번호를 삭제하도록 이벤트를 등록
create event delete_identify
on schedule every 1 second
do
	delete from `identify` where idf_limit <= now();
    
select * from information_schema.events;

# 이벤트 삭제
drop event delete_identify;

# 지정 시간에 이벤트가 1번만 실행되고 이벤트를 삭제 : not preserve
create event delete_identify
on schedule
at '2024-02-15 09:45:00'
on completion not preserve
do
	delete from `identify` where idf_limit <= now();
