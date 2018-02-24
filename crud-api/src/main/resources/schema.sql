create table Risco (
	id integer auto_increment primary key,
	risco char(1) not null
);

create table Cliente (
	id integer auto_increment primary key,
	idRisco integer not null,
	nome varchar(200) not null,
	limitecredito numeric(8,2) not null,
	taxaJuros numeric(5,2) not null
);