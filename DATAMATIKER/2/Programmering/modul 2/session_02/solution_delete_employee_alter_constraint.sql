use CascadeCompany;

alter table works_on drop constraint fkemp;
alter table works_on add constraint 
	fkemp foreign key(essn) references Employee(ssn)
	on delete cascade;