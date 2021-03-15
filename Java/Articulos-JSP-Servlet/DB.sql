CREATE TABLE ARTICULOS(
	id int not null PRIMARY KEY AUTO_INCREMENT,
    codigo varchar (30) not null,
    nombre varchar (30) not null,
    descripcion varchar (30) not null,
    existencia DOUBLE not null,
    precio DOUBLE not null
);