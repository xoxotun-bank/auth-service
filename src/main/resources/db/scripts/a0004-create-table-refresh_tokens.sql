--liquibase formatted sql
--changeset Bogdan Terehin:a0004
create table refresh_tokens (
    id      serial primary key,
    user_id integer not null,
    token   text not null,
    expiration_date timestamp not null,

    foreign key (user_id) references users(id)
            on delete cascade
)