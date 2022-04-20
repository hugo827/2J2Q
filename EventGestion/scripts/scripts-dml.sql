USE evengestiondb;

TRUNCATE TABLE eventgestiondb.promotion;
TRUNCATE TABLE eventgestiondb.event;
TRUNCATE TABLE eventgestiondb.address;
TRUNCATE TABLE eventgestiondb.user;
TRUNCATE TABLE eventgestiondb.usertype;
TRUNCATE TABLE eventgestiondb.eventtype;
TRUNCATE TABLE eventgestiondb.locality;


INSERT INTO eventgestiondb.eventtype(name) VALUES ("festival");
INSERT INTO eventgestiondb.eventtype(name) VALUES ("birthday");
INSERT INTO eventgestiondb.eventtype(name) VALUES ("concert");
INSERT INTO eventgestiondb.eventtype(name) VALUES ("convention");
INSERT INTO eventgestiondb.eventtype(name) VALUES ("others");

INSERT INTO eventgestiondb.usertype(name) VALUES ("volunteer");
INSERT INTO eventgestiondb.usertype(name) VALUES ("standard");
INSERT INTO eventgestiondb.usertype(name) VALUES ("premium");
INSERT INTO eventgestiondb.usertype(name) VALUES ("guest");

INSERT INTO eventgestiondb.locality(zipCode, name) VALUES (5000, "Namur");
INSERT INTO eventgestiondb.locality(zipCode, name) VALUES (5002, "Saint-Servais");
INSERT INTO eventgestiondb.locality(zipCode, name) VALUES (1000, "Bruxelles");
INSERT INTO eventgestiondb.locality(zipCode, name) VALUES (4000, "Liege");
INSERT INTO eventgestiondb.locality(zipCode, name) VALUES (1348, "Louvain-la-neuve");

INSERT INTO eventgestiondb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Namur", "50, rue de namur", "additional information", 1);
INSERT INTO eventgestiondb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Saint-Servais", "52, rue de saint-servais", "additional information", 2);
INSERT INTO eventgestiondb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Bruxlles", "10, rue de bruxelles", "additional information", 3);
INSERT INTO eventgestiondb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Liege", "40, rue de liege", "additional information", 4);
INSERT INTO eventgestiondb.address(libelle, numberStreet, additionalInformation, fk_locality) VALUES("Louvain la neuve", "13, rue de lln", "additional information", 5);

INSERT INTO eventgestiondb.user(firstname, lastname, fk_userType) VALUES ("Wangi", "Weber", 4);
INSERT INTO eventgestiondb.user(firstname, lastname, fk_userType) VALUES ("Hugo", "Janssens", 4);
INSERT INTO eventgestiondb.user(firstname, lastname, fk_userType) VALUES ("Alexandre", "Lambert", 3);
INSERT INTO eventgestiondb.user(firstname, lastname, fk_userType) VALUES ("Lucas", "Pignataro", 2);
INSERT INTO eventgestiondb.user(firstname, lastname, fk_userType) VALUES ("Remy", "Lecrond", 1);

INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();
INSERT INTO eventgestiondb.event(title, description, additonalInformation, isImportant, startDate, endDate,
                                 price, particpantNbMax, isPrivate, fk_creator, fk_participe, fk_eventType, fk_address)
VALUES();



INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();
INSERT INTO eventgestiondb.promotion(reductionPourcent, fk_userType, fk_event) VALUES();

