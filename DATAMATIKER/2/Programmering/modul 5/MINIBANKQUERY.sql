use minibank;
select * from posting, account where account.id = posting.account_id;

--select sum(posting) as balance from posting group by (account_id);

select c_name, a_name, bal.balance from 
	(select account.id as a_id, customer.name as c_name, 
	account.name as a_name from account, customer where customer.id = account.customer_id) acc
inner join
	(select account_id, sum(posting) as balance from posting group by(account_id)) bal on acc.a_id = bal.account_id;