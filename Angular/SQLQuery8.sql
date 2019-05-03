/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP (1000) [AuthorId]
      ,[ContactNumber]
      ,[Address]
  FROM [BookStore].[dbo].[AuthorContact]
  
  GO

  SELECT TOP (1000) [Id]
      ,[NAME]
  FROM [BookStore].[dbo].[Author]

  GO

  SELECT TOP (1000) [Id]
      ,[Title]
      ,[CategoryId]
      ,[PublisherId]
  FROM [BookStore].[dbo].[Book]

  GO

  SELECT TOP (1000) [BookId]
      ,[AuthorId]
  FROM [BookStore].[dbo].[BookAuthors]

  GO

  SELECT TOP (1000) [Id]
      ,[NAME]
  FROM [BookStore].[dbo].[BookCategory]

  GO

  SELECT TOP (1000) [Id]
      ,[NAME]
  FROM [BookStore].[dbo].[Publisher]

  GO