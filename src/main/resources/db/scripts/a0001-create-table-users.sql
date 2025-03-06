--liquibase formatted sql
--changeset Bogdan Terehin:a0001
create table users
(
    id            serial primary key,
    login         varchar(255) not null
);