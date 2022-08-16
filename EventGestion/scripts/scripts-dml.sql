USE eventmanagmentdb;

-- DELETE FROM `promotion` ;
-- DELETE FROM `participation`;
-- DELETE FROM `event`;
-- DELETE FROM `user`;
-- DELETE FROM `eventtype` ;
-- DELETE FROM `usertype`;
-- DELETE FROM `address` ;
-- DELETE FROM `locality` ;

INSERT INTO eventmanagmentdb.eventtype(name) VALUES ("festival");
INSERT INTO eventmanagmentdb.eventtype(name) VALUES ("birthday");
INSERT INTO eventmanagmentdb.eventtype(name) VALUES ("concert");
INSERT INTO eventmanagmentdb.eventtype(name) VALUES ("convention");
INSERT INTO eventmanagmentdb.eventtype(name) VALUES ("others");

INSERT INTO eventmanagmentdb.usertype(name) VALUES ("volunteer");
INSERT INTO eventmanagmentdb.usertype(name) VALUES ("standard");
INSERT INTO eventmanagmentdb.usertype(name) VALUES ("premium");
INSERT INTO eventmanagmentdb.usertype(name) VALUES ("guest");

INSERT INTO eventmanagmentdb.locality(zipCode, name) VALUES (5000, "Namur");
INSERT INTO eventmanagmentdb.locality(zipCode, name) VALUES (5002, "Saint-Servais");
INSERT INTO eventmanagmentdb.locality(zipCode, name) VALUES (1000, "Bruxelles");
INSERT INTO eventmanagmentdb.locality(zipCode, name) VALUES (4000, "Liege");
INSERT INTO eventmanagmentdb.locality(zipCode, name) VALUES (1348, "Louvain-la-neuve");

INSERT INTO eventmanagmentdb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Namur", "50, rue de namur", "additional information", 1);
INSERT INTO eventmanagmentdb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Saint-Servais", "52, rue de saint-servais", "additional information", 2);
INSERT INTO eventmanagmentdb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Bruxlles", "10, rue de bruxelles", "additional information", 3);
INSERT INTO eventmanagmentdb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Liege", "40, rue de liege", "additional information", 4);
INSERT INTO eventmanagmentdb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Louvain la neuve", "13, rue de lln", "additional information", 5);

INSERT INTO eventmanagmentdb.user(firstname, lastname,birthDate, isPMR, profession, nbChildren, fk_userType) VALUES ("Wangi", "Weber",'1998-09-21', false,"pédiatre",null,4);
INSERT INTO eventmanagmentdb.user(firstname, lastname,birthDate, isPMR, profession, nbChildren, fk_userType) VALUES ("Hugo", "Janssens",'1988-04-02', true,"maçon",null,4);
INSERT INTO eventmanagmentdb.user(firstname, lastname,birthDate, isPMR, profession, nbChildren, fk_userType) VALUES ("Alexandre", "Lambert",'2000-06-14',false,null,2, 3);
INSERT INTO eventmanagmentdb.user(firstname, lastname,birthDate, isPMR, profession, nbChildren, fk_userType) VALUES ("Lucas", "Pignataro",'1984-01-30', true,"professeur",null,2);
INSERT INTO eventmanagmentdb.user(firstname, lastname,birthDate, isPMR, profession, nbChildren, fk_userType) VALUES ("Remy", "Lecrond",'2001-06-16', false,null,5,1);

INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Namur festival", "Festival hard rock", "Liste concerts : - ...", false, '2022-04-19 09:30:00', '2022-04-21', 7.5, 1000, false, 1, 1, 1);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Arch enemy en concert", "Concert de Arch enemy a Louvain la neuve ", null, false, '2022-05-19', '2022-05-19', 7.5, 1000, false, 1, 3, 5);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Billy talent en concert", "Concert de billy talent a namur le 25 juin", null, false, '2022-06-25', '2022-06-25', 45, 5000, false, 3, 3, 1);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Festival des artisans", "Ensemble d'artisants qui presente leur metier", null, true, '2022-09-10', '2022-09-15', 12.50, 5000, false, 2, 4, 3);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Festival de la biere", "Ensemble d'independant presentant leur biere", null, false, '2022-05-30', '2022-05-30', 15, 5000, false, 3, 1, 3);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Convention cosplay", "Cosplay", null, false, '2022-05-20', '2022-05-22', 12.50, 5000, false, 1, 1, 4);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                   price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Examen d'outils statisique", "IESN - 2IG - Examen d'outils statistique", null, true, '2022-06-4', '2022-06-4', 0, 100, false, 2, 5, 1);

-- event 1
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,1);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,1);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (3,1);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,1);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,1);

-- event 2
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,2);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,2);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (3,2);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,2);

-- event 3
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,3);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,3);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (3,3);


-- event 4
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,4);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,4);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (3,4);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,4);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,4);

-- event 5
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,5);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,5);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,5);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,5);

-- event 6
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,6);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,6);

-- event 7
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (1,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (4,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (5,7);
INSERT INTO eventmanagmentdb.participation(fk_user, fk_event) VALUES (2,7);


-- reduction event 1
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.50, 1,1);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,3,1);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(1.00,4,1);

-- reduction event 2
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 3,2);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,4,2);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,1,2);


-- reduction event 3
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 3,3);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,4,3);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,1,3);


-- reduction event 4
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 1,4);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,2,4);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,3,4);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,4,4);

-- reduction event 5
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 3,5);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,4,5);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,1,5);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,2,5);


-- reduction event 6
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 1,6);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,2,6);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,3,6);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,4,6);


-- reduction event 7
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10,1,7);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,2,7);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,3,7);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,4,7);


