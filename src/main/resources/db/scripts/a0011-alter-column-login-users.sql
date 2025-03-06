--liquibase formatted sql
--changeset Bogdan Terehin:a0011
alter table users add constraint unique_login unique (login);