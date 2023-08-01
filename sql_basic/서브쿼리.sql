-- ��������(���� ����)
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
    --�ӱ��� '��' �� ���� ��� �˾Ƴ���
WHERE
        salary = (
            SELECT
                salary
            FROM
                employees
            WHERE
                last_name = 'Seo'
           -- '��' �� ��Ͽ��� �����ϱ�
        )
    AND last_name != 'Seo';
        
        
-- ������ ��������
-- ���������� ������� ���� ��� (���� �ι������)

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


-- ������ ��������
-- '��' ���� �޿��� �������
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
        -- �� : �޿� 2700
            lower(last_name) = 'seo'
    );
-- ��ü��� ��ձ޿����� �� ���� �޿��� �޴� ��� ��� ��ȸ
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
    
    
--������ ��������   
-- IN ������ LIKE   = (equals)
-- 30�� �μ��� �Ҽӵ� ������ '������' ������ ������ ��ü ������ ��ȸ
SELECT
    last_name,
    job_id,
    department_id
FROM
    employees
WHERE
    job_id IN (
        SELECT
        -- DISTINCT = �ߺ��Ѱ��� �����ϴ� ��ɹ�
         DISTINCT
            job_id
        FROM
            employees
        WHERE
            department_id = 30
    );




-- ANY ������ LIKE MIN
-- 30�� �μ��� �ּұ޿��� ���� �� ���� �޿��� �޴� ��ü ������ ��ȸ
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
    
    
-- ���������� �ٲ㺸�� (min �� �����) 
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
    
    
    
-- ALL ������ like MAX
-- 30�� �μ��� '�ִ�޿���' ���� �� ���� �޿��� �޴� ������ ��ȸ
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

-- EXISTS ������
-- ���������� TRUE �ϰ�� ����� ��� FALSE �ϰ�� �����������
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
    
    

--2007�� ���� �Ի��� ����� �ִ� �μ���ȣ�� �μ����� ��ȸ�ϼ���.
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
    
-- IN ������ ���

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


-- ������ �÷�
-- �����ȣ�� 147�� ����� ���� �μ�, ���� �Ի������� ������� �����ȣ, �̸�, ����, �μ���ȣ�� ��ȸ
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


-- ����2 
-- IN �� MIN �Ѵ� ���
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
    
    
--�ζ��� ��
-- �μ��� �ִ� �޿��� ���� Ȯ��
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
    
-- ��Į�� ���� ����
-- ��� ��ȣ, ��� �̸�, �μ��� ��ȸ
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
    
    
    