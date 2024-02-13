create user 'regom'@'%' identified by 'abc123'; # 사용자 추가

select user, host from mysql.user;

set password for 'regom'@'%' = 'def123'; # 사용자 비번 변경

drop user 'regom'@'%'; # 사용자 삭제

# 권한 부여 : grant 권한종류 DB명.테이블명 to '사용자명'@'호스트명';
grant all privileges on `shop`.product to 'regom'@'%';

# 권한 제거 : revoke 권한종류 on DB명.테이블명 from '사용자명'@'호스트명';
revoke all privileges on `shop`.product from 'regom'@'%';

grant all privileges on `shop`.* to 'regom'@'%';