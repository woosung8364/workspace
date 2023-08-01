-- DQL �⺻ ����
SELECT *
FROM employees;

SELECT employee_id , last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') 
FROM employees;

SELECT employee_id , first_name , last_name , salary
FROM employees
WHERE department_id IS NULL;

-- ���տ����� : ���ڿ� ���ڻ��̸� �̾��ִ� ���� , �ڹٿ����� "+" �� ������ ��
SELECT first_name || ' ' || last_name 
FROM employees
-- 2002�� 1�� 1�� ���� �Ի��� ����� ���
WHERE hire_date > '2002/01/01' ;


-- ORDER BY �� : (ORDER BY + �÷���) - ������ �÷��� �������� ������/������������ ����
SELECT *
FROM employees
WHERE salary >= 10000
-- ASC : A ~ ������������ ���� , DESC : Z~ ������������ ����  / ASC �� DEFAULT ����
ORDER BY last_name DESC , salary DESC;



SELECT employee_id , salary
FROM employees
WHERE salary >= 100
ORDER BY last_name DESC , salary DESC;

-- GROUP BY �� , count (�ŰԺ���) 
SELECT department_id , count(department_id) count
FROM employees
WHERE salary >= 10000
GROUP BY department_id
-- HAVING : �׷����͸� / �׷�ȭ�� �׸��� NULL �� �׷��� �����ؼ� ����ϰ� ������
HAVING department_id IS NOT NULL
-- count () �� ��Ī�� ����Ͽ� ��������
ORDER BY count;

-- UNION �ǽ��� ���� ���̺� ����(����)
CREATE TABLE emp AS
SELECT *
FROM employees;

-- UNION : ù��° �׷�� �ι�° �׷��� �ߺ��Ǵ°��� �ϳ��� ����ؼ� ������
SELECT *
FROM employees
--UNION ALL   : �ߺ��Ǵ°ͱ��� ���δ� '�ߺ�' ����ؼ� ������
--MINUS : �ߺ��Ǵºκ��� ������ ù��° �׷츸 ����ؼ� ������
INTERSECT
SELECT *
FROM emp;

-- ����Ŭ �Լ�
SELECT *
FROM employees
-- last name ���� �̸����ڼ��� 5�ڸ��� ����鸸 ���
WHERE 5 = length(last_name);

-- count () : () ���� Į���� ������ ������
SELECT count(employee_id)
FROM employees;


-- ������ �Լ�
-- ����(��) ���� �Լ�
-- CONCAT ( 'A' , 'B)  ���ڿ� ���ڿ��� �����ִ� ��� : AB
SELECT CONCAT('Oracle' , 'Java Developer'), 'Oracle' || 'Java Developer'
FROM dual;
--�������̺�
desc dual;

SELECT *
FROM dual;

-- INITCAP : �Ǿձ��ڸ� �빮�ڷ� �ٲ��ִ� ���
SELECT INITCAP('SONG WOO SUNG')
FROM dual;


SELECT INITCAP('SONG WOO SUNG')
FROM emp;


SELECT UPPER('bangry')
FROM dual;

-- LOWER : ���ڿ��� �ҹ��ڷ� �ٲ��ִ� ���
-- �Ϲ������� �������� �񱳳� ������ ���� ����
SELECT first_name , last_name
FROM employees
WHERE LOWER(first_name)='james';

--LPAD ( ���ڿ� , �ڸ����� , ä�ﳻ��)
-- ���������ϰ� ������ ���� ������ @�� ä��
SELECT LPAD('DataBase' , 10 , '@')
FROM dual;

-- SUBSTR (���ڿ� , ����, ���ڰ���) : ���ڿ��� �Ϻκ��� �����ϴ� ���
-- ������ ������ �����ڸ� ��ġ�� �������� ����� ���ڰ����� �����Ѵ�
SELECT SUBSTR('Java Developer' , 6 , 9)
FROM dual;


-- ��°� : ���굿
SELECT SUBSTR('����� ���굿' , 4)
FROM dual;



-- REPLACE (ABC , BC , DE) -> ADE
-- BC�� DE�� �������
SELECT REPLACE('����' , '��' , '�ٻ�')
FROM dual;

-- INSTR ('���ڿ� , '��ġ�� �˰���� ����') = 5 
-- ���ڿ����� Ư�������� ��ġ�� �˾Ƴ��� ���
SELECT INSTR('DataBase' , 'B')
FROM dual;

--LTRIM (AB , A) 
-- ���ڿ����� Ư�����븸 ���� �����ϰ� ������
SELECT LTRIM('JavaDeveloper' , 'Java')
FROM dual;

SELECT TRIM('                    Java Developer                     ')
FROM dual;



SELECT employee_id , first_name, last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') hire_date
FROM employees
WHERE first_name LIKE '%ab%'  OR last_name LIKE '%ab%';
    
    
        


desc employees;