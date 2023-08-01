--테이블 생성 
--DDL은 실행과 동시에 AUTO COMMIT 됨.
CREATE TABLE dept2 (
-- 컬럼명 데이터 타입 (자리수)
    dept_id   NUMBER(4),
    dept_name VARCHAR2(30)
);

SELECT
    *
FROM
    user_tables;


--테이블 생성2
--NOT NULL은 테이블 생성시에만 지정가능
CREATE TABLE member (
--  컬럼이름 데이터 타입(값) CONSTRAINT 테이블명_컬럼명_제약타입 제약타입 풀네임
    member_id  VARCHAR2(10)
        CONSTRAINT member_id_pk PRIMARY KEY,
    passwd     VARCHAR2(20) NOT NULL,
    name       VARCHAR2(20) NOT NULL,
    email      VARCHAR2(30)
        CONSTRAINT member_email_uk UNIQUE,
    gender     VARCHAR2(1)
        CONSTRAINT member_gender_ck CHECK ( gender IN ( 'M', 'F' ) ),
    regdate    DATE DEFAULT sysdate,
    -- 참조하는 테이블(부모테이블)의 pk값을 허용하는 제약조건 : fk 
    -- 참조하는 컬럼의 데이터형과 데이터타입이 일치하여야한다
    manager_id NUMBER(6)
        CONSTRAINT member_manager_fk
            REFERENCES employees ( employee_id )
);

DESC employees;

INSERT INTO member (
    member_id,
    passwd,
    name,
    email,
    gender,
    manager_id
) VALUES (
    'bangry313',
    '1111',
    '송우성',
    'bangry313@gmail.com',
    'M',
    100
);

INSERT INTO member (
    member_id,
    passwd,
    name,
    email,
    gender,
    regdate,
    manager_id
) VALUES (
    'bangry314',
    '1111',
    '송우성',
    'bangry314@gmail.com',
    'M',
    TO_DATE('2023-06-08', 'YYYY-MM-DD'),
    100
);

CREATE TABLE member (
    member_id  VARCHAR2(10),
    passwd     VARCHAR2(20) NOT NULL,
    name       VARCHAR2(20) NOT NULL,
    email      VARCHAR2(30),
    gender     VARCHAR2(1),
    regdate    DATE DEFAULT sysdate,
    manager_id NUMBER(6)
);

ALTER TABLE member ADD (
--CONSTRAINT 제약조건이름 제약조건타입 (컬럼명)
    CONSTRAINT member_id_pk PRIMARY KEY ( member_id ),
    CONSTRAINT member_email_uk UNIQUE ( email ),
    CONSTRAINT member_gender_ck CHECK ( gender IN ( 'M', 'F' ) ),
    CONSTRAINT member_manager_fk FOREIGN KEY ( manager_id )
        REFERENCES employees ( employee_id )
);


--개발의 편의성을 위해 제약조건 비활성화

ALTER TABLE member DISABLE CONSTRAINT member_id_pk DISABLE CONSTRAINT member_email_uk DISABLE CONSTRAINT member_gender_ck DISABLE CONSTRAINT

member_manager_fk;

SELECT
    *
FROM
    user_constraints
WHERE
    table_name = 'MEMBER';

-- 테이블 날려버리기
DROP TABLE member;


--테이블 삭제시 제약조건도 같이 삭제
DROP TABLE member CASCADE CONSTRAINTS;

-- 테이블 생성시 더블쿼터를 사용해서 테이블명을 소문자로 만들면
-- 테이블상에서도 소문자로 표기됨
CREATE TABLE "abc" (
    num NUMBER(10)
);

SELECT
    *
FROM
    user_tables;

--시퀸스 생성해보기
CREATE SEQUENCE member_id_seq START WITH 100 INCREMENT BY 10;
    
--딕셔너리 조회
SELECT
    *
FROM
    user_sequences;

SELECT
    member_id_seq.NEXTVAL
FROM
    dual;

SELECT
    member_id_seq.CURRVAL
FROM
    dual;    
    
--뷰 생성
--보안상 or 복잡한 쿼리를 중복사용하기 위해
CREATE OR REPLACE VIEW emp_view AS
    SELECT
        employee_id,
        last_name,
        department_id
    FROM
        employees
    WHERE
        department_id = 10;

--뷰생성2
CREATE OR REPLACE VIEW dept_detail_view AS
    SELECT
        e.employee_id,
        e.last_name,
        d.department_name,
        l.city,
        l.state_province,
        c.country_name
    FROM
             employees e
        JOIN departments d ON e.department_id = d.department_id
        JOIN locations   l ON d.location_id = l.location_id
        JOIN countries   c ON l.country_id = c.country_id
        JOIN regions     r ON c.region_id = r.region_id;
    
--뷰 생성3
-- 10번 부서의 사원에 대해서만 INSERT, UPDATE 할 수 있는 뷰 생성
CREATE OR REPLACE VIEW emp_view AS
    SELECT
        employee_id,
        last_name,
        email,
        hire_date,
        job_id,
        department_id
    FROM
        employees
    WHERE
        department_id = 10
WITH READ ONLY;
    
--emp view 조회
SELECT
    *
FROM
    emp_view;

--emp INSERT 해보기
INSERT INTO emp_view (
    employee_id,
    last_name,
    email,
    hire_date,
    job_id,
    department_id
) VALUES (
    employees_seq.NEXTVAL,
    'jack',
    'jack@korea.com',
    sysdate,
    'AD_VP',
    10
);

--dept_detail_view 조회
SELECT
    *
FROM
    dept_detail_view;
 
--모든 view 조회
SELECT
    *
FROM
    user_views;
    
    
    
    -- 인덱스에서 사용하는 가상컬럼(rowid) 조회
SELECT
    ROWID,
    employee_id
FROM
    employees;
-- 딕셔너리로부터 인덱스 조회
SELECT
    *
FROM
    user_indexes
WHERE
    table_name = 'EMPLOYEES';
-- 수동 인덱스 생성
CREATE INDEX emp_salary_idx ON
    employees (
        salary
    );

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    salary BETWEEN 10000 AND 12000;
    
    
-- 자동 인덱스 사용
SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    email = 'JSEO';

SELECT
    ROWID,
    employee_id
FROM
    employees;

SELECT
    ROWNUM,
    employee_id
FROM
    employees;





-- 주의
-- 첫번째 행의 rownum이 1이므로
-- 1 > 1은 false가 되어 rownum은 더이상 증가하지 않으며, 하나의 행도 반환되지 않음
SELECT
    ROWNUM,
    employee_id,
    first_name
FROM
    employees
WHERE
    ROWNUM >= 108;



--서브쿼리로 로우넘 조회
--사원 5명만 조회
SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            employees
        ORDER BY
            salary DESC
    )
WHERE
    ROWNUM <= 5;
    
    
    -- 급여순으로 페이징 처리 ( 10개씩 잘라서 조회하기)
SELECT
    page,
    employee_id,
    first_name,
    salary
FROM
    (
        SELECT
        -- CEIL :올림 기능 0.5-> 1
            ceil(ROWNUM / 10) page,
            employee_id,
            first_name,
            salary
        FROM
            (
                SELECT
                    ROWNUM,
                    employee_id,
                    first_name,
                    salary
                FROM
                    employees
                ORDER BY
                -- 필요에 따라 검색조건 추가
                    salary DESC
            )
    )
WHERE
    page = 2;
    
    
    -- 시노님 생성
CREATE SYNONYM emps FOR hr.employees;

SELECT
    *
FROM
    emps;
    
    
    -- 시노님 삭제
DROP SYNONYM emps;