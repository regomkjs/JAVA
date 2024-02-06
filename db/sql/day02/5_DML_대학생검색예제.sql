# 컴퓨터 공학 고길동 학생이 수강신청한 강의개수를 조회하는 쿼리

select 
	st_name as '학생명' , count(st_name) as '등록한 강의수'  
from 
	`student` 
		join `course` 
			on co_st_num = st_num 
where 
	st_major = "컴퓨터공학" and st_name ="고길동" 
group by 
	st_name;
    
# 컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리

select 
	st_name as '이름', st_major as "전공", sum(le_point) as "신청 학점"
from
	`course`
		join `student` on co_st_num = st_num
		join `lecture` on co_le_num = le_num
where
	st_major = "컴퓨터공학" and st_name = "고길동"
group by
	st_name;

# 24학년 신입생을 조회하는 쿼리
select * from `student` where st_num like "2024%" and st_grade = 1;

# 각 전공별 학생수를 조회하는 쿼리
select st_major as "전공명" , count(st_major) as "전공별 학생수"  from `student` group by st_major;

# 강의별 수강신청한 학생수
select le_title as "강의명" , count(*) as "학생수" from `course` join `lecture` on co_le_num = le_num group by co_le_num;



# 2024-02-06 수업 내용

select * from student;

# 컴퓨터공학을 다니는 학생 정보를 조회하는 쿼리 (O)
select * from student where st_major = "컴퓨터공학";

# 컴퓨터공학을 다니는 1학년 학생정보 조회하는 쿼리 (O)
select * from student where st_major = "컴퓨터공학" and st_grade = 1;

# 컴퓨터공학 또는 화학공학을 다니는 1학년 학생 정보를 조회하는 쿼리 (O)
select * from student where st_grade = 1 and (st_major = "컴퓨터공학" or st_major = "화학공학");
select * from student where st_major in ("컴퓨터공학","화학공학") and st_grade = 1;

# 컴퓨터공학을 다니는 학생 수를 조회하는 쿼리 (O)
select st_major as "전공", count(*) as "학생 수" from student where st_major = "컴퓨터공학" group by st_major;

# 등록된 학과를 조회하는 쿼리 (O)
select st_major as "전공" from student group by st_major;
select distinct st_major as "전공" from student;

# 학생들이 3명이상 등록된 학과들을 조회 (X)
# having 사용을 생각 못함
select st_major as "전공" from student  group by st_major having count(*) >= 3;

# 컴퓨터개론을 수강하는 학생 수를 조회 (O)
select count(*) as "학생 수" from lecture join course on le_num = co_le_num where le_title = "컴퓨터 개론" group by co_le_num;
select count(*) from course join lecture on co_le_num = le_num where le_title = "컴퓨터 개론" group by co_le_num;

# 각 강의별 수강하는 학생수를 조회, 강의명과 학생수를 조회 (O)
select 
	le_title as "강의명", count(*) as "학생수" 
from 
	lecture 
		join 
	course on le_num = co_le_num 
group by 
	co_le_num;

# 홍길동 학생이 수강하는 강의 목록을 조회 (O)
select 
	st_name as '학생명' , le_title as '강의명'
from 
	course
	join lecture on le_num = co_le_num
    join student on st_num = co_st_num
where 
	st_name = "홍길동";
    
# 기계공학에 소속된 교수의 수를 조회 (O)
SELECT 
    pr_major AS '전공', COUNT(*) AS '교수 수'
FROM
    professor
WHERE
    pr_major = '기계공학';    

# 김교수가 강의하는 강의명을 조회 (O)
SELECT 
    pr_name, le_title
FROM
    lecture
        JOIN
    professor ON le_pr_num = pr_num
WHERE
    pr_name = '김교수';

select * from professor
