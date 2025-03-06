--liquibase formatted sql
--changeset Bogdan Terehin:a0005
create table user_roles
(
    id      serial primary key,
    user_id integer not null,
    role_id integer not null,
    foreign key (user_id) references users(id)
            on delete cascade,
    foreign key (role_id) references roles(id)
            on delete cascade
);