--liquibase formatted sql
--changeset Sergey Lvov:a0020

alter table users
    alter column flag_guide_shown set default false;
