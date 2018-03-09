use PayStation;


SET IDENTITY_INSERT  PZone  ON
GO

INSERT PZone(id, name) VALUES (1, 'A zone')
INSERT PZone(id, name) VALUES (2, 'B zone')
INSERT PZone(id, name) VALUES (3, 'C zone')
GO

SET IDENTITY_INSERT  PZone  OFF
GO


SET IDENTITY_INSERT PLot  ON 

GO
INSERT  PLot( id ,  name ,  zipCode ,  pZone_id ) VALUES (1, N'Ved den gule bygning', 9100, 1)
GO
INSERT  PLot( id ,  name ,  zipCode ,  pZone_id ) VALUES (2, N'Ved vandmanden', 9200, 2)
GO
INSERT  PLot( id ,  name ,  zipCode ,  pZone_id ) VALUES (3, N'Skalborg', 9200, 3)
GO

SET IDENTITY_INSERT  PLot  OFF
GO


SET IDENTITY_INSERT  PPaystation  ON 

GO
INSERT  PPaystation  ( id ,  model ,  pLot_id ) VALUES (1, N'B-423E    ', 2)
GO

SET IDENTITY_INSERT  PPaystation  OFF
GO


SET IDENTITY_INSERT  PPrice  ON 

GO
INSERT  PPrice  ( id ,  price ,  starttime ,  pZone_id ) VALUES (1, 23, CAST(N'2015-01-31 00:00:00.000' AS DateTime), 2)
GO
INSERT  PPrice  ( id ,  price ,  starttime ,  pZone_id ) VALUES (3, 24, CAST(N'2016-01-31 00:00:00.000' AS DateTime), 2)
GO
INSERT  PPrice  ( id ,  price ,  starttime ,  pZone_id ) VALUES (4, 25, CAST(N'2018-01-31 00:00:00.000' AS DateTime), 2)
GO
INSERT  PPrice  ( id ,  price ,  starttime ,  pZone_id ) VALUES (5, 35, CAST(N'2015-01-31 00:00:00.000' AS DateTime), 1)
GO
INSERT  PPrice  ( id ,  price ,  starttime ,  pZone_id ) VALUES (6, 15, CAST(N'2015-01-31 00:00:00.000' AS DateTime), 3)
GO

SET IDENTITY_INSERT  PPrice  OFF
GO