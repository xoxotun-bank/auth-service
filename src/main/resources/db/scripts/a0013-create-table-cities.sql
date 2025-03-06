--liquibase formatted sql
--changeset Bogdan Terehin:a0013

create table cities(
    id serial primary key,
    city varchar(255) not null,
    region varchar(255)
)