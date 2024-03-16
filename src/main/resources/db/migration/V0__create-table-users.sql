CREATE TABLE users (
  id BIGINT NOT NULL,
   email VARCHAR(255),
   password VARCHAR(255),
   login_date TIMESTAMP WITHOUT TIME ZONE,
   role SMALLINT,
   active BOOLEAN NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);