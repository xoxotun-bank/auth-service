--liquibase formatted sql
--changeset Sergey Lvov:a0012

INSERT INTO roles (id,name)
VALUES (1,'operator');

INSERT INTO users (id,login)
VALUES (1,'bterehin123');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO passwords (user_id, hash, salt, active)
VALUES (1, '$2a$12$z/2YCeAeZe84d5hL6BSh8O9YGpeDEw8NIQVZnm3dxiyUAF.9GcQiK', '$2a$12$z/2YCeAeZe84d5hL6BSh8O', true);
