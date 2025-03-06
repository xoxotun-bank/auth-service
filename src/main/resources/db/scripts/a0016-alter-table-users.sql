--liquibase formatted sql
--changeset Sergey Lvov:a0016

update users
set city_id = 1
where city_id is null;

alter table users
    alter column city_id set not null;

