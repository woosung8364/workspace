-- ���� ���� �Լ� (a.bcd  , z)  Z���� �Ҽ��� �ڸ����� ������ ǥ�������� ���� ���� ����
SELECT
    round(45.923),
    round(45.923, 0),
    round(45.923, 2),
    round(45.923, - 1)
FROM
    dual;

--  TRUNC ���� ��� 
SELECT
    trunc(45.923),
    trunc(45.923, 0),
    trunc(45.923, 2),
    trunc(45.923, - 1)
FROM
    dual;

-- �ø���ä ������ ��ȯ
SELECT
    ceil(123.123)
FROM
    dual;

-- ������ä ������ ��ȯ
SELECT
    floor(123.123)
FROM
    dual;

-- ���밪 ��ȯ
SELECT
    abs(- 500)
FROM
    dual;

-- POWER (A,B) :  A�� B ������ �� ���
SELECT
    power(5, 2),
    sqrt(5),
    sin(30),
    cos(30),
    tan(30)
FROM
    dual;

-- �ּҰ� ��ȯ
SELECT
    least(10, 20, 30, 40)
FROM
    dual;

-- �ִ밪 ��ȯ
SELECT
    greatest(10, 20, 30, 40)
FROM
    dual;





-- ��¥ ���� �Լ�
SELECT
    sysdate
FROM
    dual;

SELECT
    systimestamp
FROM
    dual;

-- DATE Ÿ�Կ� ���� ����
SELECT
    sysdate - 1 "����",
    sysdate     "����",
    sysdate + 1 "����",
    sysdate + 7 "�����ϵ�"
FROM
    dual;

-- ����� �ٹ� �ϼ� �˻�
SELECT
    first_name,
    hire_date,
    sysdate,
    ceil(sysdate - hire_date) "�ٹ��ϼ�"
FROM
    employees;

-- ����� �ٹ� ������ �˻�
SELECT
    first_name,
    trunc(months_between(sysdate, hire_date)) "�ٹ�������"
FROM
    employees;

-- Ư���������� ���� ��¥ ��ȯ
SELECT
    sysdate,
    add_months(sysdate, 2) "���ú��� 2���� ��"
FROM
    dual;

-- �̹��� ����� ��¥
SELECT
    sysdate              "����",
    next_day(sysdate, 7) "�̹��� �����"
FROM
    dual;

-- �̹��� ������ ��¥
SELECT
    sysdate,
    last_day(sysdate) "�̹��� ��������"
FROM
    dual;

-- �̹��� ������ ��¥
SELECT
    sysdate,
    add_months(last_day(sysdate, 1)) "������ ��������"
FROM
    dual;

-- MONTH ������ 6/8 -> 6/1   ,  YEAR �� ������ 6/8 -> 1/1 
SELECT
    round(sysdate, 'YEAR')
FROM
    dual;

--����ȯ �Լ�
-- TO_CHAR()
-- �ڸ����� �����Ҷ� '9' �� '0'�� ����Ѵ�
-- 9���ÿ� ���ڸ��� �������� ä��� 
-- 0 ���ÿ� ���ڸ��� 0���� ä���
SELECT
    to_char(1231241, '999,9999')
FROM
    dual;

-- ��°��� �״�� �������� ���ڿ��� ��ȯ������
SELECT
    to_char(12345),
    to_char(12345.67)
FROM
    dual;

-- 9�� ������ ���� �ڸ�����ŭ '����'���� �д�
SELECT
    to_char(12345, '999,999'),
    to_char(12345.677, '999,999.99')
FROM
    dual;

-- 0���� ������ ���� �ڸ�����ŭ '0' ���� ä���
SELECT
    to_char(12345, '000,000'),
    to_char(12345.677, '000,000.00')
FROM
    dual;

--����2
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

--������ ������ ǥ�� EEEE
SELECT
    to_char(150, '9999EEEE'),
    to_char(150, '99999B')
FROM
    dual;


--���� ����ȯ �Լ�
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

-- ��¥ ����ȯ �Լ�
SELECT
    TO_DATE('2021/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM
    dual;

-- ������ ��¥�κ��� �Ի����� ���� ��� ã��
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


--�Ϲ��Լ�
-- �ڹٿ��� null�� ���� ���ٴ� �ǹ����� sql ���� null �� ��Ȧ�� �����ؼ� �����ϸ� ���ϴ�
-- ��Ȧ�� 10�� �����־ ��Ȧ�� �����ϹǷ� �״�� null �� ���ϵ� : NULL + 10 = NULL 
SELECT
    10 + NULL
FROM
    dual;

--�ٸ� NVL �� ���δٸ� NULL ���� �ƴ϶� 10�� ���ϵȴ�
SELECT
    nvl(NULL, 10)
FROM
    dual;

-- ��Ȧ(NULL) X 10 = NULL  , 10 X 1 = 10
SELECT
    10 * NULL,
    10 * nvl(NULL, 1)
FROM
    dual;

-- commission_pct �׸��� ���� null �� �κп� ���ؼ� 0���� ǥ���ض� (NVL)  
SELECT
    first_name,
    salary,
    nvl(commission_pct, 0)
FROM
    employees;

-- ������ ���Ϸ��� �ߴµ� COMMISSION PCT �� �������� ���ߴ��� PCT ���� NULL �̶� NULL �� ���ϵ�
SELECT
    first_name,
    salary,
    commission_pct,
    ( salary + ( salary * commission_pct ) ) * 12 "����"
FROM
    employees;

-- ���� ��ʶ����� commision_pct�� ����ε� ���ڰ��� �����ϱ� ���� NVL ����ʿ�
SELECT
    first_name,
    salary,
    commission_pct,
    ( salary + ( salary * nvl(commission_pct, 0) ) ) * 12 "����"
FROM
    employees;

-- NVL2 (A , B,  C) : A�� NULL �̸� C�� ���� / A�� NULL �� �ƴϸ� B�� ����
SELECT
    first_name,
    salary,
    nvl2(commission_pct, commission_pct, 0)
FROM
    employees;

-- �񱳴���� '���Ի��' - ���ڿ� �̹Ƿ� A�� B���� ���ڷ� ����ȯ �ؾ��Ѵ�. ������ ������ ������ �����߻�
SELECT
    first_name,
    salary,
    nvl2(to_char(commission_pct),
         to_char(commission_pct),
         '���Ի��') "�μ�Ƽ��"
FROM
    employees;

SELECT
    first_name,
    job_id,
    decode(job_id, 'IT_PROG', '������', 'AC_MRG', '������',
           'FI_ACCOUNT', 'ȸ���', '����')
FROM
    employees;


-- ȸ�� ������ �޿� �λ�
SELECT
    first_name,
    job_id,
    salary,
    decode(job_id, 'IT_PROG', salary * 1.5, 'AC_MRG', salary * 1.3,
           'AC_ASST', salary * 1.1,
                            -- �λ�� �޿���� �߰� --
            salary) "�λ�޿�"
FROM
    employees;

-- �츮 �׷��� �ӱ� ���հ� ����� ������
SELECT
    department_id,
    SUM(salary),
    AVG(salary)
FROM
    employees
GROUP BY
    department_id
    -- �ӱ��� 3000 �̻��ΰ͸�
HAVING
    AVG(salary) >= 3000;

-- �׷캰 �ִ� �ӱ� , �ּ� �ӱ�
SELECT
    department_id,
    MAX(salary),
    MIN(salary)
FROM
    employees
GROUP BY
    department_id
    --�ִ� �ӱ��� 20000 �̻��ϰ�
HAVING
    MAX(salary) > 20000;

--��ü �Ի����ڸ� �ҷ��ͼ� �����Ի����� �ο��� ã�Ƴ���
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




-- ��ü �����(NULL�� ���� �ȵ�)
SELECT
    COUNT(employee_id)
FROM
    employees;
    
-- ��ü �����(NULL ����)
SELECT
    COUNT(*)
FROM
    employees;
    
-- Ŀ�̼� �޴� ����� ��
SELECT
    COUNT(commission_pct)
FROM
    employees;

SELECT
    COUNT(*)              "��ü�����",
    COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM
    employees;
    
    
-- �޿� �Ѿ�(NULL�� ����)
SELECT
    SUM(salary)
FROM
    employees;
    
    
-- Ŀ�̼� ���
SELECT
    AVG(commission_pct),
    AVG(nvl(commission_pct, 0))
FROM
    employees;
    
    
-- JOIN
-- �� ���̺��� ���ÿ� ��ȸ
SELECT *
FROM employees , departments ; 


SELECT count(*)
FROM departments;
    
    
    