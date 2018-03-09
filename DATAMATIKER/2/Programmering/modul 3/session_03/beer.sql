use master;

drop database beer;
go

create database beer;
go

use beer;
 
create table sells(
	bar varchar(20),
	beer varchar(20),
	price float,
	constraint pk_sells primary key (bar, beer)
);

insert into sells values ('Jens', 'Miller', 8);
insert into sells values ('Joe', 'Miller', 10);
insert into sells values ('Joe', 'Bud', 8);
insert into sells values ('Sams', 'Miller', 10);
insert into sells values ('Teis', 'Miller', 10);

select price from sells where bar='joe' and beer='bud';

select bar from sells where beer='miller' and price = (select price from sells where bar='joe' and beer='bud');