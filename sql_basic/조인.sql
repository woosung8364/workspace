/*
* JOIN �� ����
*/


--����Ŭ�� JOIN 
SELECT
    employee_id,
    salary,
    department_name
FROM
    --���̺���� �ʹ� ��Ƿ� ��Ī��� e,d
    employees e,
    departments d
WHERE
    --e�� d�� �μ���ȣ�� ���� �μ���ȣ�� 104���ΰ͸� ����϶�
        e.department_id = d.department_id
    AND employee_id = 104;
    
    
-- ANSI ����
    
SELECT
    employee_id ,
    salary ,
    department_name
FROM
    employees e Join departments d 
    ON e.department_id=d.department_id
WHERE 
    e.employee_id=104;
    
    
-- ��ųʸ� ��ȸ
-- EQUI JOIN
--3�� �̻� ���̺� ���� (��ųʸ�(���̺�) �� ���� ���̺� ���� ��ȸ) 
-- inner �����ϸ鼭 EQUI ����

SELECT *
-- HR ���� �ȿ� ����ִ� TABLE �� 
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
    

    
    
    
--NON EQUI JOIN : Ư�� ������ ��� ���� ����
-- #1. �׽�Ʈ �޿����(salgrade) ���̺� ����
CREATE TABLE salgrade (
grade NUMBER,
losal NUMBER,
hisal NUMBER
);

-- #2. ������ �Է�
INSERT INTO salgrade VALUES (1, 2000, 2999);
INSERT INTO salgrade VALUES (2, 3000, 3999);
INSERT INTO salgrade VALUES (3, 4000, 4999);
INSERT INTO salgrade VALUES (4, 5000, 5999);
INSERT INTO salgrade VALUES (5, 6000, 100000);
COMMIT;

SELECT *
FROM salgrade;

-- ����� �޿� ��� ��ȸ

SELECT
    e.last_name ,
    e.salary
    
FROM 
    employees e
    JOIN salgrade s;
    ON e.salry BETWEEN s.lowsal AND s.hisal;
    
--�ܺ�����

SELECT
    employee_id ,
    salary ,
    department_name
FROM
    employees e 
    
    RIGHT Join departments d 
    ON e.department_id=d.department_id;

--����Ŭ�� �ܺ�����
SELECT
    employee_id,
    salary,
    department_name
FROM
  
    employees e,
    departments d
WHERE
    -- LEFT : ���ʿ� (+) 
    -- RIGHT : �����ʿ� (+)
    e.department_id = d.department_id(+);
    
    
    
--��������
--��� �̸��� �˰������ ������ ����ȣ�� ������
--�ڱ��ڽŰ� ���� ���̺��� �ϳ� �� �����ؼ� ���ν�Ŵ
SELECT 
    e1.employee_id ,
    e1.last_name ,
    e2.last_name
    
FROM
    employees e1
    JOIN employees e2
    ON e1.manager_id=e2.employee_id;
    

    
    
    