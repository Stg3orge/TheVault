use beer;

-- bars that sells miller for the price joes serves bud

select bar from sells where beer = 'miller' and price = ( -- second
	select price from sells where bar = 'Joe' and beer = 'bud' -- first
	)