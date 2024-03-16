CREATE TABLE customer_favorite_plates (
  id BIGINT NOT NULL,
   customer_id BIGINT NOT NULL,
   plate_id BIGINT NOT NULL,
   CONSTRAINT pk_customer_favorite_plates PRIMARY KEY (id)
);

ALTER TABLE customer_favorite_plates ADD CONSTRAINT FK_CUSTOMER_FAVORITE_PLATES_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE customer_favorite_plates ADD CONSTRAINT FK_CUSTOMER_FAVORITE_PLATES_ON_PLATE FOREIGN KEY (plate_id) REFERENCES plates (id);