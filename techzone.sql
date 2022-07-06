-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 17, 2021 at 01:20 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techzone`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessory`
--

DROP TABLE IF EXISTS `accessory`;
CREATE TABLE IF NOT EXISTS `accessory` (
  `itemnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `itemtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `warranty` int DEFAULT NULL,
  PRIMARY KEY (`itemnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `accessory`
--

INSERT INTO `accessory` (`itemnumber`, `model`, `brand`, `itemtype`, `description`, `price`, `quantity`, `warranty`) VALUES
('A1', 'CORE™ I3-10100', 'INTEL', 'CPU', 'Intel CPUs', 23500, 20, 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customerid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `contactnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `firstname`, `lastname`, `email`, `contactnumber`) VALUES
('C1', 'Mahela', 'Jaya', 'mm@gmai.com', '0775458666'),
('C2', 'Mihindum', 'Liyanage', 'mihindum564@gmail.com', '0776551419'),
('C4', 'Amal', 'Gunasekara', 'abc@gmail.cm', '0712404561'),
('C5', 'wws', 'ss', 'abc@hh.com', '0115468999');

-- --------------------------------------------------------

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
CREATE TABLE IF NOT EXISTS `laptop` (
  `itemnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `processor` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `graphiccard` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ram` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `disktype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `diskdescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `operatingsystem` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `warranty` int DEFAULT NULL,
  PRIMARY KEY (`itemnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `laptop`
--

INSERT INTO `laptop` (`itemnumber`, `model`, `brand`, `processor`, `graphiccard`, `ram`, `disktype`, `diskdescription`, `operatingsystem`, `price`, `quantity`, `warranty`) VALUES
('L1', 'ZENBOOK PRO DUO UX581LV', 'ASUS', 'Intel® Core™ i9-10980HK', 'NVIDIA® GeForce RTX 2060 6GB GDDR6', '32GB DDR4 2666MHZ', 'SDD', '1000GB NVME M.2 SSD', 'Geniune Windows 10 64Bit Pre-installed', 695000, 20, 2),
('L2', 'MATEBOOK 13', 'HUAWEI', 'HUAWEI', 'AMD Ryzen™ 5 3500U Processor 2.1 GHz ', 'AMD VEGA 8 Graphics', '16GB Ram', 'SDD', 'Geniune Windows 10 64Bit Pre-installed', 156000, 31, 2),
('L3', ' INSPIRON 15 5505', 'DELL', 'DELL', 'AMD Ryzen™ 7 4700U 8 Core processor', 'AMD® Radeon™ Graphics', '8GB DDR4 3200MHZ', 'SDD', 'Geniune Windows 10 64Bit Pre-installed', 159500, 24, 3);

-- --------------------------------------------------------

--
-- Table structure for table `printer`
--

DROP TABLE IF EXISTS `printer`;
CREATE TABLE IF NOT EXISTS `printer` (
  `itemnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `color` tinyint(1) DEFAULT NULL,
  `speed` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `warranty` int DEFAULT NULL,
  PRIMARY KEY (`itemnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `salesid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `itemtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `itemid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `customerid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `salesprice` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`salesid`),
  KEY `customerid` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesid`, `itemtype`, `itemid`, `customerid`, `salesprice`, `date`) VALUES
('S1', 'ACCESSORY', 'A1', 'C2', 23500, '2021-01-16'),
('S10', 'LAPTOP', 'L1', 'C1', 695000, '2021-01-17'),
('S11', 'LAPTOP', 'L1', 'C1', 695000, '2021-01-17'),
('S12', 'LAPTOP', 'L1', 'C5', 695000, '2021-01-17'),
('S2', 'LAPTOP', 'L3', 'C2', 159500, '2021-01-16'),
('S3', 'LAPTOP', 'L1', 'C4', 695000, '2021-01-16'),
('S4', 'LAPTOP', 'L1', 'C2', 695000, '2021-01-16'),
('S5', 'LAPTOP', 'L3', 'C4', 159500, '2021-01-17'),
('S6', 'ACCESSORY', 'A1', 'C4', 23500, '2021-01-17'),
('S7', 'LAPTOP', 'L1', 'C1', 695000, '2021-01-17'),
('S8', 'LAPTOP', 'L3', 'C1', 159500, '2021-01-17'),
('S9', 'LAPTOP', 'L1', 'C1', 695000, '2021-01-17');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
CREATE TABLE IF NOT EXISTS `signup` (
  `uid` varchar(20) NOT NULL,
  `eno` varchar(20) NOT NULL,
  `uname` text NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `q1` varchar(100) DEFAULT NULL,
  `a1` varchar(100) DEFAULT NULL,
  `q2` varchar(100) DEFAULT NULL,
  `a2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `staff_id` (`eno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`uid`, `eno`, `uname`, `pwd`, `q1`, `a1`, `q2`, `a2`) VALUES
('002', '006', 'Senal Fernando', 'Abc12345**', 'Who was your first crush?', 'Mia Khalifa', 'Where was your first place of work?', 'NA'),
('001A', '001EA', 'Steve Smith', 'Aussie12345**', 'Who was your first crush?', 'Brett Lee', 'Where was your first place of work?', 'Cricket Board'),
('001', 'akck', 'wmdv', 'Mihindum1234#', NULL, NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
