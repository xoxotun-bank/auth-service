--liquibase formatted sql
--changeset Bogdan Terehin:a0010
alter table refresh_tokens add column refresh_token_jti uuid not null