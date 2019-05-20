-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 19, 2019 at 07:41 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Bank_app`
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
('A447736', 'Dan', 'P.L.D.N', '1234567v', 'PANADURA', 'PANADURA', 11111, 'male', '1111111111', 'danualwis24@gmail.com', 'ASDF', '1996-11-20', '2019.05.19 10:54:17'),
('A801684', 'JON SNOW', 'J.S.', '96123456V', 'usa', 'b99', 1234, 'male', '123456789', 'sdf@gamail.com', 'john', NULL, NULL),
('Adjonas21', 'Daniel Jonas', 'D.J', '963029347v', 'No.123, Colombo 03.', 'Colombo', 12340, 'male', '0723049132', 'dJ@gmail.com', 'jonas1122', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bankAccount`
--

CREATE TABLE `bankAccount` (
  `accountNo` int(11) NOT NULL,
  `cBalance` double NOT NULL,
  `customerID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankAccount`
--

INSERT INTO `bankAccount` (`accountNo`, `cBalance`, `customerID`) VALUES
(1232, 1223, 'Ccc3456'),
(4525, 3423, 'C123456'),
(21323, 3423, 'Cc12345s'),
(324123, 21213.23, 'CWB10'),
(123456789, 100000, 'CWB121'),
(556177132, 10000, 'C218657'),
(764335834, 0, 'C920834');

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
('C000001', 'Danushka Nuwan Alwis', 'P.L.', '963251327V', 'usa', 'b99', 999999, 'male', '0123456789', 'dhanushkanuwan24@gmail.com', 'newpw', 123456789, '1996-11-20', '2019-05-20'),
('C123456', ' Danushka Nuwan', 'P.L.D.N', 'osad', 'asdf', 'asdf', 1234567, 'male', '1234567', 'crhforjobs12@gmail.com', 'as', 324, 'null', '2019-05-09 00.00.00'),
('C218657', 'sapkan mohomed', 'm.t', '19999999999', 'asdf', 'asdf', 123456, 'male', '123456', 'sliit@my.com', 'sapkan', 556177132, 'asdf', '2019.05.19 08:09:30'),
('C404199', 'qwer', 'asdf', 'asdf', 'asdf', 'asdf', 1234, 'male', '1234', 'asdf@gmail.com', 'asdf', 456453815, 'asdf', '2019.05.19 09:52:44'),
('C575034', 'dsfadfsasdf', 'P.L.D.N', '23455v', 'asdf', 'jidv', 2424, 'male', '12341', 'sd@gmai.com', '1234', 239235251, '2019-05-08', '2019.05.18 02:59:49'),
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
('E685322', 'sapkan mohomed', 'm.t', '20002343254', 'dehiwala ', 'dehiwala', 123, 'male', '132', 'sdf@gamail.com', 'asdf', 'sdf156', '2019.05.19 10:52:51'),
('EMP1212', 'John Silva', 'JS', '023409234v', 'no.100 dehiwala', 'dehiwala', 1234, 'male', '21349532', 'js@gmail.com', 'js121', NULL, NULL);

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
  `transactionID` varchar(20) NOT NULL,
  `recieverAccNo` int(11) NOT NULL,
  `senderAccNo` int(11) NOT NULL,
  `transactionDate` datetime NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
