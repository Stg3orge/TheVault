use master;

if exists (select * from sys.databases where name='Session06DB')
	drop database Session06DB;
go

create Database Session06DB;
go

use Session06DB;

create table GROUPS (
id int primary key identity(10,10),
name varchar(20) not null,
description varchar(64)
)

create table PERSONS (
id int primary key identity(1,1),
name varchar(20) not null,
email varchar(20),
phone varchar(8),
birth_date date,
group_id int foreign key references GROUPS(id)
)

insert into GROUPS values ('AAU', 'Aalborg University');
insert into GROUPS values ('UCN', 'University College Nordjylland');

insert into PERSONS values ('Jacob', 'Jacob@gmail.com', '20201919', '1994-02-20', 10);