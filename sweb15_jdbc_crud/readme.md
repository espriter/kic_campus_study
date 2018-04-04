== SQL 삽입 ==

1. 테이블 생성
create table member(
  id varchar(10) primary key,
  passwd varchar(10) not null,
  name varchar(10) not null,
  regdate date
);


2. 기초 정보 삽입
insert into member values('aa','123','tom',now());