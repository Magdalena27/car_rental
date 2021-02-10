SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [car](
	[carid] [bigint] NOT NULL,
	[brand] [varchar](255) NULL,
	[color] [varchar](255) NULL,
	[engine_capacity] [int] NULL,
	[engine_type] [varchar](255) NULL,
	[model] [varchar](255) NULL,
	[production_year] [int] NULL,
	[rent_price] [float] NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[carid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [car_images](
	[car_imageid] [bigint] NOT NULL,
	[url] [varchar](255) NULL,
	[carid] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[car_imageid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [customer](
	[customerid] [bigint] NOT NULL,
	[age] [int] NULL,
	[email] [varchar](255) NULL,
	[enabled] [int] NULL,
	[login] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[phone_number] [int] NULL,
	[role] [varchar](255) NULL,
	[surname] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[customerid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [rental](
	[rentalid] [bigint] NOT NULL,
	[rental_date] [date] NULL,
	[return_date] [date] NULL,
	[return_extension] [date] NULL,
	[carid] [bigint] NULL,
	[customerid] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[rentalid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (1, N'BMW', N'white', 2000, N'diesel', N'X6', 2020, 600.030029296875, 1)
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (7, N'BMW', N'white', 2000, N'diesel', N'X6', 2020, 600.030029296875, 1)
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (8, N'Lexus', N'white', 3500, N'hybrid', N'RX', 2020, 670.02001953125, 1)
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (9, N'BMW', N'gray', 2500, N'diesel', N'X3', 2017, 470.02999877929688, 1)
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (10, N'Mercedes', N'black', 5500, N'petrol', N'S63', 2019, 580.33001708984375, 1)
INSERT [car] ([carid], [brand], [color], [engine_capacity], [engine_type], [model], [production_year], [rent_price], [status]) VALUES (11, N'Porshe', N'red', 4000, N'diesel', N'Panamera', 2017, 770.54998779296875, 1)
GO
INSERT [customer] ([customerid], [age], [email], [enabled], [login], [name], [password], [phone_number], [role], [surname]) VALUES (2, 50, N'zbigniewporzycz@mojapoczta.pl', 1, N'admin', N'Zbigniew', N'$2a$10$gg1YzNwrXyDCqEy31tCkA.p4cplS1DmxaAV762JWKvRiCPiPJGoqa', 666666666, N'ROLE_ADMIN', N'Porzycz')
INSERT [customer] ([customerid], [age], [email], [enabled], [login], [name], [password], [phone_number], [role], [surname]) VALUES (3, 30, N'annanowak@mojapoczta.pl', 1, N'anna', N'Anna', N'$2a$10$SfLwZwWBasuzY8jj.wFoH.SX8QID4deCPsH9OQAE/4hvM//1nDSYO', 603603603, N'ROLE_USER', N'Nowak')
INSERT [customer] ([customerid], [age], [email], [enabled], [login], [name], [password], [phone_number], [role], [surname]) VALUES (4, 40, N'andrzejkowalik@mojapoczta.pl', 1, N'andrzej', N'Andrzej', N'$2a$10$bGpBh4gg9TI2SOxIusKtceHbMje/HyIibxc6SXf3pp5sts7Rb7m0q', 669669669, N'ROLE_USER', N'Kowalik')
INSERT [customer] ([customerid], [age], [email], [enabled], [login], [name], [password], [phone_number], [role], [surname]) VALUES (5, 35, N'katarzynanowak@mojapoczta.pl', 1, N'katarzyna', N'Katarzyna', N'$2a$10$fUrLad/asNCTnHwInBHkvurc5buWLxVfmlk15QesCltr4wmtA.bqe', 668668668, N'ROLE_USER', N'Nowak')
INSERT [customer] ([customerid], [age], [email], [enabled], [login], [name], [password], [phone_number], [role], [surname]) VALUES (6, 45, N'agatarykowska@mojapoczta.pl', 1, N'agata', N'Agata', N'$2a$10$S80yVdeXAZD4p.jkJneFw./t55/CiTf6YhXF2ePImN3d/MORvXqWG', 667667667, N'ROLE_USER', N'Rykowska')
GO
INSERT [rental] ([rentalid], [rental_date], [return_date], [return_extension], [carid], [customerid]) VALUES (12, CAST(N'2021-02-10' AS Date), CAST(N'2021-02-22' AS Date), CAST(N'2021-02-25' AS Date), 7, 2)
INSERT [rental] ([rentalid], [rental_date], [return_date], [return_extension], [carid], [customerid]) VALUES (13, CAST(N'2021-02-10' AS Date), CAST(N'2021-02-15' AS Date), CAST(N'2021-02-20' AS Date), 8, 3)
INSERT [rental] ([rentalid], [rental_date], [return_date], [return_extension], [carid], [customerid]) VALUES (14, CAST(N'2021-02-22' AS Date), CAST(N'2021-02-25' AS Date), CAST(N'2021-02-28' AS Date), 9, 4)
INSERT [rental] ([rentalid], [rental_date], [return_date], [return_extension], [carid], [customerid]) VALUES (15, CAST(N'2021-03-10' AS Date), CAST(N'2021-03-11' AS Date), CAST(N'2021-03-13' AS Date), 10, 5)
INSERT [rental] ([rentalid], [rental_date], [return_date], [return_extension], [carid], [customerid]) VALUES (16, CAST(N'2021-03-12' AS Date), CAST(N'2021-03-14' AS Date), CAST(N'2021-03-15' AS Date), 11, 6)
GO
ALTER TABLE [car_images]  WITH CHECK ADD  CONSTRAINT [FKdk24m20u07fqhnr453ye1cmos] FOREIGN KEY([carid])
REFERENCES [car] ([carid])
GO
ALTER TABLE [car_images] CHECK CONSTRAINT [FKdk24m20u07fqhnr453ye1cmos]
GO
ALTER TABLE [rental]  WITH CHECK ADD  CONSTRAINT [FK9ueh65r55np4he02qqc726ks] FOREIGN KEY([customerid])
REFERENCES [customer] ([customerid])
GO
ALTER TABLE [rental] CHECK CONSTRAINT [FK9ueh65r55np4he02qqc726ks]
GO
ALTER TABLE [rental]  WITH CHECK ADD  CONSTRAINT [FKk7ko7kih5au6ajmyoxwh1jxtd] FOREIGN KEY([carid])
REFERENCES [car] ([carid])
GO
ALTER TABLE [rental] CHECK CONSTRAINT [FKk7ko7kih5au6ajmyoxwh1jxtd]
GO
