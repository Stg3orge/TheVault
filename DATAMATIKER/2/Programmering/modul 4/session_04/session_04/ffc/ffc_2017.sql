use master;
if exists(select * from sys.databases where name='ffc')
	drop database ffc;
go
CREATE database ffc;
go
use ffc;

create table breed(
	id int primary key identity(1,1),
	name varchar(20) not null,
	max_weight int,
	description varchar(256)
)

create table member (
	id int primary key identity(1,1),
	name varchar(40) not null,
	email varchar(40),
	phone varchar(40)
)

create table dog (
	id int primary key identity(1,1),
	name varchar(20) not null,
	fee_year int default 0 not null,
	breed_id int foreign key references breed(id) on delete set null on update cascade,
	member_id int foreign key references member(id) on delete cascade on update cascade
)

insert into breed values ('Alaskan Malamute', 39, 'The Alaskan Malamute is a large breed of domestic dog (Canis lupus familiaris) originally bred for hauling heavy freight because of their strength and endurance, and later an Alaskan sled dog.');
insert into breed values ('Norwegian Elkhound', 23, 'The Norwegian Elkhound is one of the ancient Northern Spitz-type breed of dog and is the National Dog of Norway.');
insert into breed values ('Komondor', 60, 'The Komondor, is a large, white-coloured breed of livestock guardian dog with a long, corded coat.');

insert into member values ('Gunnar Kaasen', 'gunnar@alaska.us', '12121212');
insert into dog values ('Balto', 1925, 1, 1);

insert into member values ('Ole Agnar', 'ag-nordm@online.no', '41502799');
insert into dog values ('Dubi', 2016, 2, 2);
insert into dog values ('Lia', 2016, 2, 2);

insert into member values ('Banana Joe', 'joe@banana-island.com', '648484');

-- example inner join (member and dog)
select m.name, m.email, m.phone, d.name, d.fee_year, b.name, b.description from member m, dog d, breed b where m.id = d.member_id and b.id = d.breed_id;

-- example left outer join (member and (dog and breed)) <-- left outer = members without dogs are also shown
select m.name, m.email, m.phone, x.dname, x.dfee_year, x.bname, x.bdescription from 
	member m 
left outer join 
	(select dog.member_id as dmember_id, dog.name as dname, dog.fee_year as dfee_year, breed.name as bname, breed.description as bdescription from dog, breed where breed.id = dog.breed_id) x
on x.dmember_id = m.id;

-- see what the above would result in without specifying LEFT OUTER before the JOIN (where is Joe?)

