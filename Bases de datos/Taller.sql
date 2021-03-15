CREATE DATABASE TALLER;
USE TALLER;
CREATE TABLE CLIENTE(
    cedula VARCHAR (20)  NOT  NULL PRIMARY KEY,
    nombre VARCHAR (30) not NULL,
    celular VARCHAR  (12) NOT NULL,
    placa VARCHAR (6) not NULL,
    tipo_vehiculo VARCHAR (20) not NULL,
    kilometraje VARCHAR (20) not NULL
    );    