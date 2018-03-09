use master;
if exists (select * from sys.databases where name='shop_dmab0917')
	drop database shop_dmab0917;
go

create database shop_dmab0917;
go
use shop_dmab0917;

create table shop_order (
	id int primary key identity(1,1),
	ono varchar(10) not null unique
);

create table shop_product(
	id int primary key identity(1,1),
	name varchar(10) not null unique,
	price decimal(10,2)
);

create table shop_orderline (
	order_id int,
	product_id int,
	qty int not null,
	foreign key (order_id) references shop_order(id)
		on delete cascade,
	foreign  key (product_id) references shop_product(id),
	primary key (order_id, product_id)
);

insert into shop_product (name, price) values ('hammer', 10.95);
insert into shop_product (name, price) values ('tandpasta', 1000.43);
insert into shop_product values ('tandbørste', 5.95); -- also works the same as above two

insert into shop_order values ('12345');
insert into shop_order values ('666054');
insert into shop_order values ('913');

insert into shop_orderline (order_id, product_id, qty) values (1, 1, 2);
insert into shop_orderline (order_id, product_id, qty) values (1, 2, 5);
insert into shop_orderline (order_id, product_id, qty) values (3, 3, 15);