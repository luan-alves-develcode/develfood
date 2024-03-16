CREATE TABLE restaurant_promotions (
  id BIGINT NOT NULL,
   restaurant_id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   percent FLOAT NOT NULL,
   initial_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   final_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   CONSTRAINT pk_restaurant_promotions PRIMARY KEY (id)
);

ALTER TABLE restaurant_promotions ADD CONSTRAINT FK_RESTAURANT_PROMOTIONS_ON_RESTAURANT FOREIGN KEY (restaurant_id) REFERENCES restaurants (id);