insert into clientes(nombre, apellido, edad, fecha_nacimiento) values ('jose','lopez',24,'1995-10-19');
insert into clientes(nombre, apellido, edad, fecha_nacimiento) values ('diana','villaran',28,'1991-08-19');
insert into clientes(nombre, apellido, edad, fecha_nacimiento) values ('walter','dominguez',30,'1989-12-19');
insert into clientes(nombre, apellido, edad, fecha_nacimiento) values ('yessenia','gonzales',40,'1979-01-19');
insert into clientes(nombre, apellido, edad, fecha_nacimiento) values ('david','quiroga',20, '1999-07-19');


INSERT INTO db_reto.usuarios (username, password, enabled, nombre, apellido, email) VALUES ('javier','$2a$10$HcNI5Z9vN0IwZsgOmeBGN.Yjs592Y2D1XU4V6DZ17IolDF58kphh6',1, 'Javier', 'Pizarro','tjpizarroip91@gmail.com');
INSERT INTO db_reto.usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$lh8SZeNlt1eC.kPxRPmo1O8MRLMJam.lf/s937tQ/Vs5d7IjBYEYC',1, 'Jose', 'Ipanaque','tjpizarroip91@hotmail.es');

INSERT INTO db_reto.roles (nombre) VALUES ('ROLE_USER');
INSERT INTO db_reto.roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO db_reto.usuario_to_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO db_reto.usuario_to_role (usuario_id, role_id) VALUES (2, 2);
INSERT INTO db_reto.usuario_to_role (usuario_id, role_id) VALUES (2, 1);

