CREATE TABLE tb_product
(
	id            UUID           NOT NULL,
	product_name  VARCHAR(255)   NOT NULL,
	product_price DECIMAL(10, 2) NOT NULL,
	CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

CREATE TABLE tb_user_auth
(
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role     SMALLINT NOT NULL,
	CONSTRAINT pk_tb_user_auth PRIMARY KEY (username)
);

ALTER TABLE tb_product ADD CONSTRAINT uc_tb_product_product_name UNIQUE (product_name);

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

INSERT INTO tb_user_auth (username, password, role)
VALUES ('JoaoB', '$2a$10$RvGSnHNlBjJqvNaxpDN5mO5dCOKVZL./WE87tmsoswfCZp0J8PJI6', 0);

INSERT INTO tb_user_auth (username, password, role)
VALUES ('EllenS', '$2a$10$RvGSnHNlBjJqvNaxpDN5mO5dCOKVZL./WE87tmsoswfCZp0J8PJI6', 1);

INSERT INTO tb_product (id, product_name, product_price)
VALUES (gen_random_uuid(), 'Redragon Lakshmi', 99.99);