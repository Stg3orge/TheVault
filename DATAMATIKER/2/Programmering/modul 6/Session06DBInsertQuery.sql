use Session06DB;

select * from PERSONS;

select * from GROUPS;

SELECT GROUPS.id, GROUPS.name, GROUPS.description, PERSONS.name as person_name
FROM GROUPS
INNER JOIN PERSONS ON GROUPS.id=PERSONS.group_id;