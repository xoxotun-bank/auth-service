--liquibase formatted sql
--changeset Bogdan Terehin:a0007
alter table refresh_tokens add column issued_at timestamp with time zone not null default (now() at time zone 'utc')