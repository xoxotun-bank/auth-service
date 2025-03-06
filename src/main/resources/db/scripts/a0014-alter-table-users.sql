--liquibase formatted sql
--changeset Bogdan Terehin:a0014

alter table users
    add column city_id integer default null;
alter table users
    add foreign key (city_id) references cities (id);
alter table users
    add column flag_guide_shown boolean not null default true