-- #1. ���� ���̺� ����
CREATE TABLE account (
    account_num    VARCHAR2(4),
    name                 VARCHAR2(10) NOT NULL,
    password          VARCHAR2(10) NOT NULL,
    rest_money       NUMBER(20),
    borrow_money NUMBER(20),
    type_id             NUMBER(1) NOT NULL
);

-- #2. �������� �߰�
ALTER TABLE account 
    ADD (
    CONSTRAINT account_num_pk PRIMARY KEY ( account_num ),
    CONSTRAINT type_id_ck CHECK ( type_id IN ( '0', '1' ) )
);

-- ������
CREATE SEQUENCE account_num_seq 
    START WITH 1000 INCREMENT BY 1;
    
-- #3. ������ ���Ǽ��� ���� �������� Ȱ��ȭ/��Ȱ��ȭ
-- ��Ȱ��ȭ
ALTER TABLE account 
    DISABLE CONSTRAINT account_num_pk

-- Ȱ��ȭ
ALTER TABLE account 
    ENABLE CONSTRAINT account_num_pk;

-- #4. ���̵����� �߰�, ����, ����
-- ��ü ���� ��� ��
SELECT
    COUNT(*) cnt
FROM
    account;

-- ��ü ���� ��� ��ȸ
SELECT
    account_num,
    name,
    password,
    rest_money,
    borrow_money,
    type_id
FROM
    account
ORDER BY
    account_num;

-- �ű԰��� ���
INSERT INTO account (
    account_num,
    name,
    password,
    rest_money,
    borrow_money,
    type_id) 
VALUES ( account_num_seq.NEXTVAL, '�����', 1234, 10000, 100000000, 1);

commit;

select * from account;

-- ���¹�ȣ�� ���� �˻�
SELECT
    account_num,
    name,
    password,
    rest_money,
    borrow_money,
    type_id
FROM
    account
WHERE
    account_num = ?;

-- �̸����� ���� �˻�
SELECT
    account_num,
    name,
    password,
    rest_money,
    borrow_money,
    type_id
FROM
    account
WHERE
    name = ?;

-- ���¹�ȣ�� ���� ����
DELETE FROM account
WHERE
    account_num = ?;