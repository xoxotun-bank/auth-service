--liquibase formatted sql
--changeset Bogdan Terehin:a0003
create table passwords
(
    id      serial primary key,
    user_id integer not null,
    hash    varchar(255) not null,
    salt    varchar(255) not null,
    active  boolean default true not null,

    constraint cn_active unique (user_id, active),
    foreign key (user_id) references users(id)
            on delete cascade

);