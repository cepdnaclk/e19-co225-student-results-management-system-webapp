--
-- Database: `Acdemetrics`
--
-- --------------------------------------------------------
--

CREATE DATABASE IF NOT EXISTS `academetricsDB`;
USE academetricsDB;


-- DROP TABLE IF EXISTS `user`;
-- CREATE TABLE IF NOT EXISTS `user` (
--   `u_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
--   `username` varchar(255) NOT NULL,
--   `password` varchar(255) NOT NULL,
--   `initials` varchar(255) NOT NULL,
--   `last_name` varchar(255) NOT NULL,
--   `email` varchar(255) NOT NULL,
--   `sex` tinyint NOT NULL,
--   `b_year` YEAR NOT NULL,
--   `b_month` int NOT NULL,
--   `b_date` int NOT NULL,
--   `profile_picture` int NULL,
--   `location` varchar(255) NULL,
--   PRIMARY KEY (`u_id`)
-- );

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `u_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`u_id`)
);


--insert test data
INSERT INTO `user` (`u_id`, `user_name`, `password`, `email`) VALUES (NULL, 'kavishka', 'bungas','ka@bungas.com');
