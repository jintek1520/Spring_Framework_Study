SELECT * FROM reply

CREATE TABLE reply(
rno NUMBER PRIMARY KEY,
bno NUMBER NOT NULL,
replytext VARCHAR2(1000) NOT NULL,
replyer VARCHAR2(30) NOT NULL,
regDate DATE DEFAULT SYSDATE,
updateDate DATE DEFAULT SYSDATE,
CONSTRAINT reply_fk_bno FOREIGN KEY(bno) REFERENCES board(bno)
)














DROP TABLE REPLY

CREATE TABLE reply(
rno NUMBER PRIMARY KEY,
bno NUMBER NOT NULL,
replytext VARCHAR2(1000) NOT NULL,
replyer VARCHAR2(30) NOT NULL,
regDate DATE DEFAULT SYSDATE,
updateDate DATE DEFAULT SYSDATE,
CONSTRAINT reply_fk_bno FOREIGN KEY(bno) REFERENCES board(bno) 
ON DELETE CASCADE
)








delete from reply















DROP TABLE BOARD

CREATE TABLE  board (
	bno NUMBER(6) PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(3000) NOT NULL,
	writer VARCHAR2(30) NOT NULL,
	regDate DATE DEFAULT SYSDATE,
	updateDate DATE DEFAULT SYSDATE,
	viewCnt NUMBER DEFAULT 0

)




INSERT INTO board (bno, title, content, writer)
VALUES (1, 'HELLO', 'HELLO IS ANNYEON', 'KIM')




SELECT NVL2(MAX(bno), MAX(bno)+1, 1) FROM board


INSERT INTO board (bno, title, content, writer)
VALUES ((SELECT NVL2(MAX(bno), MAX(bno)+1, 1) FROM board), 
        '안녕', 
        '안녕은 hello입니다.', 
        '홍길동')





















CREATE TABLE member(
userid VARCHAR2(6) PRIMARY KEY,
userpw 	VARCHAR2(6) NOT NULL,
username VARCHAR2(18) NOT NULL,
email VARCHAR2(100),
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE
)

SELECT * FROM member