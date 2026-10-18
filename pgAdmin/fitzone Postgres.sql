create table socios (
    id_socio int primary key,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    edad int not null,
    fecha_registro varchar(10) not null,
    activo boolean not null
);

insert into socios (id_socio, nombres, apellidos, edad, fecha_registro, activo)
values
(1, 'Juan', 'Perez', 25, '2026-01-15', true),
(2, 'Maria', 'Lopez', 17, '2026-02-10', true),
(3, 'Karolina', 'Torres', 32, '2026-03-05', false),
(4, 'Juana', 'Chaluiza', 14, '2026-06-20', true),
(5, 'Jose', 'Llumiquinga', 45, '2026-09-12', true);

select * from socios;

-- Agregar la columna email
alter table socios add column email varchar(100);

-- Mostrar únicamente nombres, apellidos y edad de los socios que esten activos 
-- y sean mayores a 18
select nombres, apellidos, edad from socios
where activo = true and edad > 18;

-- Socios registrados despues de una fecha
select * from socios
where fecha_registro > '2026-02-01';

-- Ordenar socios por edad descendente
select * from socios order by edad desc;

-- Actualizar el correo de un socio
update socios set email = 'Jose@gmail.com'
where id_socio = 2;

-- Mostrar socios menores de edad
select * from socios
where edad < 18;

-- Contar cuantos socios estan activos
select count(*) as total_activos
from socios
where activo = true;

