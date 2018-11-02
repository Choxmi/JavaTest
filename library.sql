-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 02, 2018 at 03:41 PM
-- Server version: 5.7.24-0ubuntu0.16.04.1
-- PHP Version: 7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `auth_ID` int(11) NOT NULL,
  `auth_Name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`auth_ID`, `auth_Name`) VALUES
(1, 'Chox'),
(2, 'hbjj'),
(3, 'J.K. Rowling');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bk_ID` int(11) NOT NULL,
  `bk_Name` varchar(200) NOT NULL,
  `bk_Description` varchar(1000) NOT NULL,
  `bk_Author` int(11) DEFAULT NULL,
  `bk_borrowed_user` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bk_ID`, `bk_Name`, `bk_Description`, `bk_Author`, `bk_borrowed_user`) VALUES
(1, 'Chocolate Company', 'Test', 0, 0),
(2, 'Harry Potter', 'First one of Hp Series', 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fine`
--

CREATE TABLE `fine` (
  `fine_id` int(11) NOT NULL,
  `fine_trns_id` int(11) NOT NULL,
  `fine_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `mem_id` int(11) NOT NULL,
  `mem_first_name` varchar(100) NOT NULL,
  `mem_last_name` varchar(100) NOT NULL,
  `mem_address` varchar(500) NOT NULL,
  `mem_telephone` int(11) NOT NULL,
  `mem_type` tinyint(1) NOT NULL DEFAULT '1',
  `mem_book_1` int(11) NOT NULL DEFAULT '0',
  `mem_book_2` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`mem_id`, `mem_first_name`, `mem_last_name`, `mem_address`, `mem_telephone`, `mem_type`, `mem_book_1`, `mem_book_2`) VALUES
(1, 'Choxmi', 'Sathsara', 'H/18,Punchimadawala,Kithulgala', 717753438, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `trns_id` int(11) NOT NULL,
  `trns_bk_id` int(11) NOT NULL,
  `trns_mem_id` int(11) NOT NULL,
  `trns_borrowed_date` date NOT NULL,
  `trns_returned_date` date DEFAULT NULL,
  `trns_status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`trns_id`, `trns_bk_id`, `trns_mem_id`, `trns_borrowed_date`, `trns_returned_date`, `trns_status`) VALUES
(2, 2, 1, '2018-09-10', '2018-11-02', 'Return'),
(3, 2, 1, '2018-05-06', '2018-11-02', 'Return'),
(4, 1, 1, '2018-05-01', NULL, 'Borrow');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`auth_ID`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bk_ID`);

--
-- Indexes for table `fine`
--
ALTER TABLE `fine`
  ADD PRIMARY KEY (`fine_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`mem_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`trns_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `auth_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bk_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `fine`
--
ALTER TABLE `fine`
  MODIFY `fine_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `mem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `trns_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
