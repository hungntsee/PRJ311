USE [master]
GO
/****** Object:  Database [MotorcycleManagement]    Script Date: 5/27/2021 11:43:06 AM ******/
CREATE DATABASE [MotorcycleManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MotorcycleManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MotorcycleManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MotorcycleManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MotorcycleManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [MotorcycleManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MotorcycleManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MotorcycleManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET  MULTI_USER 
GO
ALTER DATABASE [MotorcycleManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MotorcycleManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MotorcycleManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MotorcycleManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [MotorcycleManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [MotorcycleManagement] SET QUERY_STORE = OFF
GO
USE [MotorcycleManagement]
GO
/****** Object:  Table [dbo].[tblBike]    Script Date: 5/27/2021 11:43:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBike](
	[motorcycleID] [varchar](10) NULL,
	[model] [nvarchar](50) NULL,
	[year] [datetime] NULL,
	[condition] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[warranty] [nvarchar](50) NULL,
	[brandID] [varchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBrand]    Script Date: 5/27/2021 11:43:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBrand](
	[brandID] [varchar](10) NOT NULL,
	[brandName] [nvarchar](50) NULL,
	[country] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
 CONSTRAINT [PK_tblBrand] PRIMARY KEY CLUSTERED 
(
	[brandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 5/27/2021 11:43:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'E001', N'X-game', CAST(N'2020-07-08T00:00:00.000' AS DateTime), N'Good', 1000, 3, N'Good', N'C')
INSERT [dbo].[tblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'E002', N'Bike', CAST(N'2021-02-19T00:00:00.000' AS DateTime), N'Good ', 2000, 4, N'Good', N'T')
GO
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'C', N'Cervelo', N'America', N'Good')
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'T', N'Trinx', N'Taiwan', N'Good')
GO
INSERT [dbo].[tblUser] ([userID], [fullName], [password], [status]) VALUES (N'Hung', N'TienHung', N'123', 1)
GO
USE [master]
GO
ALTER DATABASE [MotorcycleManagement] SET  READ_WRITE 
GO
