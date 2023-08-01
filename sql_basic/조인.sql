/*
* JOIN 문 예제
*/


--오라클식 JOIN 
SELECT
    employee_id,
    salary,
    department_name
FROM
    --테이블명이 너무 길므로 별칭사용 e,d
    employees e,
    departments d
WHERE
    --e의 d의 부서번호가 같고 부서번호가 104번인것만 출력하라
        e.department_id = d.department_id
    AND employee_id = 104;
    
    
-- ANSI 조인
    
SELECT
    employee_id ,
    salary ,
    department_name
FROM
    employees e Join departments d 
    ON e.department_id=d.department_id
WHERE 
    e.employee_id=104;
    
    
-- 딕셔너리 조회
-- EQUI JOIN
--3개 이상 테이블 조인 (딕셔너리(테이블) 로 부터 테이블 종류 조회) 
-- inner 조인하면서 EQUI 조인

SELECT *
-- HR 계정 안에 들어있는 TABLE 들 
FROM USER_TABLES;

SELECT 
    e.employee_id ,
    e.last_name ,
    d.department_name ,
     l.city
     
     
FROM 
    employees e
    
    JOIN departments d
    ON e.department_id = d.department_id
    
    JOIN locations l
    ON d.location_id = l.location_id;
    

    
    
    
--NON EQUI JOIN : 특정 범위로 행과 행을 연결
-- #1. 테스트 급여등급(salgrade) 테이블 생성
CREATE TABLE salgrade (
grade NUMBER,
losal NUMBER,
hisal NUMBER
);

-- #2. 데이터 입력
INSERT INTO salgrade VALUES (1, 2000, 2999);
INSERT INTO salgrade VALUES (2, 3000, 3999);
INSERT INTO salgrade VALUES (3, 4000, 4999);
INSERT INTO salgrade VALUES (4, 5000, 5999);
INSERT INTO salgrade VALUES (5, 6000, 100000);
COMMIT;

SELECT *
FROM salgrade;

-- 사원별 급여 등급 조회

SELECT
    e.last_name ,
    e.salary
    
FROM 
    employees e
    JOIN salgrade s;
    ON e.salry BETWEEN s.lowsal AND s.hisal;
    
--외부조인

SELECT
    employee_id ,
    salary ,
    department_name
FROM
    employees e 
    
    RIGHT Join departments d 
    ON e.department_id=d.department_id;

--오라클식 외부조인
SELECT
    employee_id,
    salary,
    department_name
FROM
  
    employees e,
    departments d
WHERE
    -- LEFT : 왼쪽에 (+) 
    -- RIGHT : 오른쪽에 (+)
    e.department_id = d.department_id(+);
    
    
    
--셀프조인
--상사 이름을 알고싶은데 변수에 상사번호만 있을때
--자기자신과 같은 테이블을 하나 더 생성해서 조인시킴
SELECT 
    e1.employee_id ,
    e1.last_name ,
    e2.last_name
    
FROM
    employees e1
    JOIN employees e2
    ON e1.manager_id=e2.employee_id;
    

    
    
    