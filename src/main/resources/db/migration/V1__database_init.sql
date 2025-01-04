CREATE TABLE tb_product
(
	id            UUID           NOT NULL,
	product_name  VARCHAR(255)   NOT NULL,
	product_price DECIMAL(2, 10) NOT NULL,
	CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

ALTER TABLE tb_product
	ADD CONSTRAINT uc_tb_product_product_name UNIQUE (product_name);