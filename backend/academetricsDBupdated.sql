-- Database: `jacademetricsDB`

DROP DATABASE IF EXISTS `academetricsDB`;
CREATE DATABASE IF NOT EXISTS `academetricsDB`;

USE `academetricsDB`;

-- --------------------------------------------------------

--
-- Table structure for table `assesment`
--

DROP TABLE IF EXISTS `assesment`;
CREATE TABLE IF NOT EXISTS `assesment` (
  `c_code` varchar(20) NOT NULL,
  `a_id` tinyint NOT NULL AUTO_INCREMENT,
  `a_type` varchar(50) NOT NULL,
  `max_marks` tinyint NOT NULL,
  PRIMARY KEY (`a_id`),
  FOREIGN KEY (`c_code`) REFERENCES `course_offering`(`Course_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------

--
-- Table structure for table `assesment_marks`
--

DROP TABLE IF EXISTS `assesment_marks`;
CREATE TABLE IF NOT EXISTS `assesment_marks` (
  `stu_id` int NOT NULL,
  `a_id` tinyint NOT NULL,
  `marks` tinyint NOT NULL,
  PRIMARY KEY (`stu_id`,`a_id`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`S_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`a_id`) REFERENCES `assesment`(`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `C_id` int NOT NULL,
  `C_name` varchar(255) NOT NULL,
  PRIMARY KEY (`C_id`)
);

-- --------------------------------------------------------

--
-- Table structure for table `course_offering`
--

DROP TABLE IF EXISTS `course_offering`;
CREATE TABLE IF NOT EXISTS `course_offering` (
  `Course_id` int NOT NULL,
  `Coord_id` int NOT NULL,
  `offered_by` int NOT NULL,
  `offered_to` int NOT NULL,
  `Course_code` varchar(20) NOT NULL,
  `year` int NOT NULL,
  `batch` int NOT NULL,
  `semester` tinyint NOT NULL,
  `credits` tinyint NOT NULL,
  PRIMARY KEY (`Course_code`),
  FOREIGN KEY (`Course_id`) REFERENCES `course`(`C_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`Coord_id`) REFERENCES `user`(`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_by`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_to`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `D_id` int UNSIGNED NOT NULL,
  `D_name` varchar(100) NOT NULL,
  PRIMARY KEY (`D_id`)
);

-- --------------------------------------------------------

--
-- Table structure for table `following_courses`
--

DROP TABLE IF EXISTS `following_courses`;
CREATE TABLE IF NOT EXISTS `following_courses` (
  `Stu_id` int NOT NULL,
  `Course_code` varchar(10) NOT NULL,
  `Final_grades` varchar(2) NOT NULL,
  PRIMARY KEY (`Stu_id`,`Course_code`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`S_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`Course_code`) REFERENCES `course_offering`(`Course_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `S_id` int NOT NULL,
  `Batch` int NOT NULL,
  `Semester` tinyint NOT NULL,
  `gpa` double NOT NULL,
  `D_rank` int UNSIGNED NOT NULL,
  PRIMARY KEY (`S_id`),
  FOREIGN KEY (`S_id`) REFERENCES `user`(`Id`) ON DELETE CASCADE ON UPDATE CASCADE
  
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `Id` int UNSIGNED NOT NULL,
  `User_name` varchar(100) NOT NULL DEFAULT 'NOT NULL',
  `Password` varchar(255) NOT NULL,
  `Gmail` varchar(255) NOT NULL,
  `Initials` varchar(20) NOT NULL,
  `Last_name` varchar(100) NOT NULL,
  `sex` tinyint NOT NULL,
  `b_year` YEAR NOT NULL,
  `b_month` tinyint NOT NULL,
  `b_date` tinyint NOT NULL,
  `profile_picture` varchar(255) NULL,
  `addressline1` varchar(50) NULL,
  `addressline2` varchar(50) NULL,
  `addressline3` varchar(50) NULL,
  `Dep_id` int NOT NULL,
  `contact_no` varchar(20) NULL,
  `role` varchar(50),
  PRIMARY KEY (`Id`),
  FOREIGN KEY (`Dep_id`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

