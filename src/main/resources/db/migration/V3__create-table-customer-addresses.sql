CREATE TABLE customer_addresses (
  id BIGINT NOT NULL,
   street VARCHAR(255),
   number INTEGER,
   neighbourhood VARCHAR(255),
   city VARCHAR(100),
   zip_code VARCHAR(8),
   customer_id BIGINT,
   CONSTRAINT pk_customer_addresses PRIMARY KEY (id)
);

ALTER TABLE customer_addresses ADD CONSTRAINT FK_CUSTOMERADDRESS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);