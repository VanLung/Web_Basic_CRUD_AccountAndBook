USE [master]
GO
/****** Object:  Database [BookShop]    Script Date: 7/12/2021 7:36:19 AM ******/
CREATE DATABASE [BookShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\BookShop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\BookShop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BookShop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookShop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BookShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookShop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BookShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookShop] SET  MULTI_USER 
GO
ALTER DATABASE [BookShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookShop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookShop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BookShop] SET QUERY_STORE = OFF
GO
USE [BookShop]
GO
/****** Object:  Table [dbo].[tblBooks]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBooks](
	[bookID] [varchar](10) NOT NULL,
	[bookName] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[price] [money] NOT NULL,
	[quantity] [int] NOT NULL,
	[statusID] [varchar](10) NOT NULL,
	[categoryID] [varchar](10) NOT NULL,
	[image] [varchar](max) NULL,
 CONSTRAINT [PK_tblBooks] PRIMARY KEY CLUSTERED 
(
	[bookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [varchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrderDetails]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetails](
	[orderDetailID] [varchar](10) NOT NULL,
	[orderID] [varchar](10) NOT NULL,
	[bookID] [varchar](10) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [money] NOT NULL,
	[statusID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tblOrderDetails] PRIMARY KEY CLUSTERED 
(
	[orderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrders]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrders](
	[orderID] [varchar](10) NOT NULL,
	[userID] [varchar](10) NOT NULL,
	[address] [nvarchar](50) NULL,
	[phone] [varchar](10) NULL,
	[email] [varchar](50) NULL,
	[totalMoney] [money] NOT NULL,
	[orderDate] [date] NOT NULL,
	[statusID] [varchar](10) NOT NULL,
	[paymentStatus] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblOrders] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [varchar](10) NOT NULL,
	[roleName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblRoles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblStatus]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStatus](
	[statusID] [varchar](10) NOT NULL,
	[statusName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblStatus] PRIMARY KEY CLUSTERED 
(
	[statusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 7/12/2021 7:36:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[userName] [nvarchar](50) NOT NULL,
	[password] [varchar](15) NOT NULL,
	[phone] [varchar](10) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[roleID] [varchar](10) NOT NULL,
	[statusID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B01', N'The Midnight Library', N' Matt Haig', 10.0000, 6, N'S01', N'C01', N'https://productimages.worldofbooks.com/1786892731.jpg')
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B02', N'The Last Family In England', N'Matt Haig', 190.0000, 5, N'S02', N'C02', N'https://productimages.worldofbooks.com/0224072773.jpg')
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B03', N'The Radleys
', N'Matt Haig', 156.0000, 8, N'S03', N'C03', N'https://productimages.worldofbooks.com/178689467X.jpg')
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B04', N'The Beekeeper of Aleppo', N'Christy Lefteri', 98.0000, 3, N'S01', N'C07', N'https://productimages.worldofbooks.com/1838770011.jpg')
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B05', N'All the Light We Cannot See', N'Anthony Doerr', 105.0000, 3, N'S02', N'C04', N'https://productimages.worldofbooks.com/0008138303.jpg')
INSERT [dbo].[tblBooks] ([bookID], [bookName], [description], [price], [quantity], [statusID], [categoryID], [image]) VALUES (N'B06', N'The Memory Wall', N'Anthony Doerr', 207.0000, 5, N'S03', N'C05', N'https://productimages.worldofbooks.com/0007367716.jpg')
GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C01', N'Politics - law books')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C02', N'Economics of Science and Technology Books')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C03', N'Books of Literature and Art')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C04', N'Book of Socio-Cultural - History')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C05', N'Didacticism
(Schoolbook)')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C06', N'Books of Stories, Novels')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C07', N'Books on Psychology, Spirituality, Religion')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'C08', N'Books Children''s Books')
GO
INSERT [dbo].[tblOrderDetails] ([orderDetailID], [orderID], [bookID], [quantity], [price], [statusID]) VALUES (N'ORD01', N'OR01', N'B01', 1, 6.0000, N'S01')
INSERT [dbo].[tblOrderDetails] ([orderDetailID], [orderID], [bookID], [quantity], [price], [statusID]) VALUES (N'ORD02', N'OR02', N'B02', 3, 19.0000, N'S02')
INSERT [dbo].[tblOrderDetails] ([orderDetailID], [orderID], [bookID], [quantity], [price], [statusID]) VALUES (N'ORD03', N'OR03', N'B03', 2, 9.0000, N'S03')
GO
INSERT [dbo].[tblOrders] ([orderID], [userID], [address], [phone], [email], [totalMoney], [orderDate], [statusID], [paymentStatus]) VALUES (N'OR01', N'vanlung', N'HCM', N'0000000000', N'lung@gmail.com', 6.0000, CAST(N'2021-05-07' AS Date), N'S01', N'success')
INSERT [dbo].[tblOrders] ([orderID], [userID], [address], [phone], [email], [totalMoney], [orderDate], [statusID], [paymentStatus]) VALUES (N'OR02', N'vanlungg', N'HCM', N'1111111111', N'g@gmail.com', 9.0000, CAST(N'2021-05-07' AS Date), N'S02', N'success')
INSERT [dbo].[tblOrders] ([orderID], [userID], [address], [phone], [email], [totalMoney], [orderDate], [statusID], [paymentStatus]) VALUES (N'OR03', N'vanlunggg', N'HCM', N'2222222222', N'l@gmail.com', 96.0000, CAST(N'2021-05-07' AS Date), N'S03', N'success')
GO
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'MA', N'Manager')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'S01', N'Viet Nam')
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'S02', N'America')
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'S03', N'Australia')
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'S04', N'Japan')
INSERT [dbo].[tblStatus] ([statusID], [statusName]) VALUES (N'S05', N'China')
GO
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'aaaaa', N'Nguy', N'1', N'0000000000', N'201B/7F áº¤p 2 An PhÃº TÃ¢y, BÃ¬nh ChÃ¡nh, HCMC', N'lung2566555@gmail.com', N'US', N'S04')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'f', N'asda', N'1', N'0900000001', N'hcm', N'aaagg@gmail.com', N'AD', N'S02')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'g', N'a', N'1', N'0900000000', N'hcm', N'a@gmail.com', N'AD', N'S02')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'h', N'asda', N'1', N'0000000000', N'-1', N'a@gmail.com', N'US', N'S01')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'i', N'a', N'1', N'0900000000', N'hcm', N'a@gmail.com', N'US', N'S01')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'k', N'a', N'1', N'0900000000', N'hcm', N'a@gmail.com', N'US', N'S01')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'Van', N'Van', N'1', N'0000000000', N'HCM', N'A@gmail.com', N'US', N'S01')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'vanlung', N'Nguyen Van Lung 1 G', N'1', N'0000000000', N'HCM', N'lung@gmail.com', N'US', N'S01')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'vanlungg', N'Nguyen Van Lungg 2 G', N'1', N'1111111111', N'HCM', N'lungg@gmai.com', N'AD', N'S02')
INSERT [dbo].[tblUsers] ([userID], [userName], [password], [phone], [address], [email], [roleID], [statusID]) VALUES (N'vanlunggg', N'Nguyen Van Lunggg 3 G', N'1', N'2222222222', N'HCM', N'l@gmail.com', N'MA', N'S03')
GO
ALTER TABLE [dbo].[tblBooks]  WITH CHECK ADD  CONSTRAINT [FK_tblBooks_tblCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblBooks] CHECK CONSTRAINT [FK_tblBooks_tblCategory]
GO
ALTER TABLE [dbo].[tblBooks]  WITH CHECK ADD  CONSTRAINT [FK_tblBooks_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblBooks] CHECK CONSTRAINT [FK_tblBooks_tblStatus]
GO
ALTER TABLE [dbo].[tblOrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetails_tblBooks] FOREIGN KEY([bookID])
REFERENCES [dbo].[tblBooks] ([bookID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblOrderDetails] CHECK CONSTRAINT [FK_tblOrderDetails_tblBooks]
GO
ALTER TABLE [dbo].[tblOrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetails_tblOrders] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrders] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderDetails] CHECK CONSTRAINT [FK_tblOrderDetails_tblOrders]
GO
ALTER TABLE [dbo].[tblOrders]  WITH CHECK ADD  CONSTRAINT [FK_tblOrders_tblStatus] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
GO
ALTER TABLE [dbo].[tblOrders] CHECK CONSTRAINT [FK_tblOrders_tblStatus]
GO
ALTER TABLE [dbo].[tblOrders]  WITH CHECK ADD  CONSTRAINT [FK_tblOrders_tblUsers] FOREIGN KEY([userID])
REFERENCES [dbo].[tblUsers] ([userID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblOrders] CHECK CONSTRAINT [FK_tblOrders_tblUsers]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRoles1] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRoles1]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblStatus1] FOREIGN KEY([statusID])
REFERENCES [dbo].[tblStatus] ([statusID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblStatus1]
GO
USE [master]
GO
ALTER DATABASE [BookShop] SET  READ_WRITE 
GO
