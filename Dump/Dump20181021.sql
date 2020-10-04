-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: practise
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coach`
--

DROP TABLE IF EXISTS `coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coach` (
  `Coach_id` varchar(6) NOT NULL,
  `Coach_Name` varchar(30) NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `Team_id` int(11) NOT NULL,
  `contract_start` year(4) NOT NULL,
  PRIMARY KEY (`Coach_id`),
  KEY `coach_fk_idx` (`Team_id`),
  CONSTRAINT `coach_fk` FOREIGN KEY (`Team_id`) REFERENCES `teams` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach`
--

LOCK TABLES `coach` WRITE;
/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
INSERT INTO `coach` VALUES ('PLC001','Unai Emery','Spain',1,2018),('PLC002','Eddie Howe','England',2,2012),('PLC003','Chris Hughton','Ireland',3,2014),('PLC004','Sean Dyche','England',4,2012),('PLC005','Neil Warnock','England',5,2016),('PLC006','Maurizio Sarri','Italy',6,2018),('PLC007','Roy Hodgson','England',7,2017),('PLC008','Marco Silva','Portugal',8,2018),('PLC009','Slavisa Jokanovic','Serbia',9,2015),('PLC010','David Wagner','United States',10,2015);
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `league` (
  `season` int(11) NOT NULL,
  `pos` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `Pl` int(11) NOT NULL,
  `W` int(11) NOT NULL,
  `D` int(11) NOT NULL,
  `L` int(11) NOT NULL,
  `GF` int(11) NOT NULL,
  `GA` int(11) NOT NULL,
  `Points` int(11) NOT NULL,
  PRIMARY KEY (`season`,`pos`),
  KEY `league_fk_idx` (`team_id`),
  CONSTRAINT `league_fk` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
INSERT INTO `league` VALUES (2015,1,1,14,9,1,4,27,19,28),(2015,2,8,14,7,3,4,24,22,24),(2015,3,7,14,6,3,5,27,22,21),(2015,4,2,14,5,4,5,24,23,19),(2015,5,5,14,6,0,8,24,30,18),(2015,6,4,14,5,2,7,18,23,17),(2015,7,6,14,4,4,6,26,27,16),(2015,8,3,14,4,3,7,24,28,15),(2016,1,2,14,10,1,3,31,20,31),(2016,2,8,14,8,2,4,32,22,26),(2016,3,5,14,8,2,4,21,19,26),(2016,4,1,14,7,1,6,25,19,22),(2016,5,7,14,5,1,8,20,24,16),(2016,6,10,14,5,1,8,16,24,16),(2016,7,9,14,4,1,9,19,25,13),(2016,8,4,14,4,1,9,16,27,13);
/*!40000 ALTER TABLE `league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match_info`
--

DROP TABLE IF EXISTS `match_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `match_info` (
  `match_id` int(11) NOT NULL,
  `home_goals` int(11) NOT NULL,
  `away_goals` int(11) NOT NULL,
  `score` varchar(4) NOT NULL,
  `result` varchar(4) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_info`
--

LOCK TABLES `match_info` WRITE;
/*!40000 ALTER TABLE `match_info` DISABLE KEYS */;
INSERT INTO `match_info` VALUES (1501,2,1,'2-1','HOME','2015-08-01'),(1502,2,0,'2-0','HOME','2015-08-01'),(1503,3,3,'3-3','DRAW','2015-08-01'),(1504,1,0,'1-0','HOME','2015-08-01'),(1505,4,5,'4-5','AWAY','2015-08-04'),(1506,1,1,'1-1','DRAW','2015-08-04'),(1507,4,1,'4-1','HOME','2015-08-04'),(1508,0,0,'0-0','DRAW','2015-08-04'),(1509,1,2,'1-2','AWAY','2015-08-07'),(1510,2,1,'2-1','HOME','2015-08-07'),(1511,3,4,'3-4','AWAY','2015-08-07'),(1512,1,3,'1-3','AWAY','2015-08-07'),(1513,2,1,'2-1','HOME','2015-08-10'),(1514,3,2,'3-2','HOME','2015-08-10'),(1515,1,1,'1-1','DRAW','2015-08-10'),(1516,3,1,'3-1','HOME','2015-08-10'),(1517,3,1,'3-1','HOME','2015-08-13'),(1518,1,0,'1-0','HOME','2015-08-13'),(1519,0,2,'0-2','AWAY','2015-08-13'),(1520,0,0,'0-0','DRAW','2015-08-13'),(1521,1,2,'1-2','AWAY','2015-08-16'),(1522,2,1,'2-1','HOME','2015-08-16'),(1523,3,4,'3-4','AWAY','2015-08-16'),(1524,4,3,'4-3','HOME','2015-08-16'),(1525,4,0,'4-0','HOME','2015-08-19'),(1526,0,2,'0-2','AWAY','2015-08-19'),(1527,0,1,'0-1','AWAY','2015-08-19'),(1528,1,0,'1-0','HOME','2015-08-19'),(1529,1,1,'1-1','DRAW','2015-08-22'),(1530,1,0,'1-0','HOME','2015-08-22'),(1531,3,2,'3-2','HOME','2015-08-22'),(1532,4,1,'4-1','HOME','2015-08-22'),(1533,1,2,'1-2','AWAY','2015-08-25'),(1534,2,1,'2-1','HOME','2015-08-25'),(1535,3,1,'3-1','HOME','2015-08-25'),(1536,0,2,'0,2','AWAY','2015-08-25'),(1537,1,1,'1-1','DRAW','2015-08-28'),(1538,2,1,'2-1','HOME','2015-08-28'),(1539,1,2,'1-2','AWAY','2015-08-28'),(1540,3,2,'3-2','HOME','2015-08-28'),(1541,1,2,'1-2','AWAY','2015-08-31'),(1542,2,1,'2-1','HOME','2015-08-31'),(1543,3,3,'3-3','DRAW','2015-08-31'),(1544,4,1,'4-1','HOME','2015-08-31'),(1545,0,0,'0-0','DRAW','2015-09-02'),(1546,4,2,'4-2','HOME','2015-09-02'),(1547,2,4,'2-4','AWAY','2015-09-02'),(1548,1,2,'1-2','AWAY','2015-09-02'),(1549,3,1,'3-1','HOME','2015-09-05'),(1550,2,1,'2-1','HOME','2015-09-05'),(1551,3,1,'3-1','HOME','2015-09-05'),(1552,2,0,'2-0','HOME','2015-09-05'),(1553,4,2,'4-2','HOME','2015-09-08'),(1554,2,5,'2-5','AWAY','2015-09-08'),(1555,3,1,'3-1','HOME','2015-09-08'),(1556,0,0,'0-0','DRAW','2015-09-08'),(1601,1,0,'1-0','HOME','2016-08-01'),(1602,2,3,'2-3','AWAY','2016-08-01'),(1603,3,1,'3-1','HOME','2016-08-01'),(1604,1,3,'1-3','AWAY','2016-08-01'),(1605,1,1,'1-1','DRAW','2016-08-04'),(1606,2,1,'2-1','HOME','2016-08-04'),(1607,3,1,'3-1','HOME','2016-08-04'),(1608,2,4,'2-4','AWAY','2016-08-04'),(1609,4,2,'4-2','HOME','2016-08-07'),(1610,3,1,'3-1','HOME','2016-08-07'),(1611,2,0,'2-0','HOME','2016-08-07'),(1612,1,2,'1-2','HOME','2016-08-07'),(1613,0,1,'0-1','AWAY','2016-08-10'),(1614,3,2,'3-2','HOME','2016-08-10'),(1615,1,0,'1-0','HOME','2016-08-10'),(1616,1,3,'1-3','AWAY','2016-08-10'),(1617,1,2,'1-2','AWAY','2016-08-13'),(1618,2,0,'2-0','HOME','2016-08-13'),(1619,3,1,'3-1','HOME','2016-08-13'),(1620,1,4,'1-4','AWAY','2016-08-13'),(1621,2,1,'2-1','HOME','2016-08-16'),(1622,0,0,'0-0','DRAW','2016-08-16'),(1623,3,2,'3-2','HOME','2016-08-16'),(1624,1,3,'1-3','AWAY','2016-08-16'),(1625,3,0,'3-0','HOME','2016-08-19'),(1626,1,3,'1-3','AWAY','2016-08-19'),(1627,0,1,'0-1','AWAY','2016-08-19'),(1628,1,0,'1-0','HOME','2016-08-19'),(1629,3,1,'3-1','HOME','2016-08-22'),(1630,2,1,'2-1','HOME','2016-08-22'),(1631,0,3,'0-3','AWAY','2016-08-22'),(1632,1,2,'1-2','AWAY','2016-08-22'),(1633,3,1,'3-1','HOME','2016-08-25'),(1634,1,1,'1-1','DRAW','2016-08-25'),(1635,2,1,'2-1','HOME','2016-08-25'),(1636,3,0,'3-0','HOME','2016-08-25'),(1637,1,0,'1-0','HOME','2016-08-28'),(1638,0,0,'0-0','DRAW','2016-08-28'),(1639,2,3,'2-3','AWAY','2016-08-28'),(1640,3,1,'3-1','AWAY','2016-08-28'),(1641,3,0,'3-0','HOME','2016-08-31'),(1642,1,2,'1-2','AWAY','2016-08-31'),(1643,2,0,'2-0','HOME','2016-08-31'),(1644,2,3,'2-3','AWAY','2016-08-31'),(1645,1,2,'1-2','AWAY','2016-09-03'),(1646,3,2,'3-2','HOME','2016-09-03'),(1647,1,0,'1-0','HOME','2016-09-03'),(1648,2,3,'2-3','AWAY','2016-09-03'),(1649,3,4,'3-4','AWAY','2016-09-06'),(1650,1,0,'1-0','HOME','2016-09-06'),(1651,2,3,'2-3','AWAY','2016-09-06'),(1652,1,2,'1-2','AWAY','2016-09-06'),(1653,2,1,'2-1','HOME','2016-09-09'),(1654,2,2,'2-2','DRAW','2016-09-09'),(1655,1,0,'1-0','HOME','2016-09-09'),(1656,3,1,'3-1','HOME','2016-09-09');
/*!40000 ALTER TABLE `match_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `players` (
  `Team` varchar(3) NOT NULL DEFAULT 'FAG',
  `Kit_no` int(11) NOT NULL,
  `Player_name` varchar(20) NOT NULL,
  `Position` varchar(3) NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `team_id` int(11) NOT NULL,
  `year_start` year(4) NOT NULL,
  PRIMARY KEY (`Team`,`Kit_no`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `players_fk` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES ('ARS',1,'Petr Cech','GK','Czech Republic','1982-05-20',1,2015),('ARS',2,'Hector Bellerin','DEF','Spain','1995-03-19',1,2012),('ARS',4,'Mohamed Elneny','MID','Egypt','1992-07-11',1,2015),('ARS',5,'Sokratis','DEF','Greece','1988-06-09',1,2018),('ARS',6,'Laurent Koscielny','DEF','France','1985-09-10',1,2010),('ARS',7,'Henrikh Mkhitariyan','MID','Armenia','1989-01-21',1,2017),('ARS',8,'Aaron Ramsey','MID','Wales','1990-12-26',1,2008),('ARS',9,'Alexander Lacazette','ATT','France','1991-05-28',1,2017),('ARS',10,'Mesut Ozil','MID','Germany','1988-10-15',1,2013),('ARS',11,'Lucas Torreira','MID','Uruguay','1996-02-11',1,2018),('ARS',14,'Pierre Aubameyang','ATT','Gabon','1989-06-18',1,2017),('ARS',19,'Bernd Leno','GK','Germany','1992-03-04',1,2018),('ARS',20,'Shkodran Mustafi','DEF','Germany','1992-04-17',1,2016),('ARS',23,'Danny Welbeck','ATT','England','1990-11-26',1,2014),('ARS',31,'Sead Kolasinac','DEF','Bosnia','1993-06-20',1,2017),('BOU',1,'Artur Boruc','GK','Poland','1980-02-20',2,2015),('BOU',2,'Simon Francis','DEF','England','1985-02-16',2,2015),('BOU',3,'Steve Cook','DEF','England','1991-04-19',2,2015),('BOU',4,'Dan Gosling','MID','England','1987-04-16',2,2015),('BOU',5,'Nathan Ake','DEF','Netherlands','1995-02-18',2,2016),('BOU',6,'Andrew Surman','MID','England','1991-08-23',2,2015),('BOU',7,'Marc Pugh','MID','England','1990-09-03',2,2015),('BOU',8,'Jefferson Lerma','MID','Colombia','1988-01-13',2,2018),('BOU',9,'Lys Mousset','ATT','France','1990-02-22',2,2016),('BOU',10,'Jordan Ibe','MID','England','1993-02-16',2,2016),('BOU',11,'Charlie Daniels','DEF','England','1991-07-28',2,2015),('BOU',12,'Aaron Ramsdale','GK','England','1998-05-14',2,2016),('BOU',13,'Callum Wilson ','ATT','England','1992-07-01',2,2015),('BOU',15,'Adam Smith','DEF','England','1989-02-08',2,2015),('BOU',17,'Joshua King','ATT','Norway','1992-02-11',2,2015),('BRI',1,'Mat Ryan','GK','Australia','1988-09-11',3,2017),('BRI',2,'Bruno','DEF','Spain','1980-10-01',3,2017),('BRI',3,'Gaeton Bong','DEF','Cameroon','1988-04-25',3,2017),('BRI',4,'Shane Duffy','DEF','Ireland','1992-01-01',3,2017),('BRI',5,'Lewis Dunk','DEF','England','1990-11-03',3,2015),('BRI',6,'Dale Stephens','MID','England','1988-06-20',3,2015),('BRI',7,'Beram Kayal','MID','Israel','1988-05-02',3,2017),('BRI',8,'Yves Bissouma','MID','Mali','1987-08-01',3,2014),('BRI',9,'Jurgen Locadia','ATT','Netherlands','1990-02-12',3,2018),('BRI',10,'Florin Andone','ATT','Romania','1991-10-01',3,2015),('BRI',11,'Anthony Knockaert','MID','France','1991-12-08',3,2016),('BRI',13,'Pascal Gross','MID','Germany','1988-01-25',3,2014),('BRI',14,'Leon Balogun','DEF','Nigeria','1991-03-22',3,2016),('BRI',16,'Alireza Jahanbakhsh','ATT','Iran','1991-09-07',3,2018),('BRI',23,'Jason Steele','GK','England','1990-08-18',3,2018),('BUR',1,'Tom Heaton','GK','England','1986-04-15',4,2014),('BUR',2,'Matthew Lawton','DEF','England','1989-06-09',4,2016),('BUR',3,'Charlie Taylor','DEF','England','1993-09-18',4,2017),('BUR',4,'Jack Cork','MID','England','1988-08-11',4,2015),('BUR',5,'James Tarkowski','DEF','England','1992-11-19',4,2016),('BUR',6,'Ben Mee','DEF','England','1990-07-22',4,2015),('BUR',7,'Johann Gudmundsson','MID','Iceland','1987-03-18',4,2014),('BUR',9,'Sam Vokes','ATT','Wales','1990-12-10',4,2014),('BUR',10,'Ashley Barnes','ATT','Austria','1991-02-03',4,2018),('BUR',11,'Chris Wood','ATT','New Zealand','1988-07-13',4,2017),('BUR',12,'Robbie Brady','MID','Ireland','1990-04-08',4,2017),('BUR',13,'Jeff Hendrick','MID','Ireland','1989-07-29',4,2018),('BUR',16,'Steven Defour','MID','Belgium','1988-06-11',4,2016),('BUR',20,'Joe Hart','GK','England','1987-04-19',4,2018),('BUR',23,'Stephen Ward','DEF','Ireland','1992-07-01',4,2018),('CAR',1,'Neil Etheridge','GK','Philippines','1989-05-10',5,2012),('CAR',2,'Lee Peltier','DEF','England','1990-12-30',5,2015),('CAR',3,'Joe Bennettt','DEF','England','1990-02-11',5,2016),('CAR',4,'Sean Morrison','DEF','England','1987-11-27',5,2014),('CAR',5,'Bruno Manga','DEF','Gabon','1989-07-21',5,2017),('CAR',6,'Jazz Richards','DEF','Wales','1990-08-01',5,2015),('CAR',7,'Harry Arter','MID','Ireland','1991-04-28',5,2016),('CAR',8,'Joe Ralls','MID','England','1988-05-29',5,2014),('CAR',9,'Dany Ward','ATT','England','1989-01-10',5,2013),('CAR',10,'Kenneth Zahore','ATT','Denmark','1990-05-20',5,2013),('CAR',11,'Josh Murphy','MID','England','1990-03-09',5,2014),('CAR',12,'Alex Smithies','GK','England','1993-07-02',5,2018),('CAR',14,'Bobby Reid','MID','England','1991-10-30',5,2016),('CAR',17,'Aron Gunnarsson','MID','Iceland','1988-07-31',5,2014),('CAR',19,'Nathaniel Laing','ATT','England','1991-07-03',5,2018),('CHE',1,'Kepa Arrizabalaga','GK','Spain','1994-10-03',6,2018),('CHE',2,'Antonio Rudiger','DEF','Germany','1993-03-03',6,2017),('CHE',3,'Marcos Alonso','DEF','Spain','1990-12-28',6,2016),('CHE',4,'Cesc Fabregas','MID','Spain','1987-05-14',6,2014),('CHE',5,'Jorginho','MID','Italy','1991-12-20',6,2018),('CHE',6,'Daniel Drinkwater','MID','England','1991-07-19',6,2017),('CHE',7,'N\'golo Kante','MID','France','1991-03-29',6,2016),('CHE',10,'Eden Hazard','ATT','Belgium','1991-01-07',6,2012),('CHE',11,'Pedro','ATT','Spain','1988-04-17',6,2014),('CHE',13,'Willy Caballero','GK','Argentina','1981-09-28',6,2017),('CHE',15,'Victor Moses','DEF','Nigeria','1989-05-11',6,2017),('CHE',17,'Mateo Kovacic','MID','Croatia','1992-08-10',6,2018),('CHE',24,'Gary Cahill','DEF','England','1985-12-19',6,2011),('CHE',29,'Alvaro Morata','ATT','Spain','1992-07-20',6,2017),('CHE',30,'David Luiz','DEF','Brazil','1987-04-22',6,2010),('CRY',1,'Julian Speroni','GK','Argentina','1979-05-19',7,2013),('CRY',2,'Joel Ward','DEF','England','1985-11-20',7,2012),('CRY',3,'Patrick Aanholt','DEF','Netherlands','1988-07-25',7,2015),('CRY',4,'Luka Milivojevic','MID','Serbia','1988-08-05',7,2015),('CRY',5,'James Tomkins','DEF','England','1989-03-29',7,2016),('CRY',6,'Scott Dan','DEF','England','1987-02-14',7,2013),('CRY',7,'Max Meyer','MID','Germany','1990-10-15',7,2016),('CRY',8,'Cheikhou Kouyate','MID','Senegal','1990-01-11',7,2018),('CRY',9,'Alexander Sorloth','ATT','Norway','1987-04-14',7,2016),('CRY',10,'Andros Townsend','MID','England','1988-12-30',7,2014),('CRY',11,'Wilfred Zaha','ATT','Cote D\'Ivoire','1992-11-10',7,2014),('CRY',12,'Mamadou Sakho','DEF','France','1990-02-13',7,2017),('CRY',13,'Wayne Hennessey','GK','Wales','1987-01-24',7,2013),('CRY',14,'Jordan Ayew','ATT','Ghana','1989-05-18',7,2016),('CRY',18,'James McArthur','MID','Scotland','1992-06-24',7,2018),('EVE',1,'Jordan Pickford','GK','England','1994-03-07',8,2017),('EVE',2,'Mason Holgate','DEF','England','1985-07-31',8,2015),('EVE',3,'Leighton Baines','DEF','England','1982-11-02',8,2012),('EVE',6,'Phil jagielka','DEF','England','1987-06-23',8,2015),('EVE',8,'Andre Gomes','MID','Portugal','1993-07-30',8,2018),('EVE',10,'Gylfi Sigurdsson','MID','Iceland','1989-09-08',8,2017),('EVE',11,'Theo Walcott','ATT','England','1990-03-16',8,2018),('EVE',12,'Lucas Digne','DEF','France','1988-04-05',8,2018),('EVE',13,'Yerry Mina','DEF','Colombia','1991-08-15',8,2018),('EVE',14,'Cenk Tosun','ATT','Turkey','1991-06-07',8,2017),('EVE',16,'James McCarthy','MID','England','1988-11-13',8,2015),('EVE',17,'Idrissa Gueye','MID','Senegal','1989-09-26',8,2016),('EVE',20,'Bernard','MID','Brazil','1992-09-08',8,2018),('EVE',30,'Richarlison','ATT','Brazil','1997-05-10',8,2018),('EVE',33,'Joao Virginia','GK','Portugal','1987-06-01',8,2015),('FUL',1,'Marcus Bettinelli','GK','England','1992-05-24',9,2012),('FUL',3,'Ryan Sessegnon','MID','England','1987-07-18',9,2016),('FUL',4,'Denis Odoi','DEF','Belgium','1990-07-21',9,2018),('FUL',5,'Calum Chambers','DEF','England','1989-06-23',9,2018),('FUL',6,'Kevin McDonald','MID','Scotland','1986-08-22',9,2017),('FUL',9,'Aleksander Mitrovic','ATT','Serbia','1994-09-16',9,2018),('FUL',10,'Tom Cairney','MID','Scotland','1988-04-12',9,2017),('FUL',11,'Floyd Ayite','ATT','Togo','1994-01-30',9,2018),('FUL',13,'Tim Ream','DEF','United States','1987-05-03',9,2017),('FUL',14,'Andre Schurrle','MID','Germany','1990-07-30',9,2018),('FUL',19,'Luciano Vietto','ATT','Argentina','1993-12-05',9,2018),('FUL',22,'Cyrus Christie','DEF','Ireland','1990-02-09',9,2015),('FUL',24,'Jean Seri','MID','Cote D\'Ivore','1992-03-29',9,2018),('FUL',25,'Sergio Rico','GK','Spain','1993-09-01',9,2018),('FUL',43,'Steve Sessegnon','DEF','England','1988-01-17',9,2016),('HUD',1,'Jonas Lossl','GK','Denmark','1989-02-01',10,2017),('HUD',2,'Tommy Smith','DEF','England','1990-03-14',10,2014),('HUD',5,'Terence Kongolo','DEF','Netherlands','1991-07-11',10,2016),('HUD',6,'Jonathon Hogg','MID','England','1990-08-11',10,2016),('HUD',7,'Juninho Bacuna','MID','Netherlands','1991-12-09',10,2016),('HUD',9,'Elias Kachunga','MID','Congo','1992-04-22',10,2017),('HUD',10,'Aaron Mooy','MID','Australia','1984-11-11',10,2013),('HUD',11,'Adama Diakhaby','ATT','France','1989-07-22',10,2018),('HUD',12,'Ben hamer','GK','England','1987-10-16',10,2016),('HUD',14,'Ramadan Sobhi','MID','Egypt','1992-03-20',10,2017),('HUD',15,'Chris Lowe','DEF','Germany','1990-01-28',10,2016),('HUD',19,'Danny Williams','MID','England','1992-05-08',10,2018),('HUD',23,'Collin Quaner','ATT','Germany','1991-06-18',10,2017),('HUD',25,'Zanka','DEF','Denmark','1986-08-12',10,2016),('HUD',37,'Eric Durm','DEF','Germany','1992-07-11',10,2018);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plays`
--

DROP TABLE IF EXISTS `plays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plays` (
  `match_id` int(11) NOT NULL,
  `Home_Team` int(11) NOT NULL,
  `Away_Team` int(11) NOT NULL,
  PRIMARY KEY (`match_id`),
  KEY `plays_fk1_idx` (`Home_Team`),
  KEY `plays_fk2_idx` (`Away_Team`),
  CONSTRAINT `plays_fk1` FOREIGN KEY (`Home_Team`) REFERENCES `teams` (`team_id`),
  CONSTRAINT `plays_fk2` FOREIGN KEY (`Away_Team`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plays`
--

LOCK TABLES `plays` WRITE;
/*!40000 ALTER TABLE `plays` DISABLE KEYS */;
INSERT INTO `plays` VALUES (1501,7,3),(1502,5,8),(1503,6,2),(1504,4,1),(1505,8,7),(1506,2,3),(1507,1,5),(1508,4,6),(1509,7,2),(1510,8,1),(1511,3,4),(1512,5,6),(1513,1,7),(1514,4,2),(1515,6,8),(1516,5,3),(1517,7,4),(1518,1,6),(1519,2,5),(1520,8,3),(1521,6,7),(1522,5,4),(1523,3,1),(1524,8,2),(1525,7,5),(1526,6,3),(1527,4,8),(1528,1,2),(1529,3,7),(1530,8,5),(1531,2,6),(1532,1,4),(1533,7,8),(1534,3,2),(1535,5,1),(1536,6,4),(1537,2,7),(1538,1,8),(1539,4,3),(1540,6,5),(1541,7,1),(1542,2,4),(1543,8,6),(1544,3,5),(1545,4,7),(1546,6,1),(1547,5,2),(1548,3,8),(1549,7,6),(1550,4,5),(1551,1,3),(1552,2,8),(1553,5,7),(1554,3,6),(1555,8,4),(1556,2,1),(1601,1,8),(1602,4,5),(1603,2,7),(1604,10,9),(1605,5,1),(1606,7,8),(1607,9,4),(1608,10,2),(1609,1,7),(1610,5,9),(1611,8,10),(1612,4,2),(1613,9,1),(1614,10,7),(1615,2,5),(1616,4,8),(1617,1,10),(1618,9,2),(1619,7,4),(1620,5,8),(1621,2,1),(1622,4,10),(1623,8,9),(1624,5,7),(1625,1,4),(1626,2,8),(1627,10,5),(1628,9,7),(1629,8,1),(1630,5,4),(1631,7,2),(1632,9,10),(1633,1,5),(1634,8,7),(1635,4,9),(1636,2,10),(1637,7,1),(1638,9,5),(1639,10,8),(1640,2,4),(1641,1,9),(1642,7,10),(1643,5,2),(1644,8,4),(1645,10,1),(1646,2,9),(1647,4,7),(1648,8,5),(1649,1,2),(1650,10,4),(1651,9,8),(1652,7,5),(1653,4,1),(1654,8,2),(1655,5,10),(1656,7,9);
/*!40000 ALTER TABLE `plays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadium`
--

DROP TABLE IF EXISTS `stadium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stadium` (
  `Stadium_id` varchar(5) NOT NULL,
  `Stadium_Name` varchar(30) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Team_id` int(11) NOT NULL,
  PRIMARY KEY (`Stadium_id`),
  KEY `Team_id` (`Team_id`),
  CONSTRAINT `stadium_fk` FOREIGN KEY (`Team_id`) REFERENCES `teams` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadium`
--

LOCK TABLES `stadium` WRITE;
/*!40000 ALTER TABLE `stadium` DISABLE KEYS */;
INSERT INTO `stadium` VALUES ('PL001','Emirates Stadium',73000,1),('PL002','Dean Court',11500,2),('PL003','Falmer Stadium',30750,3),('PL004','Turf Moor',21500,4),('PL005','Cardiff City Stadium',33280,5),('PL006','Stamford Bridge',41000,6),('PL007','Selhurst Park',26000,7),('PL008','Goodison Park',39500,8),('PL009','Craven Cottage',49300,9),('PL010','Kirklees Stadium',24000,10);
/*!40000 ALTER TABLE `stadium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teams` (
  `Team_id` int(11) NOT NULL AUTO_INCREMENT,
  `Team_Name` varchar(25) NOT NULL,
  `City` varchar(25) NOT NULL,
  `Owner` varchar(80) NOT NULL,
  PRIMARY KEY (`Team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Arsenal','London','Stan Kroenke'),(2,'Bournemouth','Bournemouth','Maxim Demin'),(3,'Brighton & Hove Albion','Brighton','Tony Bloom'),(4,'Burnley','Burnley','Mike Garlick'),(5,'Cardiff City','Cardiff','Vincent Tan'),(6,'Chelsea','London','Roman Abramovich'),(7,'Crystal Palace','London','Steve Parish'),(8,'Everton','Liverpool','Farhad Moshiri'),(9,'Fulham','London','Shad Khan'),(10,'Huddersfield Town','Huddersfield','Dean Hoyle');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `Name` varchar(15) NOT NULL,
  `Email_Id` varchar(40) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Ad','ad@gmail.com','ad','ad'),('Admin','admin@gmail.com','admin','admin'),('Navjot','navjotdonbosco3@gmail.com','navjot','navjot');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-21 21:10:22
