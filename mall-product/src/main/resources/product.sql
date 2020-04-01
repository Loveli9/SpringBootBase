create database db_products charset utf8;
create table products(
     pid varchar(32) not null primary key,
     pname varchar(200),
     ptype varchar(50),
     pprice decimal,
     createtime timestamp
     );