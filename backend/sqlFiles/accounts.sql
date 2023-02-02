CREATE DATABASE springbootjdbc;

USE springbootjdbc;

CREATE TABLE accounts
(
 id INT PRIMARY KEY auto_increment,
 firstName VARCHAR(255) NOT NULL,
 lastName varchar(255) NOT NULL,
 email varchar(255) NOT NULL
);

insert into  accounts(firstName, lastName, email) values("Jia Xiong","Liao","liaojiaxiong1331@gmail.com");
insert into  accounts(firstName, lastName, email) values("Wiesly","kwek","wiselykwek@gmail.com");
insert into  accounts(firstName, lastName, email) values("Faisal","Samudra","samudrafaisal@gmail.com");
insert into  accounts(firstName, lastName, email) values("Cher Kheem","Thong","thongcherkheem@gmail.com");
insert into  accounts(firstName, lastName, email) values("Fu Wei","Tian","tianfuwei@gmail.com");
insert into  accounts(firstName, lastName, email) values("Natalie","Chan","nataliechan@gmail.com");
insert into  accounts(firstName, lastName, email) values("Cheryl","Lim","cheryllim@gmail.com");