create table Menu
	(
	id int identity(1,1),
	[name] nvarchar (200),

	CONSTRAINT PKMenu_id primary key(id),

	);

create table Seafood
	(
	id int identity(1,1),
	[name] nvarchar (50) NOT NULL,
	[description] nvarchar (200) NOT NULL,
	[menu_id] int,

	CONSTRAINT PKSeafood_id primary key(id),
	CONSTRAINT FKSeafood_Menu foreign key(menu_id) references Menu(id)
	);

