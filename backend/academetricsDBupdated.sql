-- Database: `AacademetricsDB`

DROP DATABASE IF EXISTS `academetricsDB`;
CREATE DATABASE IF NOT EXISTS `academetricsDB`;

USE `academetricsDB`;

-- --------------------------------------------------------
--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `d_id` int UNSIGNED NOT NULL,
  `d_name` varchar(100) NOT NULL,
  PRIMARY KEY (`d_id`)
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int UNSIGNED NOT NULL,
  `user_name` varchar(100) NOT NULL DEFAULT 'NOT NULL',
  `password` varchar(255) NOT NULL,
  `gmail_eng` varchar(255) NOT NULL,
  `gmail_personal` varchar(255) NOT NULL,
  `initials` varchar(20) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `sex` tinyint NOT NULL,
  `profile_picture` varchar(255) NULL,
  `dep_id` int UNSIGNED NOT NULL,
  `contact_no` varchar(20) NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dep_id`) REFERENCES `department`(`d_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `s_id` int UNSIGNED NOT NULL,
  `batch` int NOT NULL,
  `academic_year` tinyint NOT NULL,
  `semester` tinyint NOT NULL,
  `gpa` double NULL,
  `d_rank` int UNSIGNED NOT NULL,
  PRIMARY KEY (`s_id`),
  FOREIGN KEY (`s_id`) REFERENCES `user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
  
);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `c_code` varchar(20) NOT NULL,
  `c_name` varchar(255) NOT NULL,
  `credits` tinyint NOT NULL,
  PRIMARY KEY (`c_code`)
);

-- --------------------------------------------------------
--
-- Table structure for table `course_offering`
--

DROP TABLE IF EXISTS `course_offering`;
CREATE TABLE IF NOT EXISTS `course_offering` (
  `course_code` varchar(20) NOT NULL,
  `coord_id` int UNSIGNED  NOT NULL,
  `offered_by` int UNSIGNED  NOT NULL,
  `offered_to` int UNSIGNED  NOT NULL,
  `year` int NOT NULL,
  `batch` int NOT NULL,
  `semester` tinyint NOT NULL,
  
  PRIMARY KEY (`course_code`,`year`),
  FOREIGN KEY (`course_code`) REFERENCES `course`(`c_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`coord_id`) REFERENCES `user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_by`) REFERENCES `department`(`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_to`) REFERENCES `department`(`d_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -------------------------------------------------------------------------------------------------------
--
-- Table structure for table `following_courses`
--

DROP TABLE IF EXISTS `following_courses`;
CREATE TABLE IF NOT EXISTS `following_courses` (
  `stu_id` int UNSIGNED  NOT NULL,
  `course_code` varchar(10) NOT NULL,
  `year` int NOT NULL,
  `final_grades` varchar(2) NOT NULL,
  PRIMARY KEY (`stu_id`,`course_code`,`year`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`course_code`) REFERENCES `course_offering`(`course_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`year`) REFERENCES `course_offering`(`year`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------------------------------------------------------------------------------------------
--
-- Table structure for table `assesment`
--

DROP TABLE IF EXISTS `assessment`;
CREATE TABLE IF NOT EXISTS `assessment` (
  `course_code` varchar(10) NOT NULL,
  `a_id` tinyint NOT NULL AUTO_INCREMENT,
  `a_type` varchar(50) NOT NULL,
  `max_marks` tinyint NOT NULL,
  PRIMARY KEY (`a_id`),
  FOREIGN KEY (`course_code`) REFERENCES `course`(`c_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------------------------------------------------------
--
-- Table structure for table `assessment_marks`
--

DROP TABLE IF EXISTS `assessment_marks`;
CREATE TABLE IF NOT EXISTS `assessment_marks` (
  `stu_id` int UNSIGNED  NOT NULL,
  `a_id` tinyint NOT NULL,
  `marks` tinyint NOT NULL,
  PRIMARY KEY (`stu_id`,`a_id`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`a_id`) REFERENCES `assesment`(`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
);


-- -------------------------------------------------------------------
INSERT INTO `department` (`d_id`, `d_name`) VALUES
(1, 'Department of Computer Science'),
(2, 'Department of Mathematics'),
(3, 'Department of Physics'),
(4, 'Department of Biology'),
(5, 'Department of Chemistry');



INSERT INTO `user` (`id`, `user_name`, `password`, `gmail_eng`, `gmail_personal`, `initials`, `last_name`, `sex`, `profile_picture`, `dep_id`, `contact_no`, `role`) VALUES
(1, 'johnsmith', 'password123', 'johnsmith@gmail.com', 'johnsmith@gmail.com', 'J. S.', 'Smith', 1, NULL, 1, '1234567890', 'Student'),
(2, 'janedoe', 'pass456', 'janedoe@gmail.com', 'janedoe@gmail.com', 'J. D.', 'Doe', 0, NULL, 1, '9876543210', 'Student'),
(3, 'admin', 'adminpass', 'admin@gmail.com', 'admin@gmail.com', 'A.', 'Admin', 1, NULL, 1, NULL, 'Administrator'),
(4, 'professorx', 'xmen123', 'professorx@gmail.com', 'professorx@gmail.com', 'P. X.', 'Xavier', 1, NULL, 2, '5555555555', 'Professor'),
(5, 'maryjones', 'marypass', 'maryjones@gmail.com', 'maryjones@gmail.com', 'M. J.', 'Jones', 0, NULL, 3, '1111111111', 'Student');


INSERT INTO `student` (`s_id`, `batch`, `academic_year`, `semester`, `gpa`, `d_rank`) VALUES
(1, 2022, 2, 1, 3.7, 1),
(2, 2022, 2, 1, 3.5, 2),
(5, 2023, 1, 2, 3.2, 1);


INSERT INTO `course` (`c_code`, `c_name`, `credits`) VALUES
('CS101', 'Introduction to Computer Science', 3),
('MATH201', 'Calculus II', 4),
('PHYS101', 'Introductory Physics', 4),
('BIO202', 'Genetics', 3),
('CHEM101', 'General Chemistry', 4);


INSERT INTO `course_offering` (`course_code`, `coord_id`, `offered_by`, `offered_to`, `year`, `batch`, `semester`) VALUES
('CS101', 4, 1, 1, 2022, 2022, 1),
('MATH201', 4, 2, 1, 2022, 2022, 1),
('PHYS101', 4, 3, 1, 2022, 2022, 1),
('BIO202', 4, 4, 1, 2022, 2022, 1),
('CHEM101', 4, 5, 1, 2022, 2022, 1);


INSERT INTO `following_courses` (`stu_id`, `course_code`, `year`, `final_grades`) VALUES
(1, 'CS101', 2022, 'A'),
(2, 'MATH201', 2022, 'B+'),
(5, 'CS101', 2022, 'A-');



INSERT INTO `assessment` (`course_code`, `a_id`, `a_type`, `max_marks`) VALUES
('CS101', 1, 'Midterm Exam', 50),
('MATH201', 2, 'Final Exam', 100),
('PHYS101', 3, 'Lab Report', 20),
('BIO202', 4, 'Quiz 1', 10),
('CHEM101', 5, 'Final Project', 50);


INSERT INTO `assessment_marks` (`stu_id`, `a_id`, `marks`) VALUES
(1, 1, 45),
(2, 1, 48),
(1, 2, 80),
(2, 2, 75),
(5, 1, 42);
