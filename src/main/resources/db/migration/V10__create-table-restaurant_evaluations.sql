CREATE TABLE restaurant_evaluations (
  id BIGINT NOT NULL,
   customer_id BIGINT NOT NULL,
   restaurant_id BIGINT NOT NULL,
   grade INTEGER NOT NULL,
   evaluation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   CONSTRAINT pk_restaurant_evaluations PRIMARY KEY (id)
);

ALTER TABLE restaurant_evaluations ADD CONSTRAINT FK_RESTAURANT_EVALUATIONS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE restaurant_evaluations ADD CONSTRAINT FK_RESTAURANT_EVALUATIONS_ON_RESTAURANT FOREIGN KEY (restaurant_id) REFERENCES restaurants (id);