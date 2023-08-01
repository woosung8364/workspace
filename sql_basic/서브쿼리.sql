-- 서브쿼리(내부 쿼리)
SELECT
    employee_id,
    last_name,
    hire_date
FROM
    employees
WHERE
    hire_date < (
        SELECT
            hire_date
        FROM
            employees
        WHERE
            employee_id = 100
    );

SELECT
    employee_id,
    last_name,
    hire_date
FROM
    employees
    --임금이 '서' 와 같은 사람 알아내기
WHERE
        salary = (
            SELECT
                salary
            FROM
                employees
            WHERE
                last_name = 'Seo'
           -- '서' 는 목록에서 제외하기
        )
    AND last_name != 'Seo';
        
        
-- 단일행 서브쿼리
-- 서브쿼리를 사용하지 않을 경우 (쿼리 두번써야함)

--1--
SELECT
    salary
FROM
    employees
WHERE
    lower(last_name) = 'seo';

--2--
SELECT
    *
FROM
    employees
WHERE
    salary = 2700;


-- 단일행 서브쿼리
-- '서' 보다 급여가 많은경우
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            salary
        FROM
            employees
        WHERE
        -- 서 : 급여 2700
            lower(last_name) = 'seo'
    );
-- 전체사원 평균급여보다 더 많은 급여를 받는 사원 목록 조회
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            --6461
            AVG(salary)
        FROM
            employees
    );
    
    
--다중행 서브쿼리   
-- IN 연산자 LIKE   = (equals)
-- 30번 부서에 소속된 사원들과 '동일한' 업무를 가지는 전체 사원목록 조회
SELECT
    last_name,
    job_id,
    department_id
FROM
    employees
WHERE
    job_id IN (
        SELECT
        -- DISTINCT = 중복한것을 제외하는 명령문
         DISTINCT
            job_id
        FROM
            employees
        WHERE
            department_id = 30
    );




-- ANY 연산자 LIKE MIN
-- 30번 부서의 최소급여자 보다 더 많은 급여를 받는 전체 사원목록 조회
SELECT
    *
FROM
    employees
WHERE
    salary > ANY (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 30
    );
    
    
-- 단일행으로 바꿔보기 (min 을 써야함) 
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            MIN(salary)
        FROM
            employees
        WHERE
            department_id = 30
    );
    
    
    
-- ALL 연산자 like MAX
-- 30번 부서의 '최대급여자' 보다 더 많은 급여를 받는 사원목록 조회
SELECT
    *
FROM
    employees
WHERE
    salary > ALL (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 30
    );

-- EXISTS 연산자
-- 서브쿼리가 TRUE 일경우 결과물 출력 FALSE 일경우 출력하지않음
SELECT
    *
FROM
    employees
WHERE
    EXISTS (
        SELECT
            *
        FROM
            departments
        WHERE
            department_id = 30
    )
    AND department_id = 30;
    
    

--2007년 이후 입사한 사원이 있는 부서번호와 부서명을 조회하세요.
SELECT
    d.department_id,
    d.department_name
FROM
    departments d
WHERE
    EXISTS (
        SELECT
            e.department_id
        FROM
            employees e
        WHERE
                e.hire_date >= TO_DATE('07/01/01')
            AND e.department_id = d.department_id
    );
    
-- IN 연산자 사용

SELECT
    d.department_id,
    d.department_name
FROM
    departsment d
WHERE
    d.department_id IN (
        SELECT
            e.department_id
        FROM
            employees e
        WHERE
            e.hire_date >= TO_DATE('07/01/01')
    );


-- 다중행 컬럼
-- 사원번호가 147인 사원과 같은 부서, 같은 입사일자인 사원들의 사원번호, 이름, 업무, 부서번호를 조회
SELECT
    employee_id,
    last_name,
    job_id,
    department_id
FROM
    employees
WHERE
    ( department_id,
      hire_date ) = (
        SELECT
            department_id,
            hire_date
        FROM
            employees
        WHERE
            employee_id = 147
    );


-- 예제2 
-- IN 과 MIN 둘다 사용
SELECT
    *
FROM
    employees
WHERE
    ( department_id, salary ) IN (
        SELECT
            department_id, MIN(salary)
        FROM
            employees
        GROUP BY
            department_id
    )
ORDER BY
    department_id;
    
    
--인라인 뷰
-- 부서별 최대 급여자 정보 확인
SELECT
    e.employee_id,
    e.first_name,
    e.department_id,
    e.salary
FROM
         employees e
    JOIN (
        SELECT
            department_id,
            MAX(salary) maxsal
        FROM
            employees
        GROUP BY
            department_id
    ) i 
    ON e.department_id = i.department_id
WHERE
    e.salary = i.maxsal;
    
-- 스칼라 서브 쿼리
-- 사원 번호, 사원 이름, 부서명 조회
SELECT
    employee_id,
    first_name,
    (
        SELECT
            department_name
        FROM
            departments d
        WHERE
            d.department_id = e.department_id
    ) "department_name"
FROM
    employees e;
    
    
    