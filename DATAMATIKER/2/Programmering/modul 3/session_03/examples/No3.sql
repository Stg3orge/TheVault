use OtherCompany;

select fname + ' ' + lname as fullName
from Employee
where super_ssn is null