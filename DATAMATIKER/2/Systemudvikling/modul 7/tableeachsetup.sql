use librarybookcd;

create table MATERIAL(
mid int identity(1,1) primary key,
title nvarchar(55),
publishedyear date,
type nvarchar(20) not null
);

create table BOOK(
bid int identity(1,1) primary key,
ISBN nvarchar(15),
author nvarchar(30),
mid int foreign key references MATERIAL(mid)
);

create table CD(
cid int identity(1,1) primary key,
length int,
mid int foreign key references MATERIAL(mid)
);