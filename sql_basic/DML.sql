DESC departments;


--��� �������� �ٺ���
SELECT
    *
FROM
    user_constraints
--���̺� �̸� �˻��Ҷ� �빮�ڷ� �־���Ѵ�
WHERE
    table_name = 'DEPARTMENTS';

-- �� �����غ���
-- INSERT INTO  (�ҷ����� ���̺��) (�÷�A , �÷� B ......) << �����ڿ� ���
-- VALUES (�÷�A�� , �÷�B�� �� �� ...)  !���� : �÷� ���ϰ��� ���� ���ƾ��� , ������ ��� 4�ڸ�����
INSERT INTO departments (
    department_id,
    department_name
) VALUES (
    7777,
    '�����߳���'
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
-- PK���� �̹� �����Ͽ��߸� ������ ���� �ʴ´�
 VALUES (
    7778,
    '�����߳���2',
    100,
    1000
);


--�����2 : ������ ��ȣ �ڵ�����
INSERT INTO departments (
    department_id,
    department_name,
    manager_id,
    location_id
) VALUES (
    departments_seq.NEXTVAL,
    '�����߳���2',
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

--���� ������ �̿��� ����
INSERT INTO dept
    SELECT
        *
    FROM
        departments;

SELECT
    *
FROM
    departments;

--�� ����
UPDATE employees
SET
    department_id = 30
WHERE
    employee_id = 107;

SELECT
    *
FROM
    employees;

--�� ����2
UPDATE emp
SET
    salary = salary * 1.1;

SELECT
    *
FROM
    emp;


--�� ����
DELETE FROM emp
WHERE
    employee_id = 127;

SELECT
    *
FROM
    emp;

--�� ����2 : department_name�� '����' �� ���Ե��ִ� �� ���� ����
DELETE FROM departments
WHERE department_name LIKE '%����%';

SELECT
    *
FROM
    departments;


-- �� ����3 : �������� Ȱ���Ͽ� ����
DELETE FROM emp
WHERE
    salary > (
        SELECT
            AVG(salary)
        FROM
            emp
    );

--�������� DML �۾�(Ʈ�����)
--�ֹ�
COMMIT;

--�ֹ���
ROLLBACK;


SELECT *
FROM departments;

desc employees;

INSERT INTO employees(employee_id , first_name , last_name,email, phone_number , hire_date , job_id  , salary , department_id)
VALUES(employees_seq.NEXTVAL,'����','��','kkkk@kkx.co.kr' , '011.123.3456' , sysdate , 'IT_PROG' , 5000 , 10);

ROLLBACK;

SELECT *
FROM employees;


UPDATE employees
SET salary = salary+ 500
--WHERE employee_id= employees_seq.CURRVAL;
WHERE department_id=10;

COMMIT;

