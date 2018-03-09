use master;
if exists (select * from sys.databases where name='testchar')
	drop database testchar;
go

create database testchar;
go

use testchar;

create table testcharandvarchar (
	fixed char(10),
	variable varchar(10)
	);


insert into testcharandvarchar values('abcdefghij', 'abcdefghij');
insert into testcharandvarchar values('abc', 'abcdefgh');
--insert into testcharandvarchar values('abcdefghijK', 'abcdefghijK');

select '*' + fixed + '*' as fixed, '*' + variable + '*' as variable from testcharandvarchar;
-- notice the output - the 'fixed' column is padded with whitespace

