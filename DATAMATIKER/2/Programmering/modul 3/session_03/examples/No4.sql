use OtherCompany;

select Department.dnumber, Department.dname, loc.dlocation
from Department, Dept_Locations as loc
where Department.dnumber = loc.dnumber