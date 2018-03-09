drop view workhours;
go

create view workhours as 
(
	select pname, projectHours.tot from 
	project join (
	select pno, sum(hours) as tot
	from works_on
	group by pno
	) projectHours
	on pnumber = pno
);
go

select * from workhours