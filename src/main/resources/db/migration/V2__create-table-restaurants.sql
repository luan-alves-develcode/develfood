CREATE TABLE restaurants (
  id BIGINT NOT NULL,
   name VARCHAR(100) NOT NULL,
   cnpj CHAR(14) NOT NULL,
   phone VARCHAR(18) NOT NULL,
   street VARCHAR(255) NOT NULL,
   number INTEGER,
   neighbourhood VARCHAR(255) NOT NULL,
   city VARCHAR(100) NOT NULL,
   zip_code VARCHAR(8) NOT NULL,
   CONSTRAINT pk_restaurants PRIMARY KEY (id)
);