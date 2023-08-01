-- DQL 기본 구문
SELECT *
FROM employees;

SELECT employee_id , last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') 
FROM employees;

SELECT employee_id , first_name , last_name , salary
FROM employees
WHERE department_id IS NULL;

-- 결합연산자 : 문자와 문자사이를 이어주는 역할 , 자바에서의 "+" 의 역할을 함
SELECT first_name || ' ' || last_name 
FROM employees
-- 2002년 1월 1일 이후 입사한 사람만 출력
WHERE hire_date > '2002/01/01' ;


-- ORDER BY 절 : (ORDER BY + 컬럼명) - 지정한 컬럼을 기준으로 오름차/내림차순으로 정렬
SELECT *
FROM employees
WHERE salary >= 10000
-- ASC : A ~ 오름차순으로 정렬 , DESC : Z~ 내림차순으로 정렬  / ASC 는 DEFAULT 값임
ORDER BY last_name DESC , salary DESC;



SELECT employee_id , salary
FROM employees
WHERE salary >= 100
ORDER BY last_name DESC , salary DESC;

-- GROUP BY 절 , count (매게변수) 
SELECT department_id , count(department_id) count
FROM employees
WHERE salary >= 10000
GROUP BY department_id
-- HAVING : 그룹필터링 / 그룹화된 항목중 NULL 인 그룹을 제외해서 출력하고 싶을때
HAVING department_id IS NOT NULL
-- count () 의 별칭을 사용하여 기입했음
ORDER BY count;

-- UNION 실습을 위한 테이블 생성(복사)
CREATE TABLE emp AS
SELECT *
FROM employees;

-- UNION : 첫번째 그룹과 두번째 그룹중 중복되는것은 하나만 출력해서 보여줌
SELECT *
FROM employees
--UNION ALL   : 중복되는것까지 전부다 '중복' 출력해서 보여줌
--MINUS : 중복되는부분을 제외한 첫번째 그룹만 출력해서 보여줌
INTERSECT
SELECT *
FROM emp;

-- 오라클 함수
SELECT *
FROM employees
-- last name 에서 이름글자수가 5자리인 사람들만 출력
WHERE 5 = length(last_name);

-- count () : () 안의 칼럼의 갯수를 세어줌
SELECT count(employee_id)
FROM employees;


-- 단일행 함수
-- 문자(열) 관련 함수
-- CONCAT ( 'A' , 'B)  문자와 문자열을 합쳐주는 기능 : AB
SELECT CONCAT('Oracle' , 'Java Developer'), 'Oracle' || 'Java Developer'
FROM dual;
--가상테이블
desc dual;

SELECT *
FROM dual;

-- INITCAP : 맨앞글자를 대문자로 바꿔주는 기능
SELECT INITCAP('SONG WOO SUNG')
FROM dual;


SELECT INITCAP('SONG WOO SUNG')
FROM emp;


SELECT UPPER('bangry')
FROM dual;

-- LOWER : 문자열을 소문자로 바꿔주는 기능
-- 일반적으로 데이터의 비교나 정렬을 위해 사용됨
SELECT first_name , last_name
FROM employees
WHERE LOWER(first_name)='james';

--LPAD ( 문자열 , 자리갯수 , 채울내용)
-- 우측정렬하고 왼쪽의 남은 공간을 @로 채움
SELECT LPAD('DataBase' , 10 , '@')
FROM dual;

-- SUBSTR (문자열 , 시작, 글자갯수) : 문자열의 일부분을 추출하는 기능
-- 공백을 포함한 시작자리 위치를 설정한후 출력할 글자갯수를 설정한다
SELECT SUBSTR('Java Developer' , 6 , 9)
FROM dual;


-- 출력값 : 가산동
SELECT SUBSTR('서울시 가산동' , 4)
FROM dual;



-- REPLACE (ABC , BC , DE) -> ADE
-- BC를 DE로 덮어씌워라
SELECT REPLACE('가라마' , '라마' , '바사')
FROM dual;

-- INSTR ('문자열 , '위치를 알고싶은 문자') = 5 
-- 문자열에서 특정문자의 위치를 알아내는 기능
SELECT INSTR('DataBase' , 'B')
FROM dual;

--LTRIM (AB , A) 
-- 문자열에서 특정내용만 빼고 추출하고 싶을때
SELECT LTRIM('JavaDeveloper' , 'Java')
FROM dual;

SELECT TRIM('                    Java Developer                     ')
FROM dual;



SELECT employee_id , first_name, last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') hire_date
FROM employees
WHERE first_name LIKE '%ab%'  OR last_name LIKE '%ab%';
    
    
        


desc employees;