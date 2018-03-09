use minibank;
select account_id, sum(posting) from posting
	group by account_id;
use master;