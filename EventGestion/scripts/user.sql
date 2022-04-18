USE eventgestiondb;

CREATE USER 'hugo'@'localhost' IDENTIFIED WITH mysql_native_password BY 'java';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON eventgestiondb.* TO 'hugo'@'localhost';