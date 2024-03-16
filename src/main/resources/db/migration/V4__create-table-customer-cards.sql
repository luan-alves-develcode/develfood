CREATE TABLE customer_cards (
  id BIGINT NOT NULL,
   customer_id BIGINT NOT NULL,
   number INTEGER NOT NULL,
   valid_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   flag VARCHAR(255) NOT NULL,
   signature_code VARCHAR(255) NOT NULL,
   CONSTRAINT pk_customer_cards PRIMARY KEY (id)
);

ALTER TABLE customer_cards ADD CONSTRAINT FK_CUSTOMER_CARDS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);