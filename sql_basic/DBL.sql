--���̺� ���� 
--DDL�� ����� ���ÿ� AUTO COMMIT ��.
CREATE TABLE dept2 (
-- �÷��� ������ Ÿ�� (�ڸ���)
    dept_id   NUMBER(4),
    dept_name VARCHAR2(30)
);

SELECT
    *
FROM
    user_tables;


--���̺� ����2
--NOT NULL�� ���̺� �����ÿ��� ��������
CREATE TABLE member (
--  �÷��̸� ������ Ÿ��(��) CONSTRAINT ���̺��_�÷���_����Ÿ�� ����Ÿ�� Ǯ����
    member_id  VARCHAR2(10)
        CONSTRAINT member_id_pk PRIMARY KEY,
    passwd     VARCHAR2(20) NOT NULL,
    name       VARCHAR2(20) NOT NULL,
    email      VARCHAR2(30)
        CONSTRAINT member_email_uk UNIQUE,
    gender     VARCHAR2(1)
        CONSTRAINT member_gender_ck CHECK ( gender IN ( 'M', 'F' ) ),
    regdate    DATE DEFAULT sysdate,
    -- �����ϴ� ���̺�(�θ����̺�)�� pk���� ����ϴ� �������� : fk 
    -- �����ϴ� �÷��� ���������� ������Ÿ���� ��ġ�Ͽ����Ѵ�
    manager_id NUMBER(6)
        CONSTRAINT member_manager_fk
            REFERENCES employees ( employee_id )
);

DESC employees;

INSERT INTO member (
    member_id,
    passwd,
    name,
    email,
    gender,
    manager_id
) VALUES (
    'bangry313',
    '1111',
    '�ۿ켺',
    'bangry313@gmail.com',
    'M',
    100
);

INSERT INTO member (
    member_id,
    passwd,
    name,
    email,
    gender,
    regdate,
    manager_id
) VALUES (
    'bangry314',
    '1111',
    '�ۿ켺',
    'bangry314@gmail.com',
    'M',
    TO_DATE('2023-06-08', 'YYYY-MM-DD'),
    100
);

CREATE TABLE member (
    member_id  VARCHAR2(10),
    passwd     VARCHAR2(20) NOT NULL,
    name       VARCHAR2(20) NOT NULL,
    email      VARCHAR2(30),
    gender     VARCHAR2(1),
    regdate    DATE DEFAULT sysdate,
    manager_id NUMBER(6)
);

ALTER TABLE member ADD (
--CONSTRAINT ���������̸� ��������Ÿ�� (�÷���)
    CONSTRAINT member_id_pk PRIMARY KEY ( member_id ),
    CONSTRAINT member_email_uk UNIQUE ( email ),
    CONSTRAINT member_gender_ck CHECK ( gender IN ( 'M', 'F' ) ),
    CONSTRAINT member_manager_fk FOREIGN KEY ( manager_id )
        REFERENCES employees ( employee_id )
);


--������ ���Ǽ��� ���� �������� ��Ȱ��ȭ

ALTER TABLE member DISABLE CONSTRAINT member_id_pk DISABLE CONSTRAINT member_email_uk DISABLE CONSTRAINT member_gender_ck DISABLE CONSTRAINT

member_manager_fk;

SELECT
    *
FROM
    user_constraints
WHERE
    table_name = 'MEMBER';

-- ���̺� ����������
DROP TABLE member;


--���̺� ������ �������ǵ� ���� ����
DROP TABLE member CASCADE CONSTRAINTS;

-- ���̺� ������ �������͸� ����ؼ� ���̺���� �ҹ��ڷ� �����
-- ���̺�󿡼��� �ҹ��ڷ� ǥ���
CREATE TABLE "abc" (
    num NUMBER(10)
);

SELECT
    *
FROM
    user_tables;

--������ �����غ���
CREATE SEQUENCE member_id_seq START WITH 100 INCREMENT BY 10;
    
--��ųʸ� ��ȸ
SELECT
    *
FROM
    user_sequences;

SELECT
    member_id_seq.NEXTVAL
FROM
    dual;

SELECT
    member_id_seq.CURRVAL
FROM
    dual;    
    
--�� ����
--���Ȼ� or ������ ������ �ߺ�����ϱ� ����
CREATE OR REPLACE VIEW emp_view AS
    SELECT
        employee_id,
        last_name,
        department_id
    FROM
        employees
    WHERE
        department_id = 10;

--�����2
CREATE OR REPLACE VIEW dept_detail_view AS
    SELECT
        e.employee_id,
        e.last_name,
        d.department_name,
        l.city,
        l.state_province,
        c.country_name
    FROM
             employees e
        JOIN departments d ON e.department_id = d.department_id
        JOIN locations   l ON d.location_id = l.location_id
        JOIN countries   c ON l.country_id = c.country_id
        JOIN regions     r ON c.region_id = r.region_id;
    
--�� ����3
-- 10�� �μ��� ����� ���ؼ��� INSERT, UPDATE �� �� �ִ� �� ����
CREATE OR REPLACE VIEW emp_view AS
    SELECT
        employee_id,
        last_name,
        email,
        hire_date,
        job_id,
        department_id
    FROM
        employees
    WHERE
        department_id = 10
WITH READ ONLY;
    
--emp view ��ȸ
SELECT
    *
FROM
    emp_view;

--emp INSERT �غ���
INSERT INTO emp_view (
    employee_id,
    last_name,
    email,
    hire_date,
    job_id,
    department_id
) VALUES (
    employees_seq.NEXTVAL,
    'jack',
    'jack@korea.com',
    sysdate,
    'AD_VP',
    10
);

--dept_detail_view ��ȸ
SELECT
    *
FROM
    dept_detail_view;
 
--��� view ��ȸ
SELECT
    *
FROM
    user_views;
    
    
    
    -- �ε������� ����ϴ� �����÷�(rowid) ��ȸ
SELECT
    ROWID,
    employee_id
FROM
    employees;
-- ��ųʸ��κ��� �ε��� ��ȸ
SELECT
    *
FROM
    user_indexes
WHERE
    table_name = 'EMPLOYEES';
-- ���� �ε��� ����
CREATE INDEX emp_salary_idx ON
    employees (
        salary
    );

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    salary BETWEEN 10000 AND 12000;
    
    
-- �ڵ� �ε��� ���
SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    email = 'JSEO';

SELECT
    ROWID,
    employee_id
FROM
    employees;

SELECT
    ROWNUM,
    employee_id
FROM
    employees;





-- ����
-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 > 1�� false�� �Ǿ� rownum�� ���̻� �������� ������, �ϳ��� �൵ ��ȯ���� ����
SELECT
    ROWNUM,
    employee_id,
    first_name
FROM
    employees
WHERE
    ROWNUM >= 108;



--���������� �ο�� ��ȸ
--��� 5�� ��ȸ
SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            employees
        ORDER BY
            salary DESC
    )
WHERE
    ROWNUM <= 5;
    
    
    -- �޿������� ����¡ ó�� ( 10���� �߶� ��ȸ�ϱ�)
SELECT
    page,
    employee_id,
    first_name,
    salary
FROM
    (
        SELECT
        -- CEIL :�ø� ��� 0.5-> 1
            ceil(ROWNUM / 10) page,
            employee_id,
            first_name,
            salary
        FROM
            (
                SELECT
                    ROWNUM,
                    employee_id,
                    first_name,
                    salary
                FROM
                    employees
                ORDER BY
                -- �ʿ信 ���� �˻����� �߰�
                    salary DESC
            )
    )
WHERE
    page = 2;
    
    
    -- �ó�� ����
CREATE SYNONYM emps FOR hr.employees;

SELECT
    *
FROM
    emps;
    
    
    -- �ó�� ����
DROP SYNONYM emps;