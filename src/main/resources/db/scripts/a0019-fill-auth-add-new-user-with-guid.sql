--liquibase formatted sql
--changeset Sergey Lvov:a0019


INSERT INTO users (id, login, name, city_id, flag_guide_shown)
VALUES (3, 'adavydov123', 'Давыдов Антон Игоревич', 2, true);


INSERT INTO user_roles (user_id, role_id)
VALUES (3, 1);


INSERT INTO passwords (user_id, hash, salt, active)
VALUES (3, '$2a$12$z/2YCeAeZe84d5hL6BSh8O9YGpeDEw8NIQVZnm3dxiyUAF.9GcQiK', '$2a$12$z/2YCeAeZe84d5hL6BSh8O', true);