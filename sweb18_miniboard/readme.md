== 기본 파일로 아래 SQL문을 DB에 입력하세요 ==
(MySQL)

create table miniboard(
num int primary key auto_increment,
author varchar(10) not null,
title varchar(50),
content text,
bwriter datetime default now(),
readcnt int default 0);

insert into miniboard(author, title,content)
values('홍길동','연습','미니게시판');