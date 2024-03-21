ALTER TABLE restaurants ADD user_id BIGINT NOT NULL;
ALTER TABLE restaurants ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id);