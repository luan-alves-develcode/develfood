CREATE TABLE request_items (
  id BIGINT NOT NULL,
   request_id BIGINT NOT NULL,
   plate_id BIGINT NOT NULL,
   plate_name VARCHAR(255) NOT NULL,
   quantity INTEGER NOT NULL,
   price DECIMAL NOT NULL,
   observation VARCHAR(255),
   CONSTRAINT pk_request_items PRIMARY KEY (id)
);

ALTER TABLE request_items ADD CONSTRAINT FK_REQUEST_ITEMS_ON_PLATE FOREIGN KEY (plate_id) REFERENCES plates (id);

ALTER TABLE request_items ADD CONSTRAINT FK_REQUEST_ITEMS_ON_REQUEST FOREIGN KEY (request_id) REFERENCES requests (id);