create database java_11_25;
use java_11_25;

create table admin
(
	name varchar(20) primary key,
	password varchar(32) not null
)
comment '管理员';
insert into admin values('admin',MD5('123456'));

create table employee
(
   id smallint primary key auto_increment,
   name varchar(20) not null,
   sex smallint not null,
   entry date not null,
   depart varchar(20) not null,
   phone varchar(11) not null
);
comment '员工';

insert into employee(name, sex, entry, depart, phone) VALUES ('listen', 0, CURDATE(), '开发部', '12345677889');