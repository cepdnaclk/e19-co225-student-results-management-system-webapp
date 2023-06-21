-- Database: `AacademetricsDB`

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
  PRIMARY KEY (`Course_code`,`year`),
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
  `d_id` int UNSIGNED NOT NULL,
  `d_name` varchar(100) NOT NULL,
  PRIMARY KEY (`d_id`)
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
  `Academic_year` tinyint NOT NULL,
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
  `id` int UNSIGNED NOT NULL,
  `user_name` varchar(100) NOT NULL DEFAULT 'NOT NULL',
  `password` varchar(255) NOT NULL,
  `gmail_eng` varchar(255) NOT NULL,
  `gmail_personal` varchar(255) NOT NULL,
  `initials` varchar(20) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `sex` tinyint NOT NULL,
  `profile_picture` varchar(255) NULL,
  `addressline1` varchar(50) NULL,
  `addressline2` varchar(50) NULL,
  `addressline3` varchar(50) NULL,
  `Dep_id` int UNSIGNED NOT NULL,
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
  `S_id` int UNSIGNED NOT NULL,
  `Batch` int NOT NULL,
  `Academic_year` tinyint NOT NULL,
  `Semester` tinyint NOT NULL,
  `gpa` double NOT NULL,
  `D_rank` int UNSIGNED NOT NULL,
  PRIMARY KEY (`S_id`),
  FOREIGN KEY (`S_id`) REFERENCES `user`(`Id`) ON DELETE CASCADE ON UPDATE CASCADE
  
);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `C_id` int UNSIGNED NOT NULL,
  `C_name` varchar(255) NOT NULL,
  PRIMARY KEY (`C_id`)
);

-- --------------------------------------------------------


--
-- Table structure for table `course_offering`
--

DROP TABLE IF EXISTS `course_offering`;
CREATE TABLE IF NOT EXISTS `course_offering` (
  `Course_id` int UNSIGNED NOT NULL,
  `Coord_id` int UNSIGNED  NOT NULL,
  `offered_by` int UNSIGNED  NOT NULL,
  `offered_to` int UNSIGNED  NOT NULL,
  `Course_code` varchar(20) NOT NULL,
  `year` int NOT NULL,
  `batch` int NOT NULL,
  `semester` tinyint NOT NULL,
  `credits` tinyint NOT NULL,
  PRIMARY KEY (`Course_code`,`year`),
  FOREIGN KEY (`Course_id`) REFERENCES `course`(`C_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`Coord_id`) REFERENCES `user`(`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_by`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`offered_to`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -------------------------------------------------------------------------------------------------------
--
-- Table structure for table `following_courses`
--

DROP TABLE IF EXISTS `following_courses`;
CREATE TABLE IF NOT EXISTS `following_courses` (
  `Stu_id` int UNSIGNED  NOT NULL,
  `Course_code` varchar(10) NOT NULL,
  `Final_grades` varchar(2) NOT NULL,
  PRIMARY KEY (`Stu_id`,`Course_code`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`S_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`Course_code`) REFERENCES `course_offering`(`Course_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- -----------------------------------------------------------------------------------------------------------
--
-- Table structure for table `assesment`
--

DROP TABLE IF EXISTS `assesment`;
CREATE TABLE IF NOT EXISTS `assesment` (
  `c_id` int UNSIGNED NOT NULL,
  `a_id` tinyint NOT NULL AUTO_INCREMENT,
  `a_type` varchar(50) NOT NULL,
  `max_marks` tinyint NOT NULL,
  PRIMARY KEY (`a_id`),
  FOREIGN KEY (`c_id`) REFERENCES `course_offering`(`Course_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------------------------------------------------------
--
-- Table structure for table `assesment_marks`
--

DROP TABLE IF EXISTS `assesment_marks`;
CREATE TABLE IF NOT EXISTS `assesment_marks` (
  `stu_id` int UNSIGNED  NOT NULL,
  `a_id` tinyint NOT NULL,
  `marks` tinyint NOT NULL,
  PRIMARY KEY (`stu_id`,`a_id`),
  FOREIGN KEY (`stu_id`) REFERENCES `student`(`S_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`a_id`) REFERENCES `assesment`(`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

-- --------------------------------------------------------
-- Inserting Sample Data Recodrs
-- Insert data into the department table

/* INSERT INTO department (d_id, d_name)
VALUES
    (1, 'Civil Engineering'),
    (2, 'Chemical and Processing Engineering'),
    (3, 'Computer Engineering'),
    (4, 'Electrical and Electronic Engineering'),
    (5, 'Manufacturing and Industrial Engineering'),
    (6, 'Mechanical Engineering'),
    (7, 'Engineering Management'),
    (8, 'Engineering Mathematics');

-- Insert data into the user table
INSERT INTO user (Id, User_name, Password, Gmail, Initials, Last_name, sex, profile_picture, Dep_id, contact_no,role)
VALUES
    (1, 'kavishkagaya', 'password', 'kavishkagaya@example.com', 'K.G.', 'Dissanayake', 1, null, 1, '1234567890','student'),
    (2, 'gabrielinesha', 'password', 'ineshag@example.com', 'I.G.', 'De Silva', 1, null, 2, '9876543210','student'),
    (3, 'silvaboss', 'password', 'boss_silva@example.com', 'S.B', 'Rambukwella', 1, null,  3, '5678901234','student'),
    (4, 'thiranjaya', 'password', 'thiranjaya@example.com', 'T.', 'Rajapaksa', null, 4, '4321098765','student'),
    (5, 'denuwankalindu', 'password', 'denuwankalindu@example.com', 'D.K.', 'Senevirathna', null, 5, '9012345678','student'),

--Insert data into the student table
INSERT INTO student (S_id, Batch, Academic_year,Semester, gpa, D_rank)
VALUES
    (1, 19,2, 4, 3.5, 1),
    (2, 17,4, 8, 3.2, 2),
    (3, 18,3, 6, 3.7, 3),
    (4, 20,1, 2, 3.0, 4),
    (5, 19,2, 4, 3.9, 5);

INSERT INTO course (C_id,C_name)
VALUES
      (1,'Python'),
      (2,'C'),
      (3,'Java'),
      (4,'Maths');

-- Insert data into the course_offering table
INSERT INTO course_offering (Course_id, Coord_id, offered_by, offered_to, Course_code, year, batch, semester, credits)
VALUES
    (1, 1, 3, 4, 'GP106', 2023, 20, 2, 3),
    (2, 2, 3, 5, 'GP106', 2021, 19, 1, 3),
    (3, 3, 3, 1, 'CO225', 2023, 19, 4, 3),
    (4, 4, 8, 1, 'EM212', 2023, 19, 4, 2),
    (5, 5, 3, 3, 'CO225', 2021, 18, 4, 3);

-- Insert data into the assesment table
INSERT INTO assesment (c_code, a_type, max_marks)
VALUES
    (1, 'Mid Exam', 20),
    (1, 'Project', 10),
    (1, 'Project', 30),
    (3, 'Lab-1', 5),
    (3, 'Lab-2', 5),
    (3, 'Lab-3', 5),
    (3, 'Lab-4', 5),
    (3, 'Quiz-1', 5),
    (3, 'Quiz-2', 5),
    (4, 'Mid Exam', 20),
    (4, 'Lab Assignment -1', 5);

