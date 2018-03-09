alter table department
add constraint FKMgr foreign key(mgrssn)
           references employee(ssn)