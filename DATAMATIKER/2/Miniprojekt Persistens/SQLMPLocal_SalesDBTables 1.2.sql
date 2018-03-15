
--drop database MPLocal_SalesDB;
--create database MPLocal_SalesDB;


use MPLocal_SalesDB;

create table CustomerType
	(
	id int identity(1,1),
	type nvarchar(50) NOT NULL,
	constraint PKCustomerType_id primary key(id)
	);

create table Country
	(
	city nvarchar(50),
	country nvarchar(50),
	constraint PKCountry_city primary key(city)
	);

create table City
	(
	zipcode nvarchar(50),
	city nvarchar(50),
	constraint PKCity_zipcode primary key(zipcode),
	constraint FKCity_Country foreign key(city) references Country(city)
	);
	
create table Customer
	(
	id int identity(1,1),
	name nvarchar(50) NOT NULL,
	address nvarchar(50) NOT NULL,
	phoneNo nvarchar(50) NOT NULL,
	email nvarchar(50),
	zipcode nvarchar(50),
	customerType_id int,
	constraint PKCustomer_id primary key(id),
	constraint FKCustomer_CustomerType foreign key(customerType_id) references CustomerType(id),
	constraint FKCustomer_City foreign key(zipcode) references City(zipcode)
	);

create table SalesOrder
	(
	id int identity(1,1),
	date date,
	totalPrice decimal(25,2) NOT NULL,
	customer_id int,
	constraint PKSalesOrder_id primary key(id),
	constraint FKSalesOrder_Customer foreign key(customer_id) references Customer(id)
	);


create table Delivery
	(
	salesOrder_id int,
	deliveryStatus nvarchar(50),
	deliveryDate date,
	deliveryPrice decimal(25,2) NOT NULL,
	constraint PKDelivery_so_id primary key(salesOrder_id),
	constraint FKDelivery_SalesOrder foreign key(salesOrder_id) references SalesOrder(id)
	);

create table Invoice
	(
	salesOrder_id int,
	invoiceNo nvarchar(50),
	paymentDate date,
	constraint PKInvoice_so_id primary key(salesOrder_id),
	constraint FKInvoice_SalesOrder foreign key(salesOrder_id) references SalesOrder(id)
	);

create table Supplier
	(
	id int identity(1,1),
	name nvarchar(50) NOT NULL,
	address nvarchar(50),
	zipcode nvarchar(50),
	phoneNo nvarchar(50) NOT NULL,
	email nvarchar(50),
	constraint PKSupllier_id primary key(id),
	constraint FKSupplier_City foreign key(zipcode) references City(zipcode)
	);

create table Product
	(
	id int identity(1,1),
	name nvarchar(50) NOT NULL,
	countryOfOrigin nvarchar(50),
	purchasePrice decimal(25,2) NOT NULL,
	salesPrice decimal(25,2) NOT NULL,
	rentPrice decimal(25,2),
	isRentable bit,
	type nvarchar(50) NOT NULL,
	supplier_id int,
	constraint PKProduct_id primary key(id),
	constraint FKProduct_Supplier foreign key(supplier_id) references Supplier(id)
	);

create table Clothing
	(
	product_id int,
	size nvarchar(50) NOT NULL,
	colour nvarchar(50) NOT NULL,
	constraint PKClothing_product_id primary key(product_id),
	constraint FKClothing_Product foreign key(product_id) references Product(id)
	);

create table Equipment
	(
	product_id int,
	type nvarchar(50) NOT NULL,
	description nvarchar(200) NOT NULL,
	constraint PKEquipment_product_id primary key(product_id),
	constraint FKEquipment_Product foreign key(product_id) references Product(id)
	);

create table GunReplicas
	(
	product_id int,
	calibre nvarchar(50) NOT NULL,
	material nvarchar(50) NOT NULL,
	constraint PKGunReplicas_product_id primary key(product_id),
	constraint FKGunReplicas_Product foreign key(product_id) references Product(id)
	);

create table Storage
	(
	id int identity(1,1),
	location nvarchar(50) NOT NULL,
	constraint PKStorage_id primary key(id)
	);

create table ProductStorage
	(
	product_id int,
	storage_id int,
	minStock int,
	stock int NOT NULL,
	constraint CPKProductStorage_product_id_storage_id primary key(product_id, storage_id),
	constraint FKProductStorage_Product foreign key(product_id) references Product(id),
	constraint FKProductStorage_Storage foreign key(storage_id) references Storage(id)
	);

create table SalesOrderLine
	(
	id int identity(1,1),
	salesOrder_id int,
	product_id int,
	amount int NOT NULL,
	constraint PKSalesOrderLine_id primary key(id),
	constraint FKSalesOrderLine_SalesOrder foreign key(salesorder_id) references SalesOrder(id),
	constraint FKSalesOrderLine_Product foreign key(product_id) references Product(id)
	);

create table RentOut
	(
	salesOrderLine_id int,
	rentDate date,
	returnDate date,
	constraint PKRentOut_salesOrderLine_id primary key(salesOrderLine_id),
	constraint FKRentOut_SalesOrderLine foreign key(salesOrderLine_id) references SalesOrderLine(id)
	);









use master;