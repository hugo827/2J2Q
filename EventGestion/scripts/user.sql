USE eventgestiondb;

CREATE USER 'WWHJ'@'localhost' IDENTIFIED WITH mysql_native_password BY 'wWhJ5000+';

GRANT SELECT, INSERT, UPDATE, DELETE ON eventgestiondb.* TO 'WWHJ'@'localhost';