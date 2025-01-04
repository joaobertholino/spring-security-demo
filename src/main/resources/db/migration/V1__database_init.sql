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
	password VARCHAR(255),
	role     SMALLINT,
	CONSTRAINT pk_tb_user_auth PRIMARY KEY (username)
);

ALTER TABLE tb_product
	ADD CONSTRAINT uc_tb_product_product_name UNIQUE (product_name);