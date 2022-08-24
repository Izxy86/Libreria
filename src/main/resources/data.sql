insert into GENERO (id, nombre) values (1,'terror');
insert into GENERO (id, nombre) values (2,'fantasia');
insert into GENERO (id, nombre) values (3,'novela');
insert into AUTOR (id, nombre,dni) values (1,'autor1','123');
insert into AUTOR (id, nombre,dni) values (2,'autor2','456');
insert into AUTOR (id, nombre,dni) values (3,'autor3','789');
insert into LIBRO (nombre, isbn,stock,autor_id,genero_id) values ('libro1','isbn1',10,1,1);
insert into LIBRO (nombre, isbn,stock,autor_id,genero_id) values ('libro2','isbn2',20,3,2);