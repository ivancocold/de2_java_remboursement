CREATE DATABASE  IF NOT EXISTS `tpjava` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tpjava`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tpjava
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `remboursement`
--

DROP TABLE IF EXISTS `remboursement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `remboursement` (
  `id_remboursement` varchar(50) NOT NULL,
  `Numero_Securite_Sociale` varchar(15) DEFAULT NULL,
  `Nom` varchar(50) DEFAULT NULL,
  `Prenom` varchar(50) DEFAULT NULL,
  `Date_Naissance` date DEFAULT NULL,
  `Numero_Telephone` varchar(15) DEFAULT NULL,
  `E_Mail` varchar(100) DEFAULT NULL,
  `Code_Soin` varchar(10) DEFAULT NULL,
  `Montant_Remboursement` decimal(10,2) DEFAULT NULL,
  `Timestamp_fichier` datetime DEFAULT NULL,
  PRIMARY KEY (`id_remboursement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remboursement`
--

LOCK TABLES `remboursement` WRITE;
/*!40000 ALTER TABLE `remboursement` DISABLE KEYS */;
INSERT INTO `remboursement` VALUES ('1','123456789012345','John Doe','John','1980-01-01','0123456789','john.doe@example.com','A123',100.50,'9574-02-27 08:50:00'),('10','012345678901234','Martinez','Patricia','1965-10-10','8901234567','patricia.martinez@example.com','J012',205.90,'2024-06-10 01:51:48'),('11','123456789012346','Hernandez','Linda','1984-11-11','9012345678','linda.hernandez@example.com','K123',110.70,'2024-06-10 01:51:48'),('12','234567890123457','Lopez','Christopher','1991-12-12','0123456780','christopher.lopez@example.com','L234',195.25,'2024-06-10 01:51:48'),('13','345678901234568','Gonzalez','Karen','1970-01-13','1234567891','karen.gonzalez@example.com','M345',255.45,'2024-06-10 01:51:48'),('14','456789012345679','Wilson','Paul','1983-02-14','2345678902','paul.wilson@example.com','N456',170.60,'2024-06-10 01:51:48'),('15','567890123456780','Anderson','Nancy','1992-03-15','3456789013','nancy.anderson@example.com','O567',135.75,'2024-06-10 01:51:48'),('16','678901234567891','Thomas','Sandra','1986-04-16','4567890124','sandra.thomas@example.com','P678',215.20,'2024-06-10 01:51:48'),('17','789012345678902','Taylor','Mark','1974-05-17','5678901235','mark.taylor@example.com','Q789',195.80,'2024-06-10 01:51:48'),('18','890123456789013','Moore','Barbara','1969-06-18','6789012346','barbara.moore@example.com','R890',160.50,'2024-06-10 01:51:48'),('19','901234567890124','Jackson','Steven','1987-07-19','7890123457','steven.jackson@example.com','S901',210.90,'2024-06-10 01:51:48'),('1ID658',NULL,' Doe',' John',NULL,NULL,NULL,NULL,NULL,'0458-06-15 07:28:00'),('2','234567890123456','Smith','Jane','1985-02-02','0987654321','jane.smith@example.com','B234',200.75,'2024-06-10 01:51:48'),('20','012345678901235','Martin','Elizabeth','1994-08-20','8901234568','elizabeth.martin@example.com','T012',230.70,'2024-06-10 01:51:48'),('3','345678901234567','Brown','Michael','1990-03-03','1234567890','michael.brown@example.com','C345',150.25,'2024-06-10 01:51:48'),('4','456789012345678','Johnson','Emily','1975-04-04','2345678901','emily.johnson@example.com','D456',300.00,'2024-06-10 01:51:48'),('5','567890123456789','Williams','David','2000-05-05','3456789012','david.williams@example.com','E567',125.75,'2024-06-10 01:51:48'),('6','678901234567890','Jones','Sarah','1995-06-06','4567890123','sarah.jones@example.com','F678',175.50,'2024-06-10 01:51:48'),('7','789012345678901','Garcia','Robert','1982-07-07','5678901234','robert.garcia@example.com','G789',220.40,'2024-06-10 01:51:48'),('8','890123456789012','Miller','Mary','1978-08-08','6789012345','mary.miller@example.com','H890',185.60,'2024-06-10 01:51:48'),('9','901234567890123','Davis','James','1999-09-09','7890123456','james.davis@example.com','I901',240.80,'2024-06-10 01:51:48'),('ID_102330','131368979196124','Nom_Durand','Prenom_Sophie','1977-05-14','715296522','email_6669@example.com','Soin_55',838.95,'2022-06-10 03:44:00'),('ID_207821','504852287482255','Nom_Martin','Prenom_Marie','1968-04-12','520017689','email_2582@example.com','Soin_70',303.48,'2022-06-10 03:44:00'),('ID_224810','660050650886320','Nom_Dupont','Prenom_Jean','1985-09-24','551269492','email_7526@example.com','Soin_27',565.58,'2022-06-10 03:44:00'),('ID_317856','941696735575153','Nom_Martin','Prenom_Claire','1965-04-05','547335450','email_1593@example.com','Soin_73',415.84,'2022-06-10 03:44:00'),('ID_350982','632579077475902','Nom_Durand','Prenom_Jean','1951-07-18','965322684','email_4346@example.com','Soin_68',451.98,'2022-06-10 03:44:00'),('ID_377422','283673272625197','Nom_Dupont','Prenom_Claire','1950-08-03','234304978','email_8649@example.com','Soin_14',329.06,'2022-06-10 03:44:00'),('ID_396176','925982556289025','Nom_Dubois','Prenom_Sophie','1987-12-08','737433279','email_5007@example.com','Soin_58',296.11,'2022-06-10 03:44:00'),('ID_403812','998478153673902','Nom_Durand','Prenom_Jean','1972-11-04','723923728','email_1070@example.com','Soin_64',668.11,'2022-06-10 03:44:00'),('ID_416992','311379390980717','Nom_Dupont','Prenom_Sophie','1998-09-07','741658795','email_8737@example.com','Soin_65',161.75,'2022-06-10 03:44:00'),('ID_445684','763462019901645','Nom_Durand','Prenom_Sophie','1995-09-24','571507425','email_2227@example.com','Soin_94',399.72,'2022-06-10 03:44:00'),('ID_462221','507065101750684','Nom_Dupont','Prenom_Marie','1989-04-17','874538612','email_9504@example.com','Soin_65',245.29,'2022-06-10 03:44:00'),('ID_482688','567692656872579','Nom_Dupont','Prenom_Jean','1979-05-23','398601444','email_3295@example.com','Soin_25',318.79,'2022-06-10 03:44:00'),('ID_542681','139633634031181','Nom_Dubois','Prenom_Jean','1983-02-08','915236480','email_9252@example.com','Soin_87',561.37,'2022-06-10 03:44:00'),('ID_547489','492422453529476','Nom_Dubois','Prenom_Marie','1965-10-23','874358365','email_5065@example.com','Soin_32',993.90,'2022-06-10 03:44:00'),('ID_574797','734638688365535','Nom_Martin','Prenom_Sophie','1964-03-28','955349346','email_3659@example.com','Soin_12',718.80,'2022-06-10 03:44:00'),('ID_647295','974496040281888','Nom_Dupont','Prenom_Sophie','1974-07-09','144213045','email_6077@example.com','Soin_5',974.95,'2022-06-10 03:44:00'),('ID_663185','362954469024053','Nom_Durand','Prenom_Claire','1992-01-08','412130863','email_6991@example.com','Soin_69',811.49,'2022-06-10 03:44:00'),('ID_742768','973957107453202','Nom_Martin','Prenom_Jean','1976-08-14','909220373','email_1454@example.com','Soin_18',351.19,'2022-06-10 03:44:00'),('ID_929295','618633047934621','Nom_Dubois','Prenom_Sophie','1990-11-12','503468228','email_9178@example.com','Soin_95',825.53,'2022-06-10 03:44:00'),('ID_943106','407167452813558','Nom_Martin','Prenom_Jean','1981-01-15','880535591','email_8640@example.com','Soin_61',286.86,'2022-06-10 03:44:00');
/*!40000 ALTER TABLE `remboursement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-10 16:02:53
