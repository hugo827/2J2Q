CREATE SCHEMA IF NOT EXISTS `eventmanagmentdb` DEFAULT CHARACTER SET utf8 ;
USE eventmanagmentdb;

DROP TABLE IF EXISTS `promotion`;
DROP TABLE IF EXISTS `participation`;
DROP TABLE IF EXISTS `event`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `eventtype`;
DROP TABLE IF EXISTS `usertype`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `locality`;

CREATE TABLE `usertype` (
    `idusertype` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) UNIQUE,
     PRIMARY KEY (`idusertype`)
);

CREATE TABLE `eventtype` (
    `idEventType` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) UNIQUE,
    PRIMARY KEY (`idEventType`)
);

CREATE TABLE `locality` (
    `idlocality` int NOT NULL AUTO_INCREMENT,
    `zipCode` int UNIQUE,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`idlocality`)
);


CREATE TABLE `address` (
    `idaddress` int NOT NULL AUTO_INCREMENT,
    `libelle` text DEFAULT NULL,
    `numberStreet` varchar(150) NOT NULL,
    `additionalInformation` text DEFAULT NULL,
    `fk_locality` int NOT NULL,
    PRIMARY KEY (`idaddress`),
    CONSTRAINT `fk_locality` FOREIGN KEY (`fk_locality`) REFERENCES `locality` (`idlocality`)
);


CREATE TABLE `user` (
    `iduser` int NOT NULL AUTO_INCREMENT,
    `firstName` varchar(45) NOT NULL,
    `lastName` varchar(45) NOT NULL,
    `birthDate` TIMESTAMP NOT NULL,
    `isPMR` tinyint DEFAULT 0,
    `profession` text DEFAULT NULL,
    `nbChildren` int DEFAULT NULL,
    `fk_userType` int NOT NULL,
    PRIMARY KEY (`iduser`),
    CONSTRAINT `fk_userType` FOREIGN KEY (`fk_userType`) REFERENCES `usertype` (`idusertype`)
);

CREATE TABLE `event` (
    `idEvent` int NOT NULL AUTO_INCREMENT,
    `title` varchar(45) NOT NULL,
    `description` text NOT NULL,
    `additionalInformation` text DEFAULT NULL,
    `isImportant` tinyint DEFAULT 0,
    `startDate` TIMESTAMP NOT NULL,
    `endDate` TIMESTAMP NOT NULL,
    `price` float NOT NULL CHECK ( price >= 0 ),
    `participantNbMax` int NOT NULL CHECK ( participantNbMax > 0 ),
    `isPrivate` tinyint DEFAULT 0,
    `fk_creator` int NOT NULL,
    `fk_eventType` int NOT NULL,
    `fk_address` int NOT NULL,
    PRIMARY KEY (`idEvent`),
    CONSTRAINT `fk_address` FOREIGN KEY (`fk_address`) REFERENCES `address` (`idaddress`),
    CONSTRAINT `fk_creator` FOREIGN KEY (`fk_creator`) REFERENCES `user` (`iduser`),
    CONSTRAINT `fk_eventType` FOREIGN KEY (`fk_eventType`) REFERENCES `eventtype` (`idEventType`)
);

CREATE TABLE `participation` (
    `idparticipation` int NOT NULL AUTO_INCREMENT,
    `fk_user` int NOT NULL,
     `fk_event` int NOT NULL,
     PRIMARY KEY (`idparticipation`),
     CONSTRAINT `fk_user` FOREIGN KEY (`fk_user`) REFERENCES `user` (`iduser`),
     CONSTRAINT `fk_event` FOREIGN KEY (`fk_event`) REFERENCES `event` (`idEvent`)
);

CREATE TABLE `promotion` (
    `idpromotion` int NOT NULL AUTO_INCREMENT,
    `reductionPourcent` double NOT NULL CHECK ( reductionPourcent BETWEEN 0 AND 1.0 ),
    `fk_userType` int NOT NULL,
     `fk_event` int NOT NULL,
     PRIMARY KEY (`idpromotion`),
     CONSTRAINT `event_fk` FOREIGN KEY (`fk_event`) REFERENCES `event` (`idEvent`),
     CONSTRAINT `usertype_fk` FOREIGN KEY (`fk_userType`) REFERENCES `usertype` (`idusertype`)
);