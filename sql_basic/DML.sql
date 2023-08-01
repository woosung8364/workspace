DESC departments;


--모든 제약조건 다보기
SELECT
    *
FROM
    user_constraints
--테이블 이름 검색할땐 대문자로 주어야한다
WHERE
    table_name = 'DEPARTMENTS';

-- 행 삽입해보기
-- INSERT INTO  (불러들일 테이블명) (컬럼A , 컬럼 B ......) << 생성자와 비슷
-- VALUES (컬럼A값 , 컬럼B에 들어갈 값 ...)  !주의 : 컬럼 리턴값과 값은 같아야함 , 숫자의 경우 4자리까지
INSERT INTO departments (
    department_id,
    department_name
) VALUES (
    7777,
    '이젠잘나가'
);

SELECT
    *
FROM
    locations;

INSERT INTO departments (
    department_id,
    department_name,
    manager_id,
    location_id
)
-- PK값이 이미 존재하여야만 오류가 나지 않는다
 VALUES (
    7778,
    '이젠잘나가2',
    100,
    1000
);


--행삽입2 : 시퀀스 번호 자동생성
INSERT INTO departments (
    department_id,
    department_name,
    manager_id,
    location_id
) VALUES (
    departments_seq.NEXTVAL,
    '이젠잘나가2',
    100,
    1000
);

SELECT
    *
FROM
    departments;

CREATE TABLE dept
    AS
        SELECT
            *
        FROM
            departments
        WHERE
            0 = 1;

--서브 쿼리를 이용한 복붙
INSERT INTO dept
    SELECT
        *
    FROM
        departments;

SELECT
    *
FROM
    departments;

--행 수정
UPDATE employees
SET
    department_id = 30
WHERE
    employee_id = 107;

SELECT
    *
FROM
    employees;

--행 수정2
UPDATE emp
SET
    salary = salary * 1.1;

SELECT
    *
FROM
    emp;


--행 삭제
DELETE FROM emp
WHERE
    employee_id = 127;

SELECT
    *
FROM
    emp;

--행 삭제2 : department_name에 '이젠' 이 포함되있는 행 전부 삭제
DELETE FROM departments
WHERE department_name LIKE '%이젠%';

SELECT
    *
FROM
    departments;


-- 행 삭제3 : 서브쿼리 활용하여 삭제
DELETE FROM emp
WHERE
    salary > (
        SELECT
            AVG(salary)
        FROM
            emp
    );

--여러가지 DML 작업(트랜잭션)
--주문
COMMIT;

--주문끝
ROLLBACK;


SELECT *
FROM departments;

desc employees;

INSERT INTO employees(employee_id , first_name , last_name,email, phone_number , hire_date , job_id  , salary , department_id)
VALUES(employees_seq.NEXTVAL,'기정','김','kkkk@kkx.co.kr' , '011.123.3456' , sysdate , 'IT_PROG' , 5000 , 10);

ROLLBACK;

SELECT *
FROM employees;


UPDATE employees
SET salary = salary+ 500
--WHERE employee_id= employees_seq.CURRVAL;
WHERE department_id=10;

COMMIT;

