-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2019 at 07:29 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `geocodecschool`
--

-- --------------------------------------------------------

--
-- Table structure for table `schoolinfo`
--

CREATE TABLE `schoolinfo` (
  `schoolName` varchar(100) NOT NULL,
  `schoolAddress` varchar(100) NOT NULL,
  `classAvailable` varchar(100) NOT NULL,
  `schoolType` varchar(100) NOT NULL,
  `educationalZone` varchar(100) NOT NULL,
  `educationalDistrict` varchar(100) NOT NULL,
  `administrativeDistrict` varchar(100) NOT NULL,
  `municipal` varchar(100) NOT NULL,
  `lga` varchar(100) NOT NULL,
  `policeArea` varchar(100) NOT NULL,
  `postalCode` varchar(100) NOT NULL,
  `dateEstablished` date NOT NULL,
  `schoolID` varchar(100) NOT NULL,
  `censusNo` varchar(100) NOT NULL,
  `schoolExamID` varchar(100) NOT NULL,
  `principalName` varchar(100) NOT NULL,
  `principalNo` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL,
  `totalLandArea` varchar(100) NOT NULL,
  `totalStudent` varchar(100) NOT NULL,
  `totalStaff` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schoolinfo`
--

INSERT INTO `schoolinfo` (`schoolName`, `schoolAddress`, `classAvailable`, `schoolType`, `educationalZone`, `educationalDistrict`, `administrativeDistrict`, `municipal`, `lga`, `policeArea`, `postalCode`, `dateEstablished`, `schoolID`, `censusNo`, `schoolExamID`, `principalName`, `principalNo`, `province`, `totalLandArea`, `totalStudent`, `totalStaff`, `location`, `state`, `email`) VALUES
('GeoCodec International School', '308B Murtala Muhammed Way Yaba Lagos', '50', 'High School', 'Yaba LCDA', 'Mainland', 'Yaba', 'Lagos', 'Yaba LCDA', 'Sabo Police Division', '5010', '1991-10-05', '046', 'CENCUS/2006/LA/4060', 'WAEC/2101', 'Aremu Aderibigbe', '08080808080', 'South-West', '6 Acre', '1650', '48', 'Lagos', 'Lagos', 'geocode.technologies@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `classes` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `hired` date NOT NULL,
  `department` varchar(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  `degree` varchar(100) NOT NULL,
  `salary` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`id`, `name`, `classes`, `gender`, `dob`, `hired`, `department`, `position`, `degree`, `salary`, `contact`, `email`, `address`, `state`) VALUES
(1, 'Bodunde Segun', 'SS1/SS3', 'Male', '1981-09-11', '2010-09-04', 'Science', 'Teacher', 'B.Sc', 'N95,000.00', '08014532472', 'bodunde@segun', 'Lekki, Lagos', 'Kogi'),
(2, 'Segun Aboriade', 'SS1/SS3', 'Male', '1986-09-01', '2012-09-04', 'Commercial', 'Teacher', 'HND', 'N75,000.00', '08025732472', 'segun@aborisade', 'Iyana Ipaja, Lagos', 'Ekiti'),
(3, 'Inakoju Esther', 'JS1/JS2/JS3', 'Female', '1990-04-14', '2015-09-04', 'Commercial', 'Teacher', 'B.Sc', 'N70,000.00', '08011723568', 'inakoju@esther', 'Ikorodu, Lagos', 'Ondo'),
(4, 'Odunlade Adekola', 'JS1/JS2/SS2', 'Male', '1980-08-17', '2008-09-04', 'Art', 'Teacher', 'HND', 'N90,000.00', '08042578953', 'odunlade@esther', 'Ikorodu, Lagos', 'Ekiti'),
(5, 'Ranti Eyinola', 'JS1/JS2/SS3', 'Female', '1984-02-17', '2011-09-04', 'Art', 'Teacher', 'HND', 'N80,000.00', '08011425361', 'ranti@eyinola', 'Yaba, Lagos', 'Oyo'),
(6, 'Mathew Solomon', 'JS1/JS2/SS1', 'Male', '1988-08-02', '2009-09-04', 'Science', 'Teacher', 'B.Sc', 'N75,000.00', '08024153647', 'mathew@solomon', 'Sango, Ogun', 'Ogun');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `classes` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `admitted` date NOT NULL,
  `department` varchar(100) NOT NULL,
  `disability` varchar(100) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `year` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `bursary` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `classes` varchar(100) NOT NULL,
  `term` varchar(100) NOT NULL,
  `first_payment` date NOT NULL,
  `second_payment` date NOT NULL,
  `third_payment` varchar(100) NOT NULL,
  `actual_fee` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `mode_of_payment` varchar(100) NOT NULL,
  `arrears` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffs`
--

INSERT INTO `bursary` (`id`, `name`, `term`, `first_payment`, `second_payment`, `third_payment`, `actual_fee`, `status`, `mode_of_payment`, `arrears`) VALUES
(1, 'Aisha Olapade', 'SS3', 'First', 'N65,000.00', 'N35,000.00', 'NILL', 'N100,000.00', 'Full Payment', 'Cash', 'NILL', );

-- --------------------------------------------------------


--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` int(10) NOT NULL,
  `subjects` varchar(100) NOT NULL,
  `noOfStudents` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `subjects`, `noOfStudents`) VALUES
(1, 'ENGLISH', ''),
(2, 'MATHEMATICS', ''),
(3, 'CIVIC EDUCATION', ''),
(4, 'ECONOMICS', ''),
(5, 'LITERATURE IN ENG', ''),
(6, 'GOVERNMENT', ''),
(7, 'PHYSICS', ''),
(8, 'CHEMISTRY', ''),
(9, 'AGRIC SCIENCE', ''),
(10, 'BIOLOGY', ''),
(11, 'F/MATHS', ''),
(12, 'I.R.S', ''),
(13, 'C.R.S', ''),
(14, 'MUSIC', ''),
(15, 'HISTORY', ''),
(16, 'COMMERCE', ''),
(17, 'ACCOUNT', ''),
(18, 'YORUBA', ''),
(19, 'HAUSA', ''),
(20, 'IGBO', 'FRENCH'),
(21, 'MARKETING', ''),
(22, 'HEALTH EDUCATION', ''),
(23, 'PHYSICAL EDUCATION', ''),
(24, 'GEOGRAPHY', ''),
(25, 'BASIC SCIENCE', ''),
(26, 'SOCIAL STUDIES', ''),
(27, 'FINE ART', ''),
(28, 'BUSINESS STUDIES', 'FRENCH'),
(29, 'COMPUTER', ''),
(30, 'HOME ECONOMICS', ''),
(31, 'BASIC TECH', ''),
(32, 'INTRO TECH', '');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `class` (
  `id` int(10) NOT NULL,
  `subjects` varchar(100) NOT NULL,
  `noOfStudents` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `class` (`id`, `classes`, `noOfStudents`) VALUES
(1, 'JS1', ''),
(2, 'JS2', ''),
(3, 'JS3', ''),
(4, 'SS1', ''),
(5, 'SS2', ''),
(6, 'SS3', '');


-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('semiteprofessor', 'tayelolu'),
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `bursary`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `staffs`
--
ALTER TABLE `staffs`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `class`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `bursary`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
