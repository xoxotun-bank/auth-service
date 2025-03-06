--liquibase formatted sql
--changeset Bogdan Terehin:a0008
alter table refresh_tokens alter column expiration_date type timestamp with time zone;
alter table refresh_tokens alter column expiration_date set not null;