use master;
if exists (select * from sys.databases where name='minibank')
	drop database minibank;
go
create database minibank;
go

use minibank;

create table customer (
	id int primary key identity(1,1),
	name varchar(20) not null
);

create table account (
	id int primary key identity(1, 1),
	name varchar(20) not null,
	customer_id int foreign key references customer(id) on delete set null on update cascade
);

create table posting (
	id int primary key identity(1,1),
    account_id int not null foreign key references account(id) on delete cascade on update cascade,
	posting float not null default 0
)


insert into customer values ('Joe');
insert into customer values ('Jane');
insert into account values('boat saving', 1);
insert into account values('checking', 2);
insert into account values('retirement', 2);
insert into posting values (1, 200); -- joe saves money
insert into posting values (1, 150); -- joe saves money
insert into posting values (2, 2200); -- jane gets her salary
insert into posting values (2, 2250); -- jane gets her salary after a raise
insert into posting values (3, 700); -- jane saves some money for retirement

--select account_id, sum(posting.posting) as balance from posting group by account_id;

select cust_name, account_name, balance from (
		(select account.id as acc_id, customer.name as cust_name , account.name as account_name from customer, account where customer.id = account.customer_id ) foo
	inner join 
		(select account_id, sum(posting.posting) as balance from posting group by account_id) bal 
	on foo.acc_id = bal.account_id
);

