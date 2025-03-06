--liquibase formatted sql
--changeset Sergey Lvov:a0017

alter table users
    add column name varchar(255) default '' not null;

update users
set name = 'Терехин Богдан Денисович'
where id = 1;

alter table users
    alter column name drop default;
