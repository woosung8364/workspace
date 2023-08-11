/* 
 * 다중 게시판 구축을 위한 SQL
 * employees 테이블과 departments 테이블의 1 : 다 관계 유사
 */
DROP TABLE board;

--#1. 게시판 테이블 생성
CREATE TABLE board(
    board_id       NUMBER(20)           NOT NULL,    -- 게시판 식별번호
    category       NUMBER(10)           NOT NULL,    -- 게시판 카테고리
    title               VARCHAR2(200)     NOT NULL,    -- 게시판 이름
    description  VARCHAR2(400)                            -- 게시판 상세설명
);

DROP SEQUENCE board_id_seq;

CREATE SEQUENCE board_id_seq
    START WITH 10
    INCREMENT BY 10;


--#2. 게시판 테이블 제약조건 추가
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. 테스트 게시판 등록
INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '자유게시판', '누구나 자유롭게 글을 쓰실 수 있는 자유게시판입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '만땅자료실', '이것 저것 없는게 없는 만땅 자료실입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '묻고답하기', 'IT 관련 무엇이든 물어 보세요.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '공지사항', '공지사항입니다.');

COMMIT;

-- 게시판 전체 목록 조회
SELECT board_id, category, title, description
FROM   board
ORDER BY board_id;


--#4. 게시글 테이블 생성
DROP TABLE article;

CREATE TABLE article (
    article_id      NUMBER(20)        NOT NULL,                             -- 게시글 식별번호
    board_id      NUMBER(20)        NOT NULL,                             -- 게시글 소속 게시판번호
    writer           VARCHAR2(20)     NOT NULL,                            -- 게시글 작성자 아이디
    subject        VARCHAR2(400)    NOT NULL,                           -- 게시글 제목
    content        VARCHAR2(4000)   NOT NULL,                          -- 게시글 내용
    regdate        DATE      DEFAULT  SYSDATE  NOT NULL,      -- 게시글 등록일자
    hitcount       NUMBER(20)        DEFAULT 0 NOT NULL,         -- 게시글 조회수
    passwd        VARCHAR2(8)      NOT NULL,                             -- 게시글 비밀번호
    group_no      NUMBER(7)        NOT NULL,                             -- 계층형 게시판 구조를 위한 게시글 그룹번호
    level_no      NUMBER(2)        NOT NULL,                               -- 계층형 게시판 구조를 위한 그룹내 게시글 레벨
    order_no      NUMBER(3)        NOT NULL                              -- 계층형 게시판 구조를 위한 그룹내 게시글 순서
);

--#5. 게시글 테이블 제약조건 추가
ALTER TABLE article 
    ADD (
        CONSTRAINT article_id_pk PRIMARY KEY ( article_id ),
        CONSTRAINT board_id_fk FOREIGN KEY ( board_id )   REFERENCES board ( board_id ),
        CONSTRAINT writer_fk FOREIGN KEY ( writer )  REFERENCES member (id)
);
  

--#6. 게시글 식별번호를 위한 시퀀스 생성
DROP SEQUENCE article_id_seq;

CREATE SEQUENCE article_id_seq
    START WITH   1
    INCREMENT BY 1;
    
desc member;

INSERT INTO member(id, passwd, name, email)
VALUES('monday', '1111', '월요일', 'monday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('tuesday', '1111', '화요일', 'tuesday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('wednesday', '1111', '수요일', 'wednesday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('thursday', '1111', '목요일', 'thursday@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('friday', '1111', '금요일', 'friday@gmail.com');

COMMIT;


--#7. 자유게시판 신규글 등록  테스트
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
             'monday 신규글 제목입니다.',
             'monday 신규글 내용입니다.',
             '1111',
             article_id_seq.CURRVAL,
             0,
             0);

commit;

-- #8. 신규글에 대한 첫번째 댓글 등록 테스트
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
             'tuesday 댓글 제목입니다.',
             'tuesday 댓글 내용입니다.',
             '1111',
             1,
             0 + 1,
             (SELECT MAX(order_no) + 1
              FROM   article
              WHERE  board_id = 10
                     AND group_no = 1));

 
-- #9. 신규글에 대한 두번째 댓글 등록 테스트
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
             'wednesday 댓글 제목입니다.',
             'wednesday 댓글 내용입니다.',
             '1111',
             1,
             0 + 1,
             (SELECT MAX(order_no) + 1
              FROM   article
              WHERE  board_id = 10
                     AND group_no = 1));
             
COMMIT;

-- 게시글 중간점검
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


-- #10. 댓글에 대한 댓글 등록 테스트
-- 부모글의 article_id를 전달받아야 한다.(ex, article_id = 2) 
-- 등록전에 부모글보다 order_no이 큰  order_no을 1씩 증가시킨다
UPDATE article 
SET    order_no = order_no + 1 
WHERE  board_id = 10 
       AND group_no = 1 
       AND order_no > (SELECT order_no 
                       FROM   article 
                       WHERE  article_id = 2);
                       
-- 대댓글 등록           
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
             'thursday 대댓글 제목입니다',
             'thursday 대댓글 내용입니다',
             '1111',
             1,
             2,
             (SELECT order_no + 1
              FROM   article
              WHERE  article_id = 2));               
            
              
COMMIT;

-- 글목록 중간점검
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

--#11. 게시글 전체목록 조회 테스트를 위한 테스트 신규글 등록(서브쿼리 활용)
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

--#12. 계층형 게시판 및 페이징 처리를 위한 게시글목록 조회(가상컬럼(rownum)과 서브쿼리 활용)
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
                        WHERE  board_id = 10 --자유게시판 
                        ORDER  BY group_no DESC, 
                                  order_no ASC)) 
WHERE  request_page = 1;

-- 페이징 처리를 위한 검색개수
SELECT COUNT(article_id) cnt
FROM   article
WHERE  board_id = 10
       AND writer = '%제목%'
        OR subject LIKE '%제목%'
        OR content LIKE '%제목%' ;

-- 페이징 처리를 위한 검색 게시글 검색
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
