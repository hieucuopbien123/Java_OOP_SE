-- Reset database
-- Start
Drop table rental
Drop table xTransaction
Drop table Card
Drop table eBike
Drop table Bike
Drop table Dock
-- End


-- Tạo database
-- Start
Use IDSProject
Go
Create table Dock (
  dock_id int primary key IDENTITY (1, 1),
  name varchar(256),
  address varchar(256) NOT NULL,
  area float,
  number_of_bike int,
  number_of_empty_spot int,
  distance int,
  img varchar(256)
)
GO
INSERT INTO Dock VALUES
(N'Back Khoa Dock', N'Back Khoa', 100, 10, 0, 100, N'assets/dock1.jpg'),
(N'Cau Giay Dock', N'Vu Chi Thang', 200, 5, 5, 500, N'assets/dock2.jpg'),
(N'Hai Ba Trung Dock', N'Hai Ba Trung', 100, 1, 9, 300, N'assets/dock4.jpg'),
(N'Le Chan Dock', N'Le Chan', 400, 2, 8, 300, N'assets/dock3.jpg')

Create table Bike(
  bike_code varchar(10) primary key,
  license_plate varchar(32),
  status int, -- 0 la hong, 1 la cu, 2 la tot
  image varchar(256),
  dock_id int NOT NULL FOREIGN KEY REFERENCES Dock(dock_id),
  biketype int, -- 1 là đơn, 2 là đôi
  is_renting int, -- 0 là chưa, 1 là rồi
)

GO
INSERT INTO Bike VALUES
(N'20194867', N'HP74115', 2, N'assets/singleE.png', 1, 1, 0),
(N'20194761', N'HP74117', 2, N'assets/doubleE.png', 1, 2, 0),
(N'20197894', N'HP74116', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20161234', N'HP74114', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20161235', N'HP74112', 1, N'assets/doubleE.png', 1, 2, 0),
(N'20161236', N'HP74111', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20161237', N'HP74113', 2, N'assets/singleE.png', 1, 1, 0),
(N'20161238', N'HP74119', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20161239', N'HP74110', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20161230', N'HP74121', 1, N'assets/singlenorm.png', 1, 1, 0),
(N'20171234', N'HP74122', 2, N'assets/doubleE.png', 2, 2, 0),
(N'20171235', N'HP74123', 2, N'assets/singleE.png', 2, 1, 0),
(N'20171236', N'HP74124', 0, N'assets/doublenorm.png', 2, 2, 0),
(N'20171237', N'HP74125', 2, N'assets/doublenorm.png', 2, 2, 0),
(N'20194868', N'HP74126', 0, N'assets/doublenorm.png', 2, 2, 0),
(N'20171238', N'HP74127', 2, N'assets/singlenorm.png', 3, 1, 0),
(N'20171239', N'HP74128', 1, N'assets/singlenorm.png', 4, 1, 0),
(N'20171230', N'HP74129', 2, N'assets/doubleE.png', 4, 2, 0)

Create table eBike (
  id varchar(10) primary key,
  battery int NOT NULL,
  FOREIGN KEY (id) REFERENCES Bike(bike_code)
)

GO
INSERT INTO eBike VALUES
(N'20194867', 70),
(N'20194761', 100),
(N'20161235', 70),
(N'20161237', 70),
(N'20171235', 70),
(N'20171234', 70),
(N'20171230', 70)

Create table Card (
  card_number varchar(20) primary key,
  cardholder_name varchar(256) NOT NULL,
  expiration_date Date,
  issuing_bank varchar(256) NOT NULL, 
  security_code varchar(256),
  cvvCode int
)
GO

INSERT INTO Card VALUES
(N'031201002655', N'Nguyen Thu Hien', '2005-01-23', N'MB Bank', '20194762', 101)

Create table xTransaction (
  tx_id int primary key IDENTITY (1, 1),
  bike_code varchar(10),
  card_number varchar(20),
  tx_date Date,
  tx_description varchar(256),
  tx_amount int NOT NULL,
  FOREIGN KEY (bike_code) REFERENCES Bike(bike_code),
  FOREIGN KEY (card_number) REFERENCES Card(card_number)
)
GO

INSERT INTO xTransaction VALUES
(N'20194867', N'031201002655', '2004-01-22', N'Deposit', 100000)

Create table Rental (
  rent_id int primary key IDENTITY(1,1),
  tx_id int FOREIGN KEY REFERENCES xTransaction(tx_id),
  starttime Datetime,
  endtime Datetime
)

GO
INSERT INTO Rental
OUTPUT Inserted.rent_id
VALUES (1, N'2019-04-06 10:03:32', N'2019-04-06 17:03:32')
-- END