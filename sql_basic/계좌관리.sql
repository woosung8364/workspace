--1. ���� ���̺� ����

CREATE TABLE account (
    account_num  VARCHAR2(20) ,
    name  VARCHAR2(10)  ,
    password  VARCHAR2(20) , 
    rest_money NUMBER(38) , 
    borrow_money NUMBER(38)  NOT NULL  ,
    type_id VARCHAR2(20) NOT NULL 
    
);

-- #2. �������� �߰�
ALTER TABLE account ADD (
    CONSTRAINT type_id CHECK (type_id IN (0 ,1)) ,
    CONSTRAINT account_num_uk UNIQUE (account_num)
);
    
DESC employees;

-- #3. ������ ���Ǽ��� ���� �������� Ȱ��ȭ/��Ȱ��ȭ..

ALTER TABLE account 
DISABLE CONSTRAINT type_id_ck
DISABLE CONSTRAINT account_num_uk;


--ENABLE CONSTRAINT ....
ENABLE CONSTRAINT type_id_ck
ENABLE CONSTRAINT account_num_uk;


--������ ����--
--���¹�ȣ�� 1000������ 1�� �����ϰ� ������
CREATE SEQUENCE account_num_seq START WITH 1000 INCREMENT BY 1;



--#4. ���̵����� �߰�,����,����
-- �����߰�
INSERT INTO account (
    account_num ,
    name,
    password ,
    rest_money   ,
    borrow_money ,
    type_id
)

VALUES (
    account_num_seq.nextval ,
    '��켺' ,
    2234 ,
   100000000 ,
   -10000 , 
   1
 );
 

 --���� ����--
-- ����Ÿ���� �Ϲ����� �ٲٱ�
 UPDATE account
 SET type_id='���̳ʽ�'
 WHERE account_num='1001';
 
-- �ܾ� x 1.5 �غ���
 UPDATE account
 SET  rest_money = rest_money* 1.5
 WHERE account_num=1001;

 
 --���� ����--
 
 DELETE FROM account
 WHERE passwd=1234;

--��ü ���°��� ��ȸ
SELECT count(*) cnt
FROM account;


-- account ���̺� ��ȸ--
SELECT 
    account_num "���¹�ȣ ,
    name "�����ָ�" ,
    password "��й�ȣ" ,
    rest_money "�ܾ�" ,
    borrow_money "�����ݾ�"  ,
    type_id "����Ÿ��"
   
    FROM 
    account
    
    ORDER BY
    account_num;

--account ���̺� �� �������� ���� --
DROP TABLE account CASCADE CONSTRAINTS;