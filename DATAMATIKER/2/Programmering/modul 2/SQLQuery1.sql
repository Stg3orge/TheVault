--select fname, bdate from Employee where ssn= '987987987'

--select fname, lname, dname, dno
--from Employee, Department where fname= 'Joyce' and lname= 'English' and dno= dnumber;
use company;
select Dept_Locations.dlocation, Department.dname, Department.dnumber from Dept_Locations, Department 
where Dept_Locations.dnumber = (select Department.dnumber from Department where Department.dname = 'Research') 
 and Dept_Locations.dnumber = Department.dnumber;

select Employee.fname, Employee.lname, Works_on.hours, Project.plocation
from Employee, Works_on, Project
where Employee.dno = (select Project.dnum from Project where Project.plocation = 'Stafford' and Project.pnumber = Works_on.pno)
 and Employee.ssn = Works_on.essn
 and Project.pnumber = Works_on.pno
 and Works_on.hours > 25;

select  fname, lname, bdate from Employee
	where bdate between '1960-01-01' and '1970-01-01';

select fname, lname from Employee, Dependent
	where 