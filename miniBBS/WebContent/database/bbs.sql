


drop sequence bbs_seq;

create sequence bbs_seq start with 1 increment by 1;

drop table bbs;

commit;

create table bbs (
  b_no number(7) not null,
  b_sabun number(4) not null,
  b_name varchar2(15) not null,
  b_title varchar2(30) not null,
  b_cnt number(5) default 0,
  b_content varchar2(30) not null,
  b_phone  varchar2(20) not null,
  b_pwd  varchar2(10)  not null,
  b_wdate  date   not null,
  b_juso1  varchar2(50) not null,
  b_juso2  varchar2(50) not null,
  b_email varchar2(30) not null,
  b_url  varchar2(20)  null, 
  b_file1  varchar2(30) null, 
  b_size1  number(7) default 0 ,
  primary key(b_sabun)
);

commit; 

select * from bbs;

col b_name for a10
col b_title for a10
col b_file1 for a15;

drop sequence bbsreply_seq;
drop table bbsreply;
commit;

create sequence bbsreply_seq;

create table bbsreply(
  br_num number(4) not null,
  br_writer varchar2(10) not null,
  br_content varchar2(20) not null,
  br_date date not null,
  br_sabun number(4) not null
);

commit;

alter table bbsreply drop constraint bbs_sabun_fk;
alter table bbsreply add constraint bbs_sabun_fk
foreign key(br_sabun) references bbs(b_sabun) on delete cascade;

commit;

