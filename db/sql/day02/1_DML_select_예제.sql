use test;
# 가입된 회원 전체를 조회
SELECT 
    *
FROM
    member;

# 아이디가 123인 회원의 정보를 조회
SELECT 
    *
FROM
    member
WHERE
    ID = '123';
    
# 모든 회원의 아이디와 이메일을 조회
SELECT 
    ID, email
FROM
    member;
    
# 2024년도 1월에 가입한 회원
SELECT 
    *
FROM
    member
WHERE
    reg_date LIKE '2024-01%';
    
# 이메일이 naver인 회원
SELECT 
    *
FROM
    member
WHERE
    email LIKE '%_@naver%';