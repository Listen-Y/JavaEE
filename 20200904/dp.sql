drop database if exists river_control;
create database river_control;
use river_control;

drop table if exists river;
create table river
(
    river_num int primary key AUTO_INCREMENT,
    river_name varchar(30) unique ,
    river_length varchar(20) not null,
    river_location varchar(50) not null ,
    river_class varchar(30) not null ,
    river_status varchar(30) not null 
);

insert into river values(null, '长江', '3134', '南部', '内陆河道', '优');
insert into river values(null, '怒江', '3525234', '东部', '内陆河道', '优');
insert into river values(null, '湄公河', '344', '南部', '内陆河道', '优');
insert into river values(null, '红河', '235', '南部', '内陆河道', '优');
insert into river values(null, '元江', '86787657', '南部', '内陆河道', '优');
insert into river values(null, '珠江', '654634', '南部', '内陆河道', '优');
insert into river values(null, '北江', '34534', '南部', '平原区河道', '优');
insert into river values(null, '东江', '5645', '北部', '平原区河道', '优');
insert into river values(null, '韩江', '54', '北部', '平原区河道', '优');
insert into river values(null, '宁江', '2222', '北部', '平原区河道', '优');
insert into river values(null, '梅江', '2345', '北部', '平原区河道', '优');
insert into river values(null, '大靖河', '654', '北部', '山区河道', '良');
insert into river values(null, '西江', '3456', '北部', '山区河道', '良');
insert into river values(null, '郁江', '87654', '北部', '山区河道', '良');
insert into river values(null, '邕江', '3456', '西部', '山区河道', '良');
insert into river values(null, '浔江', '987', '西部', '山区河道', '良');
insert into river values(null, '黔江', '3456', '西部', '丘陵区河道', '良');
insert into river values(null, '融江', '987', '西部', '丘陵区河道', '良');
insert into river values(null, '红水河', '34567', '西部', '丘陵区河道', '良');
insert into river values(null, '南盘江', '8765', '东部', '丘陵区河道', '差');
insert into river values(null, '灞水', '345', '东部', '沿海区河道', '差');
insert into river values(null, '钱塘江', '5422', '东部', '沿海区河道', '差');
insert into river values(null, '雅砻江', '2345', '东部', '沿海区河道', '差');
insert into river values(null, '岷江', '765', '东部', '沿海区河道', '差');
insert into river values(null, '白水', '3134', '南部', '内陆河道', '优');
insert into river values(null, '渠江', '3525234', '东部', '内陆河道', '优');
insert into river values(null, '涪江', '344', '南部', '内陆河道', '优');
insert into river values(null, '湘江', '235', '南部', '内陆河道', '优');
insert into river values(null, '潇水', '86787657', '南部', '内陆河道', '优');
insert into river values(null, '蒸水', '654634', '南部', '内陆河道', '优');
insert into river values(null, '澧水', '34534', '南部', '平原区河道', '优');
insert into river values(null, '沅江', '5645', '北部', '平原区河道', '优');
insert into river values(null, '巫水', '54', '北部', '平原区河道', '优');
insert into river values(null, '资江', '2222', '北部', '平原区河道', '优');
insert into river values(null, '赣江', '2345', '北部', '平原区河道', '优');
insert into river values(null, '章江', '654', '北部', '山区河道', '良');
insert into river values(null, '贡水', '3456', '北部', '山区河道', '良');
insert into river values(null, '梅河', '87654', '北部', '山区河道', '良');
insert into river values(null, '沙颖河', '3456', '西部', '山区河道', '良');
insert into river values(null, '沂河', '987', '西部', '山区河道', '良');
insert into river values(null, '沭河', '3456', '西部', '丘陵区河道', '良');
insert into river values(null, '额尔齐斯河', '987', '西部', '丘陵区河道', '良');
insert into river values(null, '松花江', '34567', '西部', '丘陵区河道', '良');
insert into river values(null, '黑龙江', '8765', '东部', '丘陵区河道', '差');
insert into river values(null, '图们江', '345', '东部', '沿海区河道', '差');
insert into river values(null, '辽河', '5422', '东部', '沿海区河道', '差');
insert into river values(null, '永定河', '2345', '东部', '沿海区河道', '差');
insert into river values(null, '漳河', '765', '东部', '沿海区河道', '差');
