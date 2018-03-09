use PayStation;

/* First create PZone */
CREATE TABLE PZone 
	(	id int IDENTITY(1,1) NOT NULL,
		name nvarchar(50) NOT NULL,
		CONSTRAINT PK_PZone PRIMARY KEY (id)
	)

/* Create PPrice with FK to PZone */
CREATE TABLE PPrice
	(	id int IDENTITY(1,1) NOT NULL,
		price int NOT NULL,
		starttime datetime NOT NULL,
		pZone_id int NOT NULL,
		CONSTRAINT[PK_PPrice] PRIMARY KEY (id),
		CONSTRAINT FK_PPrice_PZone FOREIGN KEY(pZone_id) REFERENCES PZone(id)
	)

/* Create PLot with FK to PZone */
CREATE TABLE dbo.PLot
	(	id int IDENTITY(1,1) NOT NULL,
		name nvarchar(50) NOT NULL,
		zipCode int NOT NULL,
		pZone_id int NOT NULL,
		CONSTRAINT PK_PLot PRIMARY KEY (id),
		CONSTRAINT FK_PLot_PZone FOREIGN KEY(pZone_id) REFERENCES PZone(id)
	)

/* Create PPayStation with FK to PLot */
CREATE TABLE dbo.PPaystation
	(	id int IDENTITY(1,1) NOT NULL,
		model nchar(10) NULL,
		pLot_id int NOT NULL,
		CONSTRAINT PK_PPaystation PRIMARY KEY (id),
		CONSTRAINT FK_PPaystation_PLot FOREIGN KEY(plot_id) REFERENCES PLot(id)
	)

/* Create PBuy with FK to PPayStation */
CREATE TABLE dbo.PBuy(
		id int IDENTITY(1,1) NOT NULL,
		buyTime datetime NOT NULL,
		duration int NOT NULL,
		payedAmount float NOT NULL,
		pPaystation_id int NOT NULL,
		CONSTRAINT PK_PBuy PRIMARY KEY CLUSTERED (id),
		CONSTRAINT FK_PBuy_PPaystation FOREIGN KEY(pPaystation_id) REFERENCES PPaystation(id)
	)