CREATE TABLE customer_addresses (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   street VARCHAR(255) NOT NULL,
   number INTEGER,
   neighbourhood VARCHAR(255) NOT NULL,
   city VARCHAR(100) NOT NULL,
   zip_code VARCHAR(8) NOT NULL,
   customer_id BIGINT NOT NULL,
   CONSTRAINT pk_customer_addresses PRIMARY KEY (id)
);

ALTER TABLE customer_addresses ADD CONSTRAINT FK_CUSTOMERADDRESS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);