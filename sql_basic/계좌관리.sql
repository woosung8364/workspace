--1. 계좌 테이블 생성

CREATE TABLE account (
    account_num  VARCHAR2(20) ,
    name  VARCHAR2(10)  ,
    password  VARCHAR2(20) , 
    rest_money NUMBER(38) , 
    borrow_money NUMBER(38)  NOT NULL  ,
    type_id VARCHAR2(20) NOT NULL 
    
);

-- #2. 제약조건 추가
ALTER TABLE account ADD (
    CONSTRAINT type_id CHECK (type_id IN (0 ,1)) ,
    CONSTRAINT account_num_uk UNIQUE (account_num)
);
    
DESC employees;

-- #3. 개발의 편의성을 위해 제약조건 활성화/비활성화..

ALTER TABLE account 
DISABLE CONSTRAINT type_id_ck
DISABLE CONSTRAINT account_num_uk;


--ENABLE CONSTRAINT ....
ENABLE CONSTRAINT type_id_ck
ENABLE CONSTRAINT account_num_uk;


--시퀸스 생성--
--계좌번호는 1000번부터 1씩 증가하게 설정됨
CREATE SEQUENCE account_num_seq START WITH 1000 INCREMENT BY 1;



--#4. 더미데이터 추가,수정,삭제
-- 계좌추가
INSERT INTO account (
    account_num ,
    name,
    password ,
    rest_money   ,
    borrow_money ,
    type_id
)

VALUES (
    account_num_seq.nextval ,
    '양우성' ,
    2234 ,
   100000000 ,
   -10000 , 
   1
 );
 

 --계좌 수정--
-- 계좌타입을 일반으로 바꾸기
 UPDATE account
 SET type_id='마이너스'
 WHERE account_num='1001';
 
-- 잔액 x 1.5 해보기
 UPDATE account
 SET  rest_money = rest_money* 1.5
 WHERE account_num=1001;

 
 --계좌 삭제--
 
 DELETE FROM account
 WHERE passwd=1234;

--전체 계좌갯수 조회
SELECT count(*) cnt
FROM account;


-- account 테이블 조회--
SELECT 
    account_num "계좌번호 ,
    name "계좌주명" ,
    password "비밀번호" ,
    rest_money "잔액" ,
    borrow_money "빌린금액"  ,
    type_id "계좌타입"
   
    FROM 
    account
    
    ORDER BY
    account_num;

--account 테이블 및 제약조건 삭제 --
DROP TABLE account CASCADE CONSTRAINTS;