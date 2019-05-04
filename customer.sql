-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 04, 2019 at 11:38 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

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
  `Birthday` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `tpNO` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `createDate` date NOT NULL,
  `accountNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `fullName`, `initials`, `NIC`, `address`, `city`, `postalCode`, `Birthday`, `gender`, `tpNO`, `email`, `password`, `createDate`, `accountNumber`) VALUES
('CWB10', 'Chiran Perera', 'C P', '98348324v', 'No,34 Galle.', 'Galle', 1345, '1980-01-03', 'male', '0340238', 'chiran@gmail.com', 'ch121', '2019-05-02', 324123),
('CWB121', 'Charith Randika Hettiarachchi', 'C.R', '963002309v', 'no.176/1 Panadura ', 'Panadura', 1235, '1996-10-26', 'male', '9234234123', 'randikah17@gmail.com', 'sliit121', '2019-04-16', 123456789);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
