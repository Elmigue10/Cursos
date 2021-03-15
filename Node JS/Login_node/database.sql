CREATE DATABASE nodelogin;
use nodelogin;

CREATE TABLE accounts (
    id int (11) not NULL ,
    username VARCHAR (50) not null,
    PASSWORD VARCHAR (255) not null,
    email VARCHAR (100) not NULL 
);

INSERT INTO accounts (`id`, `username`, `password`, `email`) VALUES (1, 'test', 'test', 'test@test.com');
INSERT INTO accounts (`id`, `username`, `password`, `email`) VALUES (2, 'elmigue', 'contraseña', 'test@test.com');

ALTER TABLE accounts ADD PRIMARY KEY (id);
ALTER TABLE accounts MODIFY id int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;