CREATE TABLE customers (
  id BIGINT NOT NULL,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(150),
   cpf CHAR(11),
   phone VARCHAR(18),
   user_id BIGINT,
   CONSTRAINT pk_customers PRIMARY KEY (id)
);

ALTER TABLE customers ADD CONSTRAINT uc_customers_user UNIQUE (user_id);

ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);