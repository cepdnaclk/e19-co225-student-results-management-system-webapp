-- Database: `jacademetricsDB`

DROP DATABASE IF EXISTS `academetricsDB`;
CREATE DATABASE IF NOT EXISTS `academetricsDB`;

USE `academetricsDB`;

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
  `Dep_id` int UNSIGNED NOT NULL,
  `contact_no` varchar(20) NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  FOREIGN KEY (`Dep_id`) REFERENCES `department`(`D_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `c_id` varchar(20) NOT NULL,
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
INSERT INTO department (D_id, D_name)
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
INSERT INTO user (Id, User_name, Password, Gmail, Initials, Last_name, sex, b_year, b_month, b_date, profile_picture, addressline1, addressline2, addressline3, Dep_id, contact_no,role)
VALUES
    (1, 'kavishkagaya', 'password', 'kavishkagaya@example.com', 'K.G.', 'Dissanayake', 1, 2000, 5, 10, null, '123 Main St', 'Colombo', 'Sri Lanka', 1, '1234567890','student'),
    (2, 'gabrielinesha', 'password', 'ineshag@example.com', 'I.G.', 'De Silva', 1, 1999, 8, 15, null, '456 Elm St', 'Kandy', 'Sri Lanka', 2, '9876543210','student'),
    (3, 'silvaboss', 'password', 'boss_silva@example.com', 'S.B', 'Rambukwella', 1, 1999, 3, 20, null, '789 Oak St', 'Galle', 'Sri Lanka', 3, '5678901234','student'),
    (4, 'thiranjaya', 'password', 'thiranjaya@example.com', 'T.', 'Rajapaksa', 1, 1999, 11, 5, null, '321 Pine St', 'Jaffna', 'Sri Lanka', 4, '4321098765','student'),
    (5, 'denuwankalindu', 'password', 'denuwankalindu@example.com', 'D.K.', 'Senevirathna', 1, 2000, 2, 1, null, '654 Maple St', 'Matara', 'Sri Lanka', 5, '9012345678','student'),
    (6, 'manodya', 'password', 'gomezmanodya@example.com', 'M.', 'Gomez', 1, 2000, 9, 25, null, '987 Pine St', 'Negombo', 'Sri Lanka', 1, '7890123456','student'),
    (7, 'dinukanemo', 'password', 'dinukanemo@example.com', 'D.N.', 'Wickramasinghe', 1, 2000, 4, 12, null, '654 Oak St', 'Colombo', 'Sri Lanka', 2, '5678901234','student'),
    (8, 'sanka', 'password', 'peterson_sanka@example.com', 'S.M', 'Peterson', 1, 1999, 11, 8, null, '321 Elm St', 'Kandy', 'Sri Lanka', 3, '9012345678','student');

-- Insert data into the student table
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
    (1, 2, 3, 5, 'GP106', 2021, 19, 1, 3),
    (3, 3, 3, 1, 'CO225', 2023, 19, 4, 3),
    (4, 4, 8, 1, 'EM212', 2023, 19, 4, 2),
    (3, 5, 3, 3, 'CO225', 2021, 18, 4, 3);

-- Insert data into the assesment table
INSERT INTO assesment (c_id, a_type, max_marks)
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

