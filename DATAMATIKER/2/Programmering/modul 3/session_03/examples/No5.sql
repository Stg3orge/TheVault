use OtherCompany;

select Department.dnumber, Department.dname, Dept_Locations.dlocation
from Department
inner join Dept_Locations
on Department.dnumber = Dept_Locations.dnumber