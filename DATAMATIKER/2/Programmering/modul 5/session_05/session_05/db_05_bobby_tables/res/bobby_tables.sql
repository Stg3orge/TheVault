use master;
if exists (select * from sys.databases where name='school')
	drop database school;
go

create database school;
go

use school;

create table students (
	id int primary key identity(1,1),
	parent_name varchar(64),
	birthdate date,
	phone varchar(16),
	name varchar(64) not null
)

insert into students values('Joe Doe sr.', '2005-05-05', '12121212', 'Joe Doe');
insert into students values('Joe Doe sr.','2007-07-07', '12121212', 'Jane Doe');
--Robert'); drop table students; --

select * from students;
