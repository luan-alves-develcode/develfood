CREATE TABLE restaurants (
  id BIGINT NOT NULL,
   name VARCHAR(100),
   cnpj CHAR(14),
   phone VARCHAR(18),
   street VARCHAR(255),
   number INTEGER,
   neighbourhood VARCHAR(255),
   city VARCHAR(100),
   zip_code VARCHAR(8),
   CONSTRAINT pk_restaurants PRIMARY KEY (id)
);