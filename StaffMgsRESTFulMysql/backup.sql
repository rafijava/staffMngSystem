-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema staff_mng
--

CREATE DATABASE IF NOT EXISTS staff_mng;
USE staff_mng;

--
-- Definition of table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `active` tinyint(1) default NULL,
  `birth_date` varchar(255) default NULL,
  `joining_date` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`id`,`active`,`birth_date`,`joining_date`,`email`,`image`,`name`) VALUES 
 (1,1,'October 12, 1968','01 Jul 2018','rafi@mail.com','images/rafi-ahmed.jpg','Rafi Ahmed'),
 (2,1,'October 12, 1968','02 Jan 2017','isti@mail.com','images/rafi-ahmed1.jpg','Isteauk Uddin Ahmed'),
 (4,0,'12 Oct 1990','05 Feb 2015','s@gmail.com','images/rafi-ahmed12.jpg','Abdus Samad'),
 (5,0,'04 Dec 1985','05 Feb 2015','h@gmail.com','images/rafi-ahmed10.jpg','Abdullah Al Hasib'),
 (6,1,'09 Nov 1971','05 Feb 2015','p@gmail.com','images/rafi-ahmed2.jpg','Md Kamal Parvez Pasha'),
 (3,0,'23 Jul 1977','05 Feb 2015','galib@gmail.com','images/rafi-ahmed21.jpg','Mohammad Bin Afsar'),
 (7,0,'23 Jan 1990','05 Mar 2015','j@gmail.com','images/3.jpg','Md Jakir Hossain'),
 (8,1,'12 Aug 1978','05 Feb 2015','harun@gmail.com','images/4.jpg','Harun Mia'),
 (9,0,'19 Feb 1990','05 Feb 2015','nezam@gmail.com','images/5.jpg','Mohammad Nezam Uddin'),
 (10,1,'29 Mar 1971','05 Feb 2015','amin@gmail.com','images/1.jpg','Al Amin Sarker'),
 (11,0,'07 Jan 1998','05 Feb 2015','Firoz@gmail.com','images/2.jpg','Md Firoz Mahmud'),
 (12,0,'14 Feb 1995','05 Feb 2015','saroar@gmail.com','images/1.jpg','Md Saroar Hosain');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
