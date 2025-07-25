-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2024 at 01:16 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctorappointment`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`id`, `email`, `password`) VALUES
(1, 'admin1@example.com', 'adminpass1');

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `apid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `day` date NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`apid`, `name`, `email`, `contact`, `age`, `day`, `specialty`, `description`, `id`) VALUES
(39, 'sunil sharma', 'xrmasunil@gmail.com', '9867970568', 23, '2024-11-14', 'General Physician', 'bad', 1),
(40, 'ramu kc', 'ramu@example.com', '9877665544', 23, '2024-11-15', 'Bariatric', 'bad', 2);

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL,
  `docname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `fees` int(11) DEFAULT NULL,
  `doctor_time` varchar(20) DEFAULT NULL,
  `am_pm` varchar(5) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `docname`, `email`, `password`, `specialty`, `contact`, `fees`, `doctor_time`, `am_pm`, `status`) VALUES
(1, 'Dr. Hari Sharma', 'haridr123@example.com', 'password123', 'General Physician', '+977-9867562314', 1000, '09:00', 'AM', 'booked'),
(2, 'Dr. Shyam Devkota', 'Devshyam.johnson@example.com', 'password456', 'Bariatric\r\n', '+977-9867532144', 1200, '10:00', 'PM', 'booked'),
(3, 'Dr. Divya Karki', 'Divya12@example.com', 'password789', 'Neurology', '+977-9856766634', 1500, '11:00', 'AM', 'available'),
(4, 'Dr. Manit Paudel', 'paudelmanit@example.com', 'password012', 'Cardiology', '+977-9870457789', 1300, '09:30', 'PM', 'available'),
(5, 'Dr. David Kc', 'david.kc@example.com', 'password345', 'Radiology', '+977-9878970489', 1400, '05:00', 'PM', 'available'),
(6, 'Dr. Harilal Parshad', 'hariparashad@example.com', 'password678', 'Dentistry', '+977-9870457789', 1600, '08:30', 'AM', 'available'),
(7, 'Dr. Ankit Rai', 'ankit234@example.com', 'password901', 'Obstetrics', '+977-9845668899', 1800, '01:00', 'PM', 'available'),
(8, 'Dr. Monika Sunar', 'monikasunar34@example.com', 'password234', 'Gastroenterics', '+977-9867453299', 2000, '12:00', 'AM', 'available'),
(9, 'Dr. Naran Sharma', 'naransu123@example.com', 'password567', 'Bariatric', '+977-9867987789', 1700, '08:30', 'AM', 'available'),
(10, 'Dr. Lila Bhandari', 'lilabha122@example.com', 'password890', 'Plastic Surgery', '+977-9856789122', 2200, '03:00', 'PM', 'available'),
(11, 'Dr. Anil Sherstha', 'ShersthaAnil56@example.com', 'password890', 'Rheumatology', '+977-9847632139', 1900, '11:00', 'AM', 'available'),
(12, 'Dr. Neha Gurung', 'neha.gurung12@example.com', 'password912', 'Radiology', '+977-9823456789', 1000, '10:00', 'AM', 'available'),
(13, 'Dr. Sandeep Thapa', 'sandeepthapa13@example.com', 'password913', 'Neurology', '+977-9834567890', 1000, '11:00', 'AM', 'available'),
(14, 'Dr. Aarti Rana', 'aartirana14@example.com', 'password914', 'Cardiology', '+977-9845678901', 1000, '12:00', 'PM', 'available'),
(15, 'Dr. Rohit Joshi', 'rohit.joshi15@example.com', 'password915', 'Dentistry', '+977-9856789012', 1000, '01:00', 'PM', 'available'),
(16, 'Dr. Pooja Adhikari', 'pooja.adhikari16@example.com', 'password916', 'Obstetrics', '+977-9867890123', 1000, '02:00', 'PM', 'available'),
(17, 'Dr. Bishal Bhandari', 'bishal.bhandari17@example.com', 'password917', 'Gastroenterics', '+977-9878901234', 1000, '03:00', 'PM', 'available'),
(18, 'Dr. Shubhi Khadka', 'shubhi.khadka18@example.com', 'password918', 'Bariatric', '+977-9889012345', 1000, '04:00', 'PM', 'available'),
(19, 'Dr. Arjun Lama', 'arjun.lama19@example.com', 'password919', 'Plastic Surgery', '+977-9890123456', 1000, '05:00', 'PM', 'available'),
(20, 'Dr. Meera Koirala', 'meera.koirala20@example.com', 'password920', 'Rheumatology', '+977-9801234567', 1000, '06:00', 'PM', 'available'),
(21, 'Dr. Subash Yadav', 'subash.yadav21@example.com', 'password921', 'Orthopedics', '+977-9812345670', 1000, '07:00', 'PM', 'available'),
(22, 'Dr. Simran Rai', 'simran.rai22@example.com', 'password922', 'Psychiatry', '+977-9823456780', 1000, '08:00', 'PM', 'available'),
(23, 'Dr. Pradeep Koirala', 'pradeep.koirala23@example.com', 'password923', 'Radiology', '+977-9834567890', 1000, '09:00', 'PM', 'available'),
(24, 'Dr. Rekha Tamang', 'rekha.tamang24@example.com', 'password924', 'Neurology', '+977-9845678902', 1000, '10:00', 'PM', 'available'),
(25, 'Dr. Deepak Ghimire', 'deepak.ghimire25@example.com', 'password925', 'General Physician', '+977-9856789013', 1000, '11:00', 'PM', 'available');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `suggestion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`name`, `email`, `contact`, `suggestion`) VALUES
('rabin bhandari', 'rabin@example.com', '9877123221', 'it is easy to take and get appointment from your system but i have one suggestion add some payment system for reducing the need to handle cash or visit the clinic just to make payments');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`id`, `name`, `dob`, `address`, `gender`, `contact`, `email`, `password`) VALUES
(1, 'sunil sharma', '2001-10-16', 'kathmandu', 'Male', '9867970568', 'xrmasunil@gmail.com', '12345'),
(3, 'pardip sharma', '2001-12-31', 'kathmandu,nepal', 'Male', '9867737735', 'pardip@example.com', '12321'),
(7, 'anu sharma', '1995-05-07', 'bagbazar,kathmandu', 'Female', '9879999778', 'anu@example.com', 'anupass12345'),
(11, 'durvha sharma', '2024-09-16', 'kathmandu', 'Male', '9826798679', 'dur@example.com', '12345'),
(12, 'ramu kc', '2013-12-29', 'bhaktapur', 'Male', '9877665544', 'ramu@example.com', '112233');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`apid`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminlogin`
--
ALTER TABLE `adminlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `apid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
