-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 21, 2019 at 05:32 PM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `world_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` varchar(20) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `initials` varchar(10) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalCode` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `tpNO` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Birthday` varchar(50) DEFAULT NULL,
  `createDate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `fullName`, `initials`, `NIC`, `address`, `city`, `postalCode`, `gender`, `tpNO`, `email`, `password`, `Birthday`, `createDate`) VALUES
('A447736', 'Albert Einstein', 'P.L.D.N', '1234567v', 'PANADURA', 'PANADURA', 11111, 'male', '1111111111', 'danualwis24@gmail.com', 'asdfasdf', '1996-11-20', '2019.05.19 10:54:17'),
('A801684', 'JON SNOW', 'J.S.', '96123456V', 'usa', 'b99', 1234, 'male', '123456789', 'sdf@gamail.com', 'john123', NULL, NULL),
('Adjonas21', 'Daniel Jonas', 'D.J', '963029347v', 'No.123, Colombo 03.', 'Colombo', 12340, 'male', '0723049132', 'dJ@gmail.com', 'jonas1122', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bankAccount`
--

CREATE TABLE `bankAccount` (
  `accountNo` int(11) NOT NULL,
  `cBalance` double(10,2) NOT NULL,
  `customerID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankAccount`
--

INSERT INTO `bankAccount` (`accountNo`, `cBalance`, `customerID`) VALUES
(178675381, 7200.00, 'C458983'),
(556177132, 3908.00, 'C218657'),
(677696128, 500.00, 'C226865'),
(792466560, 500.00, 'C107919');

-- --------------------------------------------------------

--
-- Table structure for table `contactus`
--

CREATE TABLE `contactus` (
  `CustomerId` varchar(30) DEFAULT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `subject` varchar(70) NOT NULL,
  `DateTime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactus`
--

INSERT INTO `contactus` (`CustomerId`, `FirstName`, `LastName`, `Email`, `subject`, `DateTime`) VALUES
('wbm001', 'sasika', 'sampath ', 'sasika@gmail.com', ' how create account ', '2019-05-18 12:23:00'),
('wbm002', 'Charith', 'Hettiarachchi', 'charith.rhettiarachchi@gmail.com', 'How can Change password ', '2019-05-18 12:26:14'),
('wbm003', 'Danushka ', 'Alwis', 'danualwis24@gmail.com', 'How transfer money to another account', '2019-05-18 12:27:14');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custID` varchar(20) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `initials` varchar(10) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalCode` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `tpNO` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `accountNumber` int(11) NOT NULL,
  `Birthday` varchar(20) DEFAULT NULL,
  `createDate` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `fullName`, `initials`, `NIC`, `address`, `city`, `postalCode`, `gender`, `tpNO`, `email`, `password`, `accountNumber`, `Birthday`, `createDate`) VALUES
('C107919', 'Robert Crider', 'RSC', '0987654V', '1922 Thorn Street, Mountain View', 'New York', 600, 'male', '775867889', 'robert@gmail.com', 'robert123', 792466560, '19780-05-31', '2019.05.21 08:52:38'),
('C218657', 'sapkan mohomed', 'm.t', '19999999999', 'asdf', 'asdf', 123456, 'male', '123456', 'sliit@my.com', 'Loft1024', 556177132, 'asdf', '2019.05.19 08:09:30'),
('C226865', 'John Watson', 'JBW', '456789V', '1st Cross Street', 'Dehiwela', 900, 'male', '1234567890', 'john@gmaill.com', 'john456', 677696128, '1994-05-31', '2019.05.21 08:53:32'),
('C404199', 'qwer', 'asdf', 'asdf', 'asdf', 'asdf', 1234, 'male', '1234', 'asdf@gmail.com', 'asdf', 456453815, 'asdf', '2019.05.19 09:52:44'),
('C458983', 'Shafkhan', 'MTM', '941522114V', 'Melford Cr', 'Colombo', 600, 'male', '775867889', 'shafkhan@designboo.com.au', 'Loft1024', 178675381, '1994--5-31', '2019.05.20 02:01:48'),
('C575034', 'dsfadfsasdf', 'P.L.D.N', '23455v', 'asdf', 'jidv', 2424, 'male', '12341', 'sd@gmai.com', '1234', 239235251, '2019-05-08', '2019.05.18 02:59:49'),
('C693308', 'asdfasd', 'fasdf', 'asdfasdf', 'asdfasdf', 'asdfasdf', 12341234, 'male', '1234123', 'asdfasdf@gmail.com', 'asdfasdf', 910616238, '1994-07-09`', '2019.05.21 01:18:31'),
('C723400', 'tesing', 'teasdn', '12341234', 'asdasdf', 'asdfas', 1234123, 'male', '1234123', 'asdfasdf@gmail.com', 'asdfasdf', 853057204, '1994-31-09', '2019.05.21 01:14:11'),
('C741788', 'test', 'asdf', 'adf', 'asdf', 'asdf', 16, 'male', '123456789', 'sdf@gamail.com', 'asdf', 972667773, 'asdf', '2019.05.19 10:51:31'),
('C914996', 'abcs', 'P.L.D.sdf', 'dffdfdf344', 'asdf', 'jidv', 2424, 'male', '12341', 'sdsdfs@gmai.com', '1234', 116333631, '2019-05-08', '2019.05.18 03:01:36'),
('C920834', 'table', 'asdf', 'asdf', 'asdf', 'asdf', 123, 'male', '123', 'asdf@gmail.com', 'asdf', 764335834, '1989/11/04', '2019.05.19 11:10:28'),
('Cc12345s', 'Danushka', 'P.L.D.N', '968242848v', 'asdf', 'asdf', 2424, 'male', '23454', 'crhforjobs12@gmail.com', 'as', 2352, NULL, NULL),
('Ccc3456', 'dan', 'asdf', 'osad', 'asdf', 'asdf', 2424, 'male', '23454', 'crhforjobs12@gmail.com', 'qw', 3213, 'null', '2019-05-09 00.00.00'),
('CWB10', 'Chiran Perera', 'C P', '98348324v', 'No,34 Galle.', 'Galle', 1345, 'male', '0340238', 'chiran@gmail.com', 'ch121', 324123, NULL, NULL),
('CWB121', 'Charith Randika Hettiarachchi', 'C.R', '963002309v', 'no.176/1 Panadura ', 'Panadura', 1235, 'male', '9234234123', 'randikah17@gmail.com', 'sliit121', 123456789, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `empID` varchar(20) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `initials` varchar(10) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(20) NOT NULL,
  `postalCode` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `tpNO` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Birthday` varchar(50) DEFAULT NULL,
  `createDate` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`empID`, `fullName`, `initials`, `NIC`, `address`, `city`, `postalCode`, `gender`, `tpNO`, `email`, `password`, `Birthday`, `createDate`) VALUES
('E125295', 'Terry Long', 'TRL', '3456789V', '21st Jump Street', 'California', 900, 'male', '3456789', 'terry@gmail.com', 'terry123', '1897-09-14', '2019.05.21 08:58:12'),
('EMP1212', 'John Silva', 'JS', '023409234v', 'no.100 dehiwala', 'dehiwala', 1234, 'male', '21349532', 'js@gmail.com', 'silva123', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `vid` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `accountNo` varchar(20) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`vid`, `amount`, `accountNo`, `date`) VALUES
(1, 6575, '123', '2019-05-18 11:29:50'),
(2, 4500, '234', '2019-05-18 11:37:35'),
(3, 2200, '345', '2019-05-18 11:42:09'),
(4, 3500, '80130461', '2019-05-18 13:02:58'),
(5, 3113, '12124', '2019-05-18 14:49:16'),
(6, 3113, '12124', '2019-05-18 14:50:25'),
(7, 3113, '12124', '2019-05-18 14:52:37'),
(8, 213123, '12', '2019-05-18 14:53:18'),
(9, 12334, '123', '2019-05-19 11:36:25');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` int(20) NOT NULL,
  `recieverAccNo` int(11) NOT NULL,
  `senderAccNo` int(11) NOT NULL,
  `transactionDate` varchar(25) NOT NULL,
  `amount` double(10,2) NOT NULL,
  `senderRem` varchar(15) NOT NULL,
  `recRemark` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `recieverAccNo`, `senderAccNo`, `transactionDate`, `amount`, `senderRem`, `recRemark`) VALUES
(17, 556177132, 178675381, '2019.22.21 10:22:35', 100.00, 'Sender', 'Ben'),
(18, 556177132, 178675381, '2019.29.21 10:29:08', 140.90, 'sedner', 'sender'),
(19, 556177132, 178675381, '2019.30.21 10:30:50', 90.45, 'sender', 'ban'),
(20, 853057204, 178675381, '2019.10.21 03:10:42', 12.00, 'asdf', 'asdfasd'),
(21, 853057204, 178675381, '2019.22.21 03:22:55', 150.00, 'mobile payment', 'mobile payment'),
(22, 853057204, 178675381, '2019.41.18 03:41:38', 500.00, 'mobile payment', 'mobile payment'),
(23, 910616238, 178675381, '2019.33.21 07:33:54', 678.90, 'asdfasdf', 'asdfasdf'),
(24, 910616238, 178675381, '2019.34.21 07:34:29', -900000.00, 'sdfasdf', 'asdfasd'),
(25, 764335834, 178675381, '2019.46.21 07:46:17', 10.00, 'asdfasdf', 'asdfa'),
(26, 764335834, 178675381, '2019.48.21 07:48:13', 10.00, 'asdf', 'asdf'),
(27, 764335834, 178675381, '2019.53.21 07:53:14', 100.00, 'asdfas', 'asdfa'),
(28, 764335834, 178675381, '2019.54.21 07:54:45', 100.00, 'asdfas', 'asdf'),
(29, 178675381, 556177132, '2019.02.21 09:02:04', 7000.00, 'sending q', 'ben');

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `options` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `name`, `options`) VALUES
(1, 'Electricity', '2'),
(2, 'Higher Education', '2'),
(3, 'Higher Education', '2'),
(4, 'Education', '1'),
(5, 'Higher Education', '3'),
(6, 'Telephone', '3'),
(7, 'water Board', '4'),
(8, 'water Board', '2'),
(9, 'Electricity', '1'),
(10, 'Electricity', '1'),
(11, 'Electricity', '1'),
(12, 'Higher Education', '3'),
(13, 'Higher Education', '3'),
(14, 'Higher Education', '3'),
(15, 'Higher Education', '3'),
(16, 'Education', '2'),
(17, 'Higher Education', '3'),
(18, 'Education', '2'),
(19, 'Higher Education', '1'),
(20, 'Higher Education', '1'),
(21, 'Higher Education', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `bankAccount`
--
ALTER TABLE `bankAccount`
  ADD PRIMARY KEY (`accountNo`),
  ADD KEY `customerID` (`customerID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custID`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD KEY `fk_1` (`vid`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `vid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transactionID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bankAccount`
--
ALTER TABLE `bankAccount`
  ADD CONSTRAINT `bankaccount_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`custID`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_1` FOREIGN KEY (`vid`) REFERENCES `vendor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
