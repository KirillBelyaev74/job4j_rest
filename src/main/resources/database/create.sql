create table person
(
    id       serial primary key not null,
    login    varchar(2000) not null unique,
    password varchar(2000) not null
);

create table employee
(
    id serial primary key,
    name varchar(50) not null,
    surname varchar(50) not null,
    inn bigint,
    created timestamp,
    person_id int references person(id)
);