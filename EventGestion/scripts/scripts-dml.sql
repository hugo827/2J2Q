USE eventmanagmentdb;

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

INSERT INTO eventmanagmentdb.user(firstname, lastname, fk_userType) VALUES ("Wangi", "Weber", 4);
INSERT INTO eventmanagmentdb.user(firstname, lastname, fk_userType) VALUES ("Hugo", "Janssens", 4);
INSERT INTO eventmanagmentdb.user(firstname, lastname, fk_userType) VALUES ("Alexandre", "Lambert", 3);
INSERT INTO eventmanagmentdb.user(firstname, lastname, fk_userType) VALUES ("Lucas", "Pignataro", 2);
INSERT INTO eventmanagmentdb.user(firstname, lastname, fk_userType) VALUES ("Remy", "Lecrond", 1);

INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                 price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Namur festival", "Festival hard rock", "Liste concerts : - ...", false, '2022-04-19', '2022-04-21', 7.5, 1000, false, 1, 1, 1);
INSERT INTO eventmanagmentdb.event(title, description, additionalInformation, isImportant, startDate, endDate,
                                 price, participantNbMax, isPrivate, fk_creator, fk_eventType, fk_address)
VALUES("Arch enemy en concert", "Concert de Arch enemy a Louvain la neuve ", "", false, '2022-05-19', '2022-05-19', 7.5, 1000, false, 1, 3, 5);

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



INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.50, 1,1);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,3,1);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(1.00,4,1);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.10, 3,2);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.80,4,2);
INSERT INTO eventmanagmentdb.promotion(reductionPourcent, fk_userType, fk_event) VALUES(0.25,1,2);

