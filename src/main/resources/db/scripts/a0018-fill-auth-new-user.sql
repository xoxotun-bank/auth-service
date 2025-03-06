--liquibase formatted sql
--changeset Sergey Lvov:a0018

INSERT INTO roles (id,name)
VALUES (2,'administrator');



INSERT INTO users (id,login,name,city_id,flag_guide_shown)
VALUES (2,'slvov123','Львов Сергей Николаевич',2,false);


INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);


INSERT INTO passwords (user_id, hash, salt, active)
VALUES (2, '$2a$12$z/2YCeAeZe84d5hL6BSh8O9YGpeDEw8NIQVZnm3dxiyUAF.9GcQiK', '$2a$12$z/2YCeAeZe84d5hL6BSh8O', true);