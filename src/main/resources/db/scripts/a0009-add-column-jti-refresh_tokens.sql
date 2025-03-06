--liquibase formatted sql
--changeset Bogdan Terehin:a0009
alter table refresh_tokens add column access_token_jti uuid not null