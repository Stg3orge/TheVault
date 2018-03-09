use CascadeCompany;

create table Department
   ( dname      varchar(15) not null,
     dnumber    int         not null,
     mgrssn     char(9)     not null,
     mgrstartdate datetime,
     primary key (dnumber),
     unique(dname));
  


create table Employee
   (fname       varchar(15) not null,
    minit       char,
    lname       varchar(15) not null,
    ssn         char(9),
    bdate       datetime,
    address     varchar(30),
    sex         char,
    salary      decimal(10,2),
    superssn    char(9),
    dno         int         not null default 1,
    primary key (ssn),
    constraint fksuper foreign key(superssn) references employee(ssn),
    constraint fkdept foreign key (dno) references Department(dnumber)
				on delete set default
				on update cascade);

create table Dept_Locations
    (dnumber     int        not null,
     dlocation   varchar(15) not null,
     primary key(dnumber, dlocation),
     constraint fkdeptloc foreign key (dnumber) references Department(dnumber)
		on delete cascade
		 on update cascade);

create table Project
     (pname      varchar(15)  not null,
      pnumber    int          not null,
      plocation  varchar(15),
      dnum       int          not null default 1,
      primary key (pnumber),
      unique(pname),
      constraint fkctrldept foreign key (dnum) references Department(dnumber)
          on delete set default
		  on update cascade);

create table Works_on
     (essn       char(9)      not null,
      pno        int          not null,
      hours      decimal(3,1) not null,
      primary key(essn, pno),
      constraint fkemp foreign key(essn) references Employee(ssn),
      constraint fkpro foreign key(pno) references Project(pnumber));

create  table Dependent
      (essn           char(9)     not null,
       dependent_name varchar(15) not null,
       sex            char,
       bdate          datetime,
       relationship   varchar(8),
       primary key (essn,dependent_name),
       constraint fkfam foreign key (essn) references Employee(ssn)
            on delete cascade);

