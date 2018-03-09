use OtherCompany;

select e.fname + e.lname as 'Employee name', s.fname + s.lname as 'Boss'
from employee e, employee s
where e.super_ssn = s.ssn;
