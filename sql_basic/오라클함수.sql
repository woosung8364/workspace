-- 숫자 관련 함수 (a.bcd  , z)  Z값은 소수점 자리수를 어디까지 표현할지에 대한 값을 설정
SELECT
    round(45.923),
    round(45.923, 0),
    round(45.923, 2),
    round(45.923, - 1)
FROM
    dual;

--  TRUNC 내림 기능 
SELECT
    trunc(45.923),
    trunc(45.923, 0),
    trunc(45.923, 2),
    trunc(45.923, - 1)
FROM
    dual;

-- 올림한채 정수만 반환
SELECT
    ceil(123.123)
FROM
    dual;

-- 내림한채 정수만 반환
SELECT
    floor(123.123)
FROM
    dual;

-- 절대값 반환
SELECT
    abs(- 500)
FROM
    dual;

-- POWER (A,B) :  A를 B 제곱한 값 출력
SELECT
    power(5, 2),
    sqrt(5),
    sin(30),
    cos(30),
    tan(30)
FROM
    dual;

-- 최소값 반환
SELECT
    least(10, 20, 30, 40)
FROM
    dual;

-- 최대값 반환
SELECT
    greatest(10, 20, 30, 40)
FROM
    dual;





-- 날짜 관련 함수
SELECT
    sysdate
FROM
    dual;

SELECT
    systimestamp
FROM
    dual;

-- DATE 타입에 연산 가능
SELECT
    sysdate - 1 "어제",
    sysdate     "오늘",
    sysdate + 1 "내일",
    sysdate + 7 "일주일뒤"
FROM
    dual;

-- 사원별 근무 일수 검색
SELECT
    first_name,
    hire_date,
    sysdate,
    ceil(sysdate - hire_date) "근무일수"
FROM
    employees;

-- 사원별 근무 개월수 검색
SELECT
    first_name,
    trunc(months_between(sysdate, hire_date)) "근무개월수"
FROM
    employees;

-- 특정개월수를 더한 날짜 반환
SELECT
    sysdate,
    add_months(sysdate, 2) "오늘부터 2개월 후"
FROM
    dual;

-- 이번주 토요일 날짜
SELECT
    sysdate              "오늘",
    next_day(sysdate, 7) "이번주 토요일"
FROM
    dual;

-- 이번달 마지막 날짜
SELECT
    sysdate,
    last_day(sysdate) "이번달 마지막날"
FROM
    dual;

-- 이번달 마지막 날짜
SELECT
    sysdate,
    add_months(last_day(sysdate, 1)) "다음달 마지막날"
FROM
    dual;

-- MONTH 설정시 6/8 -> 6/1   ,  YEAR 로 설정시 6/8 -> 1/1 
SELECT
    round(sysdate, 'YEAR')
FROM
    dual;

--형변환 함수
-- TO_CHAR()
-- 자리수를 대조할때 '9' 와 '0'을 사용한다
-- 9사용시엔 빈자리를 공백으로 채우고 
-- 0 사용시엔 빈자리를 0으로 채운다
SELECT
    to_char(1231241, '999,9999')
FROM
    dual;

-- 출력값은 그대로 나오지만 문자열로 변환되있음
SELECT
    to_char(12345),
    to_char(12345.67)
FROM
    dual;

-- 9로 지정한 남는 자리수만큼 '공백'으로 둔다
SELECT
    to_char(12345, '999,999'),
    to_char(12345.677, '999,999.99')
FROM
    dual;

-- 0으로 지정한 남는 자리수만큼 '0' 으로 채운다
SELECT
    to_char(12345, '000,000'),
    to_char(12345.677, '000,000.00')
FROM
    dual;

--예시2
SELECT
    to_char(150, '$9999'),
    to_char(150, '$0000')
FROM
    dual;

SELECT
    to_char(150, 'S9999'),
    to_char(150, 'S0000')
FROM
    dual;

SELECT
    to_char(150, '9999MI'),
    to_char(- 150, '9999MI')
FROM
    dual;

--과학적 지수로 표기 EEEE
SELECT
    to_char(150, '9999EEEE'),
    to_char(150, '99999B')
FROM
    dual;


--숫자 형변환 함수
SELECT
    TO_NUMBER('12345') + 1
FROM
    dual;

SELECT
    TO_NUMBER('12,345', '00,000') + 1
FROM
    dual;

SELECT
    TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM
    dual;

-- 날짜 형변환 함수
SELECT
    TO_DATE('2021/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM
    dual;

-- 지정한 날짜로부터 입사일이 같은 사람 찾기
SELECT
    first_name,
    hire_date
FROM
    employees
WHERE
    hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

SELECT
    first_name,
    hire_date
FROM
    employees
WHERE
    hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');

SELECT
    first_name,
    hire_date
FROM
    employees
WHERE
    hire_date = TO_DATE(20030617, 'YYYY-MM-DD');


--일반함수
-- 자바에서 null은 값이 없다는 의미지만 sql 에서 null 은 블랙홀에 비유해서 생각하면 편하다
-- 블랙홀에 10을 던져넣어도 블랙홀은 멀쩡하므로 그대로 null 이 리턴됨 : NULL + 10 = NULL 
SELECT
    10 + NULL
FROM
    dual;

--다만 NVL 을 붙인다면 NULL 값이 아니라 10이 리턴된다
SELECT
    nvl(NULL, 10)
FROM
    dual;

-- 블랙홀(NULL) X 10 = NULL  , 10 X 1 = 10
SELECT
    10 * NULL,
    10 * nvl(NULL, 1)
FROM
    dual;

-- commission_pct 항목중 값이 null 인 부분에 대해선 0으로 표기해라 (NVL)  
SELECT
    first_name,
    salary,
    nvl(commission_pct, 0)
FROM
    employees;

-- 연봉을 구하려고 했는데 COMMISSION PCT 에 샐러리를 곱했더니 PCT 값이 NULL 이라 NULL 이 리턴됨
SELECT
    first_name,
    salary,
    commission_pct,
    ( salary + ( salary * commission_pct ) ) * 12 "연봉"
FROM
    employees;

-- 위의 사례때문에 commision_pct에 제대로된 숫자값을 대입하기 위해 NVL 사용필요
SELECT
    first_name,
    salary,
    commission_pct,
    ( salary + ( salary * nvl(commission_pct, 0) ) ) * 12 "연봉"
FROM
    employees;

-- NVL2 (A , B,  C) : A가 NULL 이면 C를 리턴 / A가 NULL 이 아니면 B를 리턴
SELECT
    first_name,
    salary,
    nvl2(commission_pct, commission_pct, 0)
FROM
    employees;

-- 비교대상이 '신입사원' - 문자열 이므로 A와 B에도 문자로 형변환 해야한다. 형식을 맞추지 않을시 오류발생
SELECT
    first_name,
    salary,
    nvl2(to_char(commission_pct),
         to_char(commission_pct),
         '신입사원') "인센티브"
FROM
    employees;

SELECT
    first_name,
    job_id,
    decode(job_id, 'IT_PROG', '개발자', 'AC_MRG', '관리자',
           'FI_ACCOUNT', '회계사', '직원')
FROM
    employees;


-- 회사 직종별 급여 인상
SELECT
    first_name,
    job_id,
    salary,
    decode(job_id, 'IT_PROG', salary * 1.5, 'AC_MRG', salary * 1.3,
           'AC_ASST', salary * 1.1,
                            -- 인상된 급여목록 추가 --
            salary) "인상급여"
FROM
    employees;

-- 우리 그룹의 임금 총합과 평균이 얼마인지
SELECT
    department_id,
    SUM(salary),
    AVG(salary)
FROM
    employees
GROUP BY
    department_id
    -- 임금이 3000 이상인것만
HAVING
    AVG(salary) >= 3000;

-- 그룹별 최대 임금 , 최소 임금
SELECT
    department_id,
    MAX(salary),
    MIN(salary)
FROM
    employees
GROUP BY
    department_id
    --최대 임금이 20000 이상일것
HAVING
    MAX(salary) > 20000;

--전체 입사일자를 불러와서 동일입사일자 인원수 찾아내기
SELECT
    hire_date,
    COUNT(*)
FROM
    employees
GROUP BY
    hire_date
ORDER BY
    hire_date;
--ORDER BY COUNT(*);




-- 전체 사원수(NULL은 포함 안됨)
SELECT
    COUNT(employee_id)
FROM
    employees;
    
-- 전체 사원수(NULL 포함)
SELECT
    COUNT(*)
FROM
    employees;
    
-- 커미션 받는 사원의 수
SELECT
    COUNT(commission_pct)
FROM
    employees;

SELECT
    COUNT(*)              "전체사원수",
    COUNT(commission_pct) "커미션사원수"
FROM
    employees;
    
    
-- 급여 총액(NULL은 무시)
SELECT
    SUM(salary)
FROM
    employees;
    
    
-- 커미션 평균
SELECT
    AVG(commission_pct),
    AVG(nvl(commission_pct, 0))
FROM
    employees;
    
    
-- JOIN
-- 두 테이블을 동시에 조회
SELECT *
FROM employees , departments ; 


SELECT count(*)
FROM departments;
    
    
    