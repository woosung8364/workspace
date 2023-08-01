/* #1. HR ���Դ� ����� ���� ������ ���� ������ DBA ����(sys or system)���� ���� �� User ���� */
-- sqlplus ���� : conn as sysdba;
SELECT
    *
FROM
    hr.employees;
    
/* #2. User ���� (�����⸸ �����α�)*/ 
-- IDENTIFIED : LOCK ����
CREATE USER bangry IDENTIFIED BY bangry;



/* #3. ������ User�� l�ý��� ����l / l��ül(���̺�, �� ��)�� ���� ���� �ο� */
-- �ý��� ���� ���� �ο� : GRANT CREATE SESSION
GRANT
    CREATE SESSION
TO bangry;

SELECT
-- ��ü�� ���� '���' ���� �ο�(sys�� bangry���� hr��Ű���� employees ���̺� ���� CRUD ������ �ο�)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees 
TO bangry;


/* #4. �ʿ信 ���� User���� �ο��� ���� ȸ�� */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees 
FROM bangry;


/* ��(ROLE) : ���� ���ѵ��� ����(���� �� / ����� ���� ��) */
/* #1. User�� ���� �� �ο� */
GRANT CONNECT, RESOURCE, DBA 
TO bangry;

/* #2. ����� ���� �� ���� */
CREATE ROLE some_role;
--DROP ROLE some_role;

/* #3. �ý��� ���Ѱ� ��ü ������ �ѿ� ��� */
GRANT CREATE SESSION 
TO some_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees 
TO some_role;

-- �� ��� ������ �ѿ� �ο�
GRANT ALL ON hr.employees 
TO some_role;

/* #4. User�� ����� ���� �� �ο� */
GRANT some_role TO bangry;

/* #5. User ��� �� ���� */
ALTER USER bangry
    ACCOUNT LOCK;

ALTER USER bangry
    ACCOUNT UNLOCK;