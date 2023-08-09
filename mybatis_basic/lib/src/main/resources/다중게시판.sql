/* 
 * ���� �Խ��� ������ ���� SQL
 * employees ���̺�� departments ���̺��� 1 : �� ���� ����
 */
DROP TABLE board;

--#1. �Խ��� ���̺� ����
CREATE TABLE board(
    board_id       NUMBER(20)           NOT NULL,    -- �Խ��� �ĺ���ȣ
    category       NUMBER(10)           NOT NULL,    -- �Խ��� ī�װ�
    title               VARCHAR2(200)     NOT NULL,    -- �Խ��� �̸�
    description  VARCHAR2(400)                            -- �Խ��� �󼼼���
);

DROP SEQUENCE board_id_seq;

CREATE SEQUENCE board_id_seq
    START WITH 10
    INCREMENT BY 10;


--#2. �Խ��� ���̺� �������� �߰�
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. �׽�Ʈ �Խ��� ���
INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '�����Խ���', '������ �����Ӱ� ���� ���� �� �ִ� �����Խ����Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '�����ڷ��', '�̰� ���� ���°� ���� ���� �ڷ���Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '������ϱ�', 'IT ���� �����̵� ���� ������.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '��������', '���������Դϴ�.');

COMMIT;

-- �Խ��� ��ü ��� ��ȸ
SELECT board_id, category, title, description
FROM   board
ORDER BY board_id;


--#4. �Խñ� ���̺� ����
DROP TABLE article;

CREATE TABLE article (
    article_id      NUMBER(20)        NOT NULL,                             -- �Խñ� �ĺ���ȣ
    board_id      NUMBER(20)        NOT NULL,                             -- �Խñ� �Ҽ� �Խ��ǹ�ȣ
    writer           VARCHAR2(20)     NOT NULL,                            -- �Խñ� �ۼ��� ���̵�
    subject        VARCHAR2(400)    NOT NULL,                           -- �Խñ� ����
    content        VARCHAR2(4000)   NOT NULL,                          -- �Խñ� ����
    regdate        DATE      DEFAULT  SYSDATE  NOT NULL,      -- �Խñ� �������
    hitcount       NUMBER(20)        DEFAULT 0 NOT NULL,         -- �Խñ� ��ȸ��
    passwd        VARCHAR2(8)      NOT NULL,                             -- �Խñ� ��й�ȣ
    group_no      NUMBER(7)        NOT NULL,                             -- ������ �Խ��� ������ ���� �Խñ� �׷��ȣ
    level_no      NUMBER(2)        NOT NULL,                               -- ������ �Խ��� ������ ���� �׷쳻 �Խñ� ����
    order_no      NUMBER(3)        NOT NULL                              -- ������ �Խ��� ������ ���� �׷쳻 �Խñ� ����
);

--#5. �Խñ� ���̺� �������� �߰�
ALTER TABLE article 
    ADD (
        CONSTRAINT article_id_pk PRIMARY KEY ( article_id ),
        CONSTRAINT board_id_fk FOREIGN KEY ( board_id )   REFERENCES board ( board_id ),
        CONSTRAINT writer_fk FOREIGN KEY ( writer )  REFERENCES member (id)
);
  

--#6. �Խñ� �ĺ���ȣ�� ���� ������ ����
DROP SEQUENCE article_id_seq;

CREATE SEQUENCE article_id_seq
    START WITH   1
    INCREMENT BY 1;
    
desc member;

INSERT INTO member(id, passwd, name, email)
VALUES('monday', '1111', '������', 'monday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('tuesday', '1111', 'ȭ����', 'tuesday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('wednesday', '1111', '������', 'wednesday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('thursday', '1111', '�����', 'thursday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('friday', '1111', '�ݿ���', 'friday@gmail.com');

COMMIT;


--#7. �����Խ��� �űԱ� ���  �׽�Ʈ
INSERT INTO article
            (article_id,
             board_id,
             writer,
             subject,
             content,
             passwd,
             group_no,
             level_no,
             order_no)
VALUES      (article_id_seq.NEXTVAL,
             10,
             'monday',
             'monday �űԱ� �����Դϴ�.',
             'monday �űԱ� �����Դϴ�.',
             '1111',
             article_id_seq.CURRVAL,
             0,
             0);

commit;

-- #8. �űԱۿ� ���� ù��° ��� ��� �׽�Ʈ
INSERT INTO article
            (article_id,
             board_id,
             writer,
             subject,
             content,
             passwd,
             group_no,
             level_no,
             order_no)
VALUES      (article_id_seq.NEXTVAL,
             10,
             'tuesday',
             'tuesday ��� �����Դϴ�.',
             'tuesday ��� �����Դϴ�.',
             '1111',
             1,
             0 + 1,
             (SELECT MAX(order_no) + 1
              FROM   article
              WHERE  board_id = 10
                     AND group_no = 1));

 
-- #9. �űԱۿ� ���� �ι�° ��� ��� �׽�Ʈ
INSERT INTO article
            (article_id,
             board_id,
             writer,
             subject,
             content,
             passwd,
             group_no,
             level_no,
             order_no)
VALUES      (article_id_seq.NEXTVAL,
             10,
             'wednesday',
             'wednesday ��� �����Դϴ�.',
             'wednesday ��� �����Դϴ�.',
             '1111',
             1,
             0 + 1,
             (SELECT MAX(order_no) + 1
              FROM   article
              WHERE  board_id = 10
                     AND group_no = 1));
             
COMMIT;

-- �Խñ� �߰�����
SELECT article_id,
               subject,
               writer,
              regdate,
              hitcount
              group_no,
             level_no,
             order_no
FROM   article
WHERE  board_id = 10
ORDER  BY group_no DESC,  order_no ASC; 


-- #10. ��ۿ� ���� ��� ��� �׽�Ʈ
-- �θ���� article_id�� ���޹޾ƾ� �Ѵ�.(ex, article_id = 2) 
-- ������� �θ�ۺ��� order_no�� ū  order_no�� 1�� ������Ų��
UPDATE article 
SET    order_no = order_no + 1 
WHERE  board_id = 10 
       AND group_no = 1 
       AND order_no > (SELECT order_no 
                       FROM   article 
                       WHERE  article_id = 2);
                       
-- ���� ���           
INSERT INTO article
            (article_id,
             board_id,
             writer,
             subject,
             content,
             passwd,
             group_no,
             level_no,
             order_no)
VALUES      (
             article_id_seq.NEXTVAL,
             10,
             'thursday',
             'thursday ���� �����Դϴ�',
             'thursday ���� �����Դϴ�',
             '1111',
             1,
             2,
             (SELECT order_no + 1
              FROM   article
              WHERE  article_id = 2));               
            
              
COMMIT;

-- �۸�� �߰�����
SELECT article_id,
            subject,
            writer,
            regdate,
            hitcount,
            group_no,
           level_no,
           order_no
FROM   article
WHERE  board_id = 10
ORDER  BY group_no DESC,
          order_no ASC; 

--#11. �Խñ� ��ü��� ��ȸ �׽�Ʈ�� ���� �׽�Ʈ �űԱ� ���(�������� Ȱ��)
INSERT INTO article
            (article_id,
             board_id,
             writer,
             subject,
             content,
             passwd,
             group_no,
             level_no,
             order_no)
SELECT article_id_seq.NEXTVAL,
       10,
       writer,
       subject,
       content,
       passwd,
       article_id_seq.CURRVAL,
       level_no,
       order_no
FROM   article
WHERE  writer = 'thursday'; 

COMMIT;

--#12. ������ �Խ��� �� ����¡ ó���� ���� �Խñ۸�� ��ȸ(�����÷�(rownum)�� �������� Ȱ��)
SELECT subject, 
       writer, 
       regdate, 
       hitcount 
FROM   (SELECT CEIL(rownum / 10) request_page, 
               subject, 
               writer, 
               TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') regdate, 
               hitcount 
            FROM   (SELECT subject, 
                               writer, 
                               regdate, 
                               hitcount 
                        FROM   article 
                        WHERE  board_id = 10 --�����Խ��� 
                        ORDER  BY group_no DESC, 
                                  order_no ASC)) 
WHERE  request_page = 1;

-- ����¡ ó���� ���� �˻�����
SELECT COUNT(article_id) cnt
FROM   article
WHERE  board_id = 10
       AND writer = '%����%'
        OR subject LIKE '%����%'
        OR content LIKE '%����%' ;

-- ����¡ ó���� ���� �˻� �Խñ� �˻�
SELECT subject, 
       writer, 
       regdate, 
       hitcount 
FROM   (SELECT CEIL(rownum / 10) request_page, 
               subject, 
               writer, 
               TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') regdate, 
               hitcount 
        FROM   (SELECT subject, 
                           writer, 
                           regdate, 
                           hitcount 
                    FROM   article 
                    WHERE  board_id = 10
                           AND writer  LIKE '%monday%'
                            OR subject LIKE '%monday%'
                            OR content LIKE '%monday%'
                    ORDER  BY group_no DESC, 
                              order_no ASC)) 
WHERE  request_page = 1;
