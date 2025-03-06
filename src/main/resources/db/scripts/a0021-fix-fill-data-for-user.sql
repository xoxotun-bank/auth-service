--liquibase formatted sql
--changeset Sergey Lvov:a0020

update users
set flag_guide_shown = false
where login = 'adavydov123';