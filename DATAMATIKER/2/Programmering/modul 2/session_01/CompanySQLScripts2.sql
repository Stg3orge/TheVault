-- drop if necessary, then create "company"
use master;
if exists (select * from sys.databases where name='company')
	drop database company;
go

create database company;
go

use company;

-- create tables

create table Department(
	dname      varchar(15) not null,
    dnumber    int         not null,
    mgr_ssn     char(9)     not null,
    mgr_start_date datetime,
    primary key (dnumber),
    unique(dname)
);

create table Employee(
	fname       varchar(15) not null,
    minit       char,
    lname       varchar(15) not null,
    ssn         char(9),
    bdate       datetime,
    address     varchar(30),
    sex         char,
    salary      decimal(10,2),
    super_ssn    char(9),
    dno         int         not null,
    primary key (ssn),
    foreign key(super_ssn) references employee(ssn),
    foreign key (dno) references Department(dnumber)
);

create table Dept_Locations(
	dnumber     int        not null,
    dlocation   varchar(15) not null,
    primary key(dnumber, dlocation),
    foreign key (dnumber) references Department(dnumber)
);

create table Project(
	pname      varchar(15)  not null,
    pnumber    int          not null,
    plocation  varchar(15),
    dnum       int          not null,
    primary key (pnumber),
    unique(pname),
    foreign key (dnum) references Department(dnumber)
);

create table Works_on(
	essn       char(9)      not null,
    pno        int          not null,
    hours      decimal(3,1) not null,
    primary key(essn, pno),
    foreign key(essn) references Employee(ssn),
    foreign key(pno) references Project(pnumber)
);

create  table Dependent(
	essn           char(9)     not null,
    dependent_name varchar(15) not null,
    sex            char,
    bdate          datetime,
    relationship   varchar(8),
    primary key (essn,dependent_name),
    foreign key (essn) references Employee(ssn)
);

-- insert data
insert into department values('Research', 5, '333445555','19880522');
insert into department values('Administration',4,'987654321','19950101');
insert into department values('Headquarters',1,'888665555','19810619');

insert into employee values ('James','E','Borg','888665555','19371110','450 Stone, Houston,TX','M',55000,null,1);
insert into employee values ('Franklin','T', 'Wong','333445555','19551208','638 Voss, Houston, TX','M',40000,'888665555',5);
insert into employee values ('Jennifer','S','Wallace','987654321','19410620','291,Berry, Belaire,TX','F',43000,'888665555',4);
insert into employee values ('Alicia','J','Zelaya','999887777','19680119','3321 Castle, Spring,TC','F',25000,'987654321',4);
insert into employee values ('Ramesh','K','Narayalan','666884444','19620915','975, Fire Oak, Humble, TX','M',38000,'333445555',5);
insert into employee values ('John','B','Smith','123456789','19650109','731 Fondren, Houston,TX','M',30000,'333445555',5);
insert into employee values ('Joyce','A','English','453453453','19720731','5631Rice Houston,TX','F',25000,'333445555',5);
insert into employee values ('Ahmad','V','Jabbar','987987987','19690329','980 Dallas Houston, TX','M',25000,'987654321',4);

insert into dept_locations values(1,'Houston');
insert into dept_locations values(4,'Stafford');
insert into dept_locations values (5,'Bellaire');
insert into dept_locations values (5,'Sugarland');
insert into dept_locations values (5,'Houston');

insert into project values ('ProductX',1,'Bellaire',5);
insert into project values ('ProductY',2,'Sugarland',5);
insert into project values ('ProductZ',3,'Houston',5);
insert into project values ('Computerzation',10,'Stafford',4);
insert into project values ('Reorganization',20,'Houston',1);
insert into project values ('Newbenefits',30,'Stafford',4);

insert into works_on values ('123456789',1,32.5);
insert into works_on values ('123456789',2,7.5);
insert into works_on values ('666884444',3,40);
insert into works_on values ('453453453',1,20);
insert into works_on values ('453453453',2,20);
insert into works_on values ('333445555',2,10);
insert into works_on values ('333445555',3,10);
insert into works_on values ('333445555',10,10);
insert into works_on values ('333445555',20,10);
insert into works_on values ('999887777',30,30);
insert into works_on values ('999887777',10,10);
insert into works_on values ('987987987',10,35);
insert into works_on values ('987987987',30,5);
insert into works_on values ('987654321',30,20);
insert into works_on values ('987654321',20,15);
insert into works_on values ('888665555',20,0);

insert into dependent values('333445555','Alice','F','19860405','Daugther');
insert into dependent values('333445555','Theodore','M','19831025','Son');
insert into dependent values('333445555','Joy','F','19580503','Spouse');
insert into dependent values('987654321','Abner','M','19420228','Spouse');
insert into dependent values('123456789','Michael','M','19880104','Son');
insert into dependent values('123456789','Alice','F','19881230','Daugther');
insert into dependent values('123456789','Elizabeth','F','19670505','Spouse');

ALTER TABLE Department
ADD CONSTRAINT fk_DepEmpl
foreign key(mgr_ssn) references employee(ssn)

use master;