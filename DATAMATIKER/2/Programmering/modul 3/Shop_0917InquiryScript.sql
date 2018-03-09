use shop_dmab0917;

--select * from shop_product;
--select * from shop_order;
--select * from shop_orderline;

select ono, name, qty, price as 'Stk Pris', qty * price as subtotal from shop_product, shop_orderline, shop_order
	where shop_orderline.product_id = shop_product.id
	and	shop_orderline.order_id = shop_order.id;

use master;
