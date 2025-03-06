--liquibase formatted sql
--changeset Bogdan Terehin:a0002
create table roles
(
    id      serial primary key,
    name    varchar(255) not null,
    constraint unique_name unique (name)
);